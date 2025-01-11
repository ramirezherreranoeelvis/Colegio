import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import List from './list';

@Component({
        selector: 'app-select-list',
        imports: [FormsModule],
        template: `
        <select name="year" id="select" [(ngModel)]="itemSelect" (change)="updateDataCoursesSelect()">
                <option selected [value]="0">{{default}}</option>
                @for (item of items; track $index) {
                        <option [value]="item.id">{{item.value}}</option>
                }
        </select>
        `,
        styleUrls: ['./select-list.component.scss']
})
export class SelectListComponent {
        @Input() default: string;
        @Input() items: List[];
        @Output() changeElement = new EventEmitter<string>();
        itemSelect = "0";

        updateDataCoursesSelect() {
                this.changeElement.emit(this.itemSelect)
        }
}
