import { Component } from '@angular/core';
import { CursosComponent } from '../cursos/cursos.component';
import { HistorialComponent } from '../historial/historial.component';
import { HorarioComponent } from '../horario/horario.component';
import { NotasGeneralesComponent } from '../notas-generales/notas-generales.component';
import { ReportesIncidentesComponent } from '../reportes-incidentes/reportes-incidentes.component';

@Component({
    selector: 'app-dashboard',
    standalone: true,
    imports: [
        CursosComponent,
        HistorialComponent,
        HorarioComponent,
        NotasGeneralesComponent,
        ReportesIncidentesComponent
    ],
    templateUrl: './dashboard.component.html',
    styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
    private _selectSection: number = 1;

    // Setter para actualizar _selectSection
    protected set selectSection(theSelectSection: number) {
        this._selectSection = theSelectSection;
    }

    // Getter para obtener el valor actual de _selectSection
    protected get selectSection(): number {
        return this._selectSection;
    }
}
