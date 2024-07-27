import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NotasGeneralesComponent } from './components/home/workspace/home/notas-generales/notas-generales.component';
import { HorarioComponent } from './components/home/workspace/home/horario/horario.component';
import { HistorialComponent } from './components/home/workspace/home/historial/historial.component';
import { CursosComponent } from './components/home/workspace/home/cursos/cursos.component';
import { ReportesIncidentesComponent } from './components/home/workspace/home/reportes-incidentes/reportes-incidentes.component';

import { MatriculaComponent } from './components/home/workspace/matricula/matricula.component';
import { WorkspaceComponent } from './components/home/workspace/workspace.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
        {
                path: '',
                redirectTo: 'login',
                pathMatch: 'full'
        },
        {
                path: 'login',
                title: 'login',
                component: LoginComponent
        },
        {
                path: 'workspace',
                title: 'workspace',
                component: WorkspaceComponent
        },
        {
                path: 'home',
                title: 'home',
                component: HomeComponent,
                children: [
                        {
                                path: '',
                                redirectTo: 'horario',
                                pathMatch: 'full'
                        },
                        {
                                path: 'cursos',
                                title: 'cursos',
                                component: CursosComponent
                        },
                        {
                                path: 'historial',
                                title: 'historial',
                                component: HistorialComponent
                        },
                        {
                                path: 'horario',
                                title: 'horario',
                                component: HorarioComponent
                        },
                        {
                                path: 'notas-generales',
                                title: 'notas generales',
                                component: NotasGeneralesComponent
                        },
                        {
                                path: 'reportes-incidentes',
                                title: 'reportes incidentes',
                                component: ReportesIncidentesComponent
                        },
                ]
        },
        {
                path: 'matrcicula',
                title: 'matricula',
                component: MatriculaComponent,
                children: []
        }
];
