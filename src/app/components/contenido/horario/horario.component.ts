import { Component, Renderer2 } from '@angular/core';

@Component({
    selector: 'app-horario',
    standalone: true,
    imports: [],
    templateUrl: './horario.component.html',
    styleUrl: './horario.component.scss'
})
export class HorarioComponent {
    constructor(private renderer: Renderer2) { }
    protected donwloadHorario(): void {
        
    }
}
