import { Injectable } from '@angular/core';
import { DayHorario } from '../../../../../model/horario/dayHorario';

@Injectable({
        providedIn: 'root'
})
export class RegistrarMatriculaService {

        constructor() { }

        public getHorarioMatricula(): DayHorario[] {
                return [
                        {
                                "day": "LUNES",
                                "cursos": [
                                        {
                                                "event": "química",
                                                "startTime": "07:30:00",
                                                "endTime": "08:50:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "08:50:00",
                                                "endTime": "09:10:00"
                                        },
                                        {
                                                "event": "aritmética",
                                                "startTime": "09:10:00",
                                                "endTime": "10:30:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "10:30:00",
                                                "endTime": "11:00:00"
                                        },
                                        {
                                                "event": "geometría",
                                                "startTime": "11:00:00",
                                                "endTime": "12:20:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "12:20:00",
                                                "endTime": "12:40:00"
                                        },
                                        {
                                                "event": "álgebra",
                                                "startTime": "12:40:00",
                                                "endTime": "14:00:00"
                                        }
                                ]
                        },
                        {
                                "day": "MARTES",
                                "cursos": [
                                        {
                                                "event": "razonamiento matemático",
                                                "startTime": "07:35:00",
                                                "endTime": "08:50:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "08:50:00",
                                                "endTime": "09:10:00"
                                        },
                                        {
                                                "event": "razonamiento verbal",
                                                "startTime": "09:10:00",
                                                "endTime": "10:30:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "10:30:00",
                                                "endTime": "11:00:00"
                                        },
                                        {
                                                "event": "literatura",
                                                "startTime": "11:00:00",
                                                "endTime": "12:20:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "12:20:00",
                                                "endTime": "12:40:00"
                                        },
                                        {
                                                "event": "comprensión lectora",
                                                "startTime": "12:40:00",
                                                "endTime": "14:00:00"
                                        }
                                ]
                        },
                        {
                                "day": "MIERCOLES",
                                "cursos": [
                                        {
                                                "event": "física",
                                                "startTime": "07:30:00",
                                                "endTime": "08:50:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "08:50:00",
                                                "endTime": "09:10:00"
                                        },
                                        {
                                                "event": "historia universal",
                                                "startTime": "09:10:00",
                                                "endTime": "10:30:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "10:30:00",
                                                "endTime": "11:00:00"
                                        },
                                        {
                                                "event": "cómputo",
                                                "startTime": "11:00:00",
                                                "endTime": "12:20:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "12:20:00",
                                                "endTime": "12:40:00"
                                        },
                                        {
                                                "event": "ingles",
                                                "startTime": "12:40:00",
                                                "endTime": "14:00:00"
                                        }
                                ]
                        },
                        {
                                "day": "JUEVES",
                                "cursos": [
                                        {
                                                "event": "biología",
                                                "startTime": "07:30:00",
                                                "endTime": "08:50:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "08:50:00",
                                                "endTime": "09:10:00"
                                        },
                                        {
                                                "event": "educación física",
                                                "startTime": "09:10:00",
                                                "endTime": "10:30:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "10:30:00",
                                                "endTime": "11:00:00"
                                        },
                                        {
                                                "event": "geografía",
                                                "startTime": "11:00:00",
                                                "endTime": "12:20:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "12:20:00",
                                                "endTime": "12:40:00"
                                        },
                                        {
                                                "event": "castellano",
                                                "startTime": "12:40:00",
                                                "endTime": "14:00:00"
                                        }
                                ]
                        },
                        {
                                "day": "VIERNES",
                                "cursos": [
                                        {
                                                "event": "ortografía",
                                                "startTime": "07:30:00",
                                                "endTime": "08:50:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "08:50:00",
                                                "endTime": "09:10:00"
                                        },
                                        {
                                                "event": "civica",
                                                "startTime": "09:10:00",
                                                "endTime": "10:30:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "10:30:00",
                                                "endTime": "11:00:00"
                                        },
                                        {
                                                "event": "historia del perú",
                                                "startTime": "11:00:00",
                                                "endTime": "12:20:00"
                                        },
                                        {
                                                "event": "Recreo",
                                                "startTime": "12:20:00",
                                                "endTime": "12:40:00"
                                        },
                                        {
                                                "event": "razonamiento matemático",
                                                "startTime": "12:40:00",
                                                "endTime": "14:00:00"
                                        }
                                ]
                        },
                        {
                                "day": "SABADO",
                                "cursos": []
                        },
                        {
                                "day": "DOMINGO",
                                "cursos": []
                        }
                ]
        }

}
