import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RecursoContenidoCurso } from '../../../../model/cursos/curso';

@Component({
        selector: 'app-resource-course',
        standalone: true,
        imports: [],
        templateUrl: './resource-course.component.html',
        styleUrl: './resource-course.component.scss'
})
export class ResourceCourseComponent {
        @Input() resource: RecursoContenidoCurso;
        @Output() selectedContent = new EventEmitter<void>();
        handleClick() {
                this.selectedContent.emit();
        }
}
