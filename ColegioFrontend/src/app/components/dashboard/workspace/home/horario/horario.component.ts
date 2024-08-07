import { Component, Renderer2 } from '@angular/core';
import { ParentService } from '../../parent.service';
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { Enrollment } from '../../../../../model/registrarMatricula/nextEnrollment';
import { TurnoHorario } from '../../../../../model/horario/turnoHorario';
import { HorarioService } from './horario.service';
import { DayHorario } from '../../../../../model/horario/dayHorario';
import { FormsModule } from '@angular/forms';
import { Temporada } from '../../../../../model/Temporada';

@Component({
        selector: 'app-horario',
        standalone: true,
        imports: [FormsModule],
        templateUrl: './horario.component.html',
        styleUrl: './horario.component.scss'
})
export class HorarioComponent {

        protected dniParent: string = "99233923";
        protected studentSelectDNI: string = "0";
        protected students: StudentRegistrarMatricula[];
        protected days: string[];
        protected horario: TurnoHorario[] = [];
        protected temporadas: Temporada[] = [];
        protected idTemporadaSelect = "0";

        constructor(private renderer: Renderer2, private parentService: ParentService, private horarioService: HorarioService) { }

        public ngOnInit(): void {
                this.parentService.getStudent(this.dniParent).subscribe(
                        (data: StudentRegistrarMatricula[]) => {
                                this.students = data;
                        },
                        (error) => {
                                console.error('Error fetching students', error);
                        }
                );
        }
        public updateDataStudentSelect(): void {
                //si no se escojio ninguno los datos se borran
                var studentSelect: StudentRegistrarMatricula;
                if (this.studentSelectDNI == "0") {
                        studentSelect = null;
                        return;
                }
                studentSelect = this.students.find(s => s.dni == this.studentSelectDNI)
                this.horarioService.obtenerTemporadas(studentSelect.dni).subscribe(
                        (t: Temporada[]) => {
                                this.temporadas = t
                        })

        }

        public updateHorario(): void {
                if (this.idTemporadaSelect == "0") {
                        this.horario = null
                        return;
                }
                var temporada: Temporada = this.temporadas.find(t => t.idSeason.toString() == this.idTemporadaSelect)
                this.horarioService.obtenerHorarioPorTemporada(temporada).subscribe((data: DayHorario[]) => {
                        //borramos los dias para volver a llenarlo:
                        this.days = []
                        this.days = data
                                .filter(horario => horario.cursos.length !== 0)
                                .map(horario => horario.day);

                        //borramos el horario para llenarlo:
                        this.horario = []
                        data.forEach(day => {
                                day.cursos.forEach(curso => {
                                        // Obtener solo la hora y el minuto
                                        const [startHour, startMinute] = curso.startTime.split(':');
                                        const [endHour, endMinute] = curso.endTime.split(':');
                                        const startTime = `${startHour}:${startMinute}`;
                                        const endTime = `${endHour}:${endMinute}`;

                                        const existingHorario = this.horario.find(h => h.startTime === startTime && h.endTime === endTime);
                                        if (existingHorario) {
                                                existingHorario.cursos.push(curso.event);
                                        } else {
                                                this.horario.push({
                                                        startTime: startTime,
                                                        endTime: endTime,
                                                        cursos: [curso.event]
                                                });
                                        }
                                });
                        });

                });
        }
        protected donwloadHorario(): void {

        }
}
