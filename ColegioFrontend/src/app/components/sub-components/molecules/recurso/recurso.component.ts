import { Component, Input, OnInit } from '@angular/core';
import { RecursoContenidoCurso } from '../../../../model/cursos/curso';

@Component({
        selector: 'app-recurso',
        standalone: true,
        imports: [],
        templateUrl: './recurso.component.html',
        styleUrl: './recurso.component.scss'
})
export class RecursoComponent implements OnInit {

        @Input() recurso: RecursoContenidoCurso;

        ngOnInit(): void {
        }


}
