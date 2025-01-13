import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import List from './list';

@Component({
        selector: 'app-select-list',
        imports: [FormsModule],
        template: `
        <select name="year" id="select" [(ngModel)]="itemSelect" (change)="updateDataCoursesSelect()" [class]="styleSelect">
                <option selected [value]="0" [class]="styleOption">{{default}}</option>
                @for (item of items; track $index) {
                        <option [value]="item.id" [class]="styleOption">{{item.value}}</option>
                }
        </select>
        `,
        styleUrls: ['./select-list.component.scss']
})
export class SelectListComponent {
        @Input() default: string;
        @Input() items: List[];
        @Output() changeElement = new EventEmitter<string>();
        @Input() styleSelect: string;
        @Input() styleOption: string;
        itemSelect = "0";

        updateDataCoursesSelect() {
                this.changeElement.emit(this.itemSelect)
        }
}
