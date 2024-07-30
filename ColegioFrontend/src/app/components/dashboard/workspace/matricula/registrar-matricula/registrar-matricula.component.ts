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
                var horarioTransformado = [
                        {
                                "startTime": "07:30:00",
                                "endTime": "08:50:00"
                        },
                        {
                                "startTime": "08:50:00",
                                "endTime": "09:10:00"
                        },
                        {
                                "startTime": "09:10:00",
                                "endTime": "10:30:00"
                        },
                        {
                                "startTime": "10:30:00",
                                "endTime": "11:00:00"
                        },
                        {
                                "startTime": "11:00:00",
                                "endTime": "12:20:00"
                        },
                        {
                                "startTime": "12:20:00",
                                "endTime": "12:40:00"
                        },
                        {
                                "startTime": "12:40:00",
                                "endTime": "14:00:00"
                        },
                        {
                                "startTime": "07:35:00",
                                "endTime": "08:50:00"
                        }
                ]
                return horarioTransformado
        }


}
