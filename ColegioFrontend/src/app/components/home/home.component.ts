import { Component } from '@angular/core';
/* import { CursosComponent } from './cursos/cursos.component';
import { HistorialComponent } from './historial/historial.component';
import { HorarioComponent } from './horario/horario.component';
import { NotasGeneralesComponent } from './notas-generales/notas-generales.component';
import { ReportesIncidentesComponent } from './reportes-incidentes/reportes-incidentes.component'; */
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PerfilComponent } from './perfil/perfil.component';
@Component({
        selector: 'app-home',
        standalone: true,
        imports: [
                CommonModule,
                RouterOutlet,
                RouterLink,
/*                 CursosComponent,
                HistorialComponent,
                HorarioComponent,
                NotasGeneralesComponent,
                ReportesIncidentesComponent, */
                PerfilComponent
        ],
        templateUrl: './home.component.html',
        styleUrl: './home.component.scss'
})
export class HomeComponent {

}
