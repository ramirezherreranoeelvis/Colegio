import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NavButtonsComponent } from '../../../components/molecules/nav-buttons/nav-buttons.component';
import List from '../../../components/atoms/select-list/list';

@Component({
        selector: 'app-home',
        standalone: true,
        imports: [
                CommonModule,
                RouterOutlet,
                NavButtonsComponent
        ],
        templateUrl: './home.component.html',
        styleUrl: './home.component.scss'
})
export class HomeComponent {
        routes: List[] = [
                { id: "/workspace/home/horario", value: "horario" },
                { id: "/workspace/home/reportes-incidentes", value: "incidentes" },
                { id: "/workspace/home/cursos", value: "cursos" },
                { id: "/workspace/home/historial", value: "historial de ingreso" },
                { id: "/workspace/home/notas-generales", value: "Notas Generales" }
        ]
}
