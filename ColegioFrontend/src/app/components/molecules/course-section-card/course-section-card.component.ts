import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ContenidoCurso } from '../../../model/cursos/curso';
import { ResourceCourseComponent } from '../../atoms/resource-course/resource-course.component';
import { LineSeparatorComponent } from '../../atoms/line-separator/line-separator.component';

@Component({
        selector: 'app-course-section-card',
        standalone: true,
        imports: [ResourceCourseComponent, LineSeparatorComponent],
        templateUrl: './course-section-card.component.html',
        styleUrl: './course-section-card.component.scss'
})
export class CourseSectionCardComponent {
        @Input() content: ContenidoCurso;
        @Output() selectedContent = new EventEmitter<{ contenido: string, codigo: string }>();

        handleClick(contenido: string, codigo: string | any) {
                this.selectedContent.emit({ contenido, codigo });
        }
}
