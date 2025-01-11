import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Curso, RecursoContenidoCurso } from '../../../../model/cursos/curso';
import { CursoService } from './curso.service';
import { Temporada } from '../../../../model/Temporada';
import { TemporadaService } from '../../temporada.service';

import { firstValueFrom } from 'rxjs';
import { RecursoComponent } from '../../../../components/molecules/recurso/recurso.component';
import { CourseCardComponent } from '../../../../components/atoms/course-card/course-card.component';
import { CourseContentComponent } from '../../../../components/organisms/course-content/course-content.component';
import { MenuExitComponent } from '../../../../components/atoms/menu-exit/menu-exit.component';
import { TextGradientComponent } from '../../../../components/atoms/text-gradient/text-gradient.component';
import { SelectListComponent } from '../../../../components/atoms/select-list/select-list.component';
import List from '../../../../components/atoms/select-list/list';

@Component({
        selector: 'app-cursos',
        standalone: true,
        imports: [
                FormsModule,
                RecursoComponent,
                CourseCardComponent,
                CourseContentComponent,
                MenuExitComponent,
                TextGradientComponent,
                SelectListComponent
        ],
        templateUrl: './cursos.component.html',
        styleUrl: './cursos.component.scss'
})
export class CursosComponent implements OnInit {
        //diseño
        protected ver: string = "cursos";
        protected cursoCodeSelect: string = null;
        //metodos de diseño
        protected async verSeleccionado(contenido: string, codigo: string | any) {
                this.ver = contenido;
                if (codigo) {
                        if (this.ver == "curso") {
                                this.cursoCodeSelect = codigo;
                                try {
                                        this.cursoSelect = await firstValueFrom(this.cursoService.verCursoSeleccionadoByStudent(codigo, this.dniStudent));
                                } catch (error) {
                                        console.log(error)
                                }
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

        protected viewResource(event: { contenido: string, codigo: string | any }): void {
                this.verSeleccionado(event.contenido, event.codigo)
        }

        //datos:
        protected cursos: Curso[] = []
        protected nameFind = '';
        protected dniStudent = "21787088"
        protected temporadas: Temporada[]
        protected cursoSelect: Curso;
        protected recursoSelect: RecursoContenidoCurso;
        protected temporadasLst: List[]

        constructor(private cursoService: CursoService, private temporadaService: TemporadaService) { }

        public ngOnInit(): void {
                this.getSeasionByStudent();
        }

        async getSeasionByStudent() {
                try {
                        this.temporadas = await firstValueFrom(this.temporadaService.findAllSeasonByStudent(this.dniStudent));
                        
                        this.temporadasLst = this.temporadas.map((t) => {
                                return { id: t.year, value: t.year } as List
                        })
                } catch (error) {
                        console.log(error)
                }
        }


        protected async updateDataCoursesSelect(year:string) {
                if (year == "0") {
                        this.cursos.length = 0;
                        return;
                }
                try {
                        this.cursos = await firstValueFrom(this.cursoService.findCursosByStudentByYear(this.dniStudent, year));
                } catch (error) {
                        console.log(error)

                }
        }

}
