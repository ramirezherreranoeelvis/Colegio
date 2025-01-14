import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Curso } from '../../../model/cursos/curso';
import { CourseSectionCardComponent } from '../../molecules/course-section-card/course-section-card.component';
import { LineSeparatorComponent } from '../../atoms/line-separator/line-separator.component';

@Component({
        selector: 'course-content',
        standalone: true,
        imports: [CourseSectionCardComponent, LineSeparatorComponent],
        templateUrl: './course-content.component.html',
        styleUrl: './course-content.component.scss'
})
export class CourseContentComponent {
        @Input() course: Curso;
        @Output() selectedResource = new EventEmitter<{ contenido: string, codigo: string }>();

        handleClick(event:{contenido: string, codigo: string | any}) {
                this.selectedResource.emit(event);
        }
}
