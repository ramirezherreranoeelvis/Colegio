import { Component, Input, OnInit } from '@angular/core';

@Component({
        selector: 'app-text-gradient',
        imports: [],
        templateUrl: './text-gradient.component.html',
        styleUrl: './text-gradient.component.scss'
})
export class TextGradientComponent {
        @Input() text: string;
}
