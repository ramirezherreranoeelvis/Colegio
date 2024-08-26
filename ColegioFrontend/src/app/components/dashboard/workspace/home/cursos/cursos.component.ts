import { Component, OnInit } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { Curso, RecursoContenidoCurso } from '../../../../../model/cursos/curso';
import { CursoService } from './curso.service';
import { Temporada } from '../../../../../model/Temporada';
import { TemporadaService } from '../../temporada.service';
import { RecursoComponent } from './recurso/recurso.component';

@Component({
        selector: 'app-cursos',
        standalone: true,
        imports: [FormsModule, RecursoComponent],
        templateUrl: './cursos.component.html',
        styleUrl: './cursos.component.scss'
})
export class CursosComponent implements OnInit {
        //diseño
        protected ver: string = "cursos";
        protected cursoCodeSelect: string = null;
        //metodos de diseño
        protected verSeleccionado(contenido: string, codigo: string | any) {
                this.ver = contenido;
                if (codigo != null) {
                        if (this.ver == "curso") {
                                this.cursoCodeSelect = codigo;
                                this.cursoService.verCursoSeleccionadoByStudent(codigo, this.dniStudent).subscribe(
                                        (curso: Curso) => {
                                                this.cursoSelect = curso
                                        }
                                )
                        } else if (this.ver == "recurso") {
                                this.recursoSelect = codigo
                        }
                } else {
                        if (this.ver == "curso") {
                                alert("No hay un curso seleccionado")
                                this.ver = "cursos";
                        } else if (this.ver == "recurso") {
                                alert("No hay un recurso seleccionado")
                                this.ver = "cursos";
                        } else if (this.ver == "cursos") {
                                this.cursoCodeSelect = null;
                        }
                }
        }

        //datos:
        protected cursos: Curso[] = []
        protected nameFind = '';
        protected dniStudent = "21787088"
        protected year = "0"
        protected temporadas: Temporada[]
        protected cursoSelect: Curso;
        protected recursoSelect: RecursoContenidoCurso

        constructor(private cursoService: CursoService, private temporadaService: TemporadaService) { }

        public ngOnInit(): void {
                this.temporadaService.findAllSeasonByStudent(this.dniStudent).subscribe(
                        (data: Temporada[]) => {
                                this.temporadas = data
                        }
                )
                this.ver = "cursos"
                this.cursoCodeSelect = "00000000000001";
                this.cursoService.verCursoSeleccionadoByStudent("00000000000001", this.dniStudent).subscribe(
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
