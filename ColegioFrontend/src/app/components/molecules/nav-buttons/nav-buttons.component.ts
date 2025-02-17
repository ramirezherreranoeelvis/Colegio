import { Component, Input } from '@angular/core';
import List from '../../atoms/select-list/list';
import { RouterLink } from '@angular/router';

@Component({
        selector: 'nav-buttons',
        imports: [RouterLink],
        templateUrl: './nav-buttons.component.html',
        styleUrl: './nav-buttons.component.scss'
})
export class NavButtonsComponent {
        @Input() routes: List[];
}
