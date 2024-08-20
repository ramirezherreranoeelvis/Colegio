import { Component, OnInit } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { Curso } from '../../../../../model/cursos/curso';
import { CursoService } from './curso.service';
import { Temporada } from '../../../../../model/Temporada';
import { TemporadaService } from '../../temporada.service';

@Component({
        selector: 'app-cursos',
        standalone: true,
        imports: [FormsModule],
        templateUrl: './cursos.component.html',
        styleUrl: './cursos.component.scss'
})
export class CursosComponent implements OnInit {
        //diseño
        protected verCursos: boolean = false;
        //metodos de diseño
        verCursoSeleccionado(codigo: string) {
                this.verCursos = this.verCursos == true ? false : true;
                if (codigo == "0") {
                        return;
                }
                this.cursoService.verCursoSeleccionado(codigo).subscribe(
                        (curso: Curso) => {
                                this.cursoSelect = curso
                        }
                )
        }

        //datos:
        protected cursos: Curso[] = []
        protected nameFind = '';
        protected dniStudent = "21787088"
        protected year = "0"
        protected temporadas: Temporada[]
        protected cursoSelect: Curso;

        constructor(private cursoService: CursoService, private temporadaService: TemporadaService) { }

        public ngOnInit(): void {
                this.temporadaService.findAllSeasonByStudent(this.dniStudent).subscribe(
                        (data: Temporada[]) => {
                                this.temporadas = data
                        }
                )
                this.cursoService.verCursoSeleccionado("00000000000001").subscribe(
                        (curso: Curso) => {
                                this.cursoSelect = curso
                        }
                )

        }

        protected updateDataCoursesSelect(): void {
                if (this.year == "0") {
                        this.cursos.length = 0;
                        return;
                }
                this.cursoService.findCursosByStudentByYear(this.dniStudent, this.year).subscribe(
                        (data: Curso[]) => {
                                this.cursos = data
                        }
                );
        }


}
