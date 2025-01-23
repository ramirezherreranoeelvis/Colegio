import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Curso } from '../../../model/cursos/curso';
import { CourseSectionCardComponent } from '../../molecules/course-section-card/course-section-card.component';
import { LineSeparatorComponent } from '../../atoms/line-separator/line-separator.component';
import { TextGradientComponent } from '../../atoms/text-gradient/text-gradient.component';

@Component({
        selector: 'course-content',
        standalone: true,
        imports: [
                CourseSectionCardComponent,
                 LineSeparatorComponent,
                 TextGradientComponent
                ],
        templateUrl: './course-content.component.html',
        styleUrl: './course-content.component.scss'
})
export class CourseContentComponent {
        @Input() course: Curso;
        @Input() rol: string;
        @Output() selectedResource = new EventEmitter<{ contenido: string, codigo: string }>();

        handleClick(event:{contenido: string, codigo: string | any}) {
                this.selectedResource.emit(event);
        }
}
