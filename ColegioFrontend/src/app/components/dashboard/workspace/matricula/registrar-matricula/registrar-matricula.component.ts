import { Component, OnInit, NgModule } from '@angular/core';
import { RegistrarMatriculaService } from './registrar-matricula.service';
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { Enrollment } from '../../../../../model/registrarMatricula/nextEnrollment';
import { FormsModule } from '@angular/forms';
import { DayHorario } from '../../../../../model/horario/dayHorario';
import { TurnoHorario } from '../../../../../model/horario/turnoHorario';



@Component({
        selector: 'app-registrar-matricula',
        standalone: true,
        imports: [FormsModule],
        templateUrl: './registrar-matricula.component.html',
        styleUrls: ['./registrar-matricula.component.scss']
})
export class RegistrarMatriculaComponent implements OnInit {

        protected dniParent: string = "99233923";
        protected studentSelectDNI: string;
        protected studentSelect: StudentRegistrarMatricula;
        protected matricula: Enrollment;
        protected students: StudentRegistrarMatricula[];
        protected days: string[];
        protected horario: TurnoHorario[] = [];

        public ngOnInit(): void {
                this.registrarMatriculaService.getStudent(this.dniParent).subscribe(
                        (data: StudentRegistrarMatricula[]) => {
                                this.students = data;
                        },
                        (error) => {
                                console.error('Error fetching students', error);
                        }
                );
        }

        constructor(private registrarMatriculaService: RegistrarMatriculaService) {

        }

        public registrarMatricula(): void {
                alert(this.studentSelect.dni)
                if (this.studentSelect) {
                        this.registrarMatriculaService.registrarMatricula(this.studentSelect).subscribe(
                                message => {
                                        alert(message);
                                },
                                error => {
                                        console.log(error)
                                        alert(error.error);
                                }
                        );
                } else {
                        alert("Seleccione un Estudiante para matricular")
                }
        }

        public updateDataStudentSelect(): void {
                //si no se escojio ninguno los datos se borran
                if (this.studentSelectDNI == "0") {
                        this.studentSelect = null;
                        this.matricula = null;
                        return;
                }
                this.studentSelect = this.students.find(s => s.dni == this.studentSelectDNI)
                this.matricula = this.studentSelect.nextEnrollment
                this.registrarMatriculaService.getHorarioMatricula(8).subscribe((data: DayHorario[]) => {
                        //borramos los dias para volver a llenarlo:
                        this.days = []
                        this.days = data
                                .filter(horario => horario.cursos.length !== 0)
                                .map(horario => horario.day);

                        //borramos el horario para llenarlo:
                        this.horario = []
                        data.forEach(day => {
                                day.cursos.forEach(curso => {
                                        const existingHorario = this.horario.find(h => h.startTime === curso.startTime && h.endTime === curso.endTime);
                                        if (existingHorario) {
                                                existingHorario.cursos.push(curso.event);
                                        } else {
                                                this.horario.push({
                                                        startTime: curso.startTime,
                                                        endTime: curso.endTime,
                                                        cursos: [curso.event]
                                                });
                                        }
                                });
                        });
                });
        }

}
