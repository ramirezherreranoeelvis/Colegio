import { Component, OnInit } from '@angular/core';
import { TemporadaService } from '../../temporada.service';
import { Temporada } from '../../../../../model/Temporada';
import { FormsModule } from '@angular/forms';

@Component({
        selector: 'app-notas-generales',
        standalone: true,
        imports: [FormsModule],
        templateUrl: './notas-generales.component.html',
        styleUrl: './notas-generales.component.scss'
})

export class NotasGeneralesComponent implements OnInit {
        protected temporadas: Temporada[];
        protected dniStudent = "21787088";
        protected year = "0";
        protected cursoNotas:CursoNotas[] = [
                {
                        curso: "Quimica",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Aritmética",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Geometría",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Álgebra",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Razonamiento Matemático",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Razonamiento Verbal	",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Literatura",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Comprensión Lectora",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Física",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Historia Universal",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Cómputo",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Ingles",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Biología",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Educación Física",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Geografía",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Castellano",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Ortografía",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Cívica",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Historia del Perú",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                },
                {
                        curso: "Razonamiento Matemático",
                        notas: [
                                {
                                        name: "Bimestre 1",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 2",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 3",
                                        nota: 17
                                },
                                {
                                        name: "Bimestre 4",
                                        nota: 17
                                },
                                {
                                        name: "Promedio",
                                        nota: 17
                                },
                        ]
                }
        ]
        constructor(private temporadaService: TemporadaService) { }

        public ngOnInit(): void {
                this.temporadaService.findAllSeasonByStudent(this.dniStudent).subscribe(
                        (data: Temporada[]) => {
                                this.temporadas = data
                        }
                )

        }

        protected updateDataCoursesSelect(): void { }
}
export interface CursoNotas{
        curso:string;
        notas:Notas[];
}
export interface Notas{
        name:string;
        nota:number;
}