import { Component } from '@angular/core';
import { RegistrarMatriculaService } from './registrar-matricula.service';


@Component({
        selector: 'app-registrar-matricula',
        standalone: true,
        templateUrl: './registrar-matricula.component.html',
        styleUrls: ['./registrar-matricula.component.scss']
})
export class RegistrarMatriculaComponent {
        protected horario = this.registrarMatricula.getHorarioMatricula();

        constructor(private registrarMatricula: RegistrarMatriculaService) {

        }

        protected getHorario() {
                const horarioTransformado = [];
                this.horario.forEach(day => {
                        day.cursos.forEach(curso => {
                                const existingHorario = horarioTransformado.find(h => h.startTime === curso.startTime && h.endTime === curso.endTime);
                                if (existingHorario) {
                                        existingHorario.cursos.push(curso.event);
                                } else {
                                        horarioTransformado.push({
                                                startTime: curso.startTime,
                                                endTime: curso.endTime,
                                                cursos: [curso.event]
                                        });
                                }
                        });
                });
                return horarioTransformado;
        }


}
