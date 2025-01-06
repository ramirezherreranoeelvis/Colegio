import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { WorkspaceComponent } from './pages/workspace/workspace.component';
import { HomeComponent } from './pages/workspace/home/home.component';
import { CursosComponent } from './pages/workspace/home/cursos/cursos.component';
import { HistorialComponent } from './pages/workspace/home/historial/historial.component';
import { HorarioComponent } from './pages/workspace/home/horario/horario.component';
import { NotasGeneralesComponent } from './pages/workspace/home/notas-generales/notas-generales.component';
import { ReportesIncidentesComponent } from './pages/workspace/home/reportes-incidentes/reportes-incidentes.component';
import { MatriculaComponent } from './pages/workspace/matricula/matricula.component';
import { RegistrarMatriculaComponent } from './pages/workspace/matricula/registrar-matricula/registrar-matricula.component';
import { RegistrarPagoMatriculaComponent } from './pages/workspace/matricula/registrar-pago-matricula/registrar-pago-matricula.component';
import { RegistrarPagoMensualComponent } from './pages/workspace/matricula/registrar-pago-mensual/registrar-pago-mensual.component';


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
                component: WorkspaceComponent,
                children: [
                        {
                                path: '',
                                redirectTo: 'home',
                                pathMatch: 'full'
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
                                        }
                                ]
                        },
                        {
                                path: 'matricula',
                                title: 'matricula',
                                component: MatriculaComponent,
                                children: [
                                        {
                                                path: '',
                                                redirectTo: 'registrar-pago-matricula',
                                                pathMatch: 'full'
                                        },
                                        {
                                                path: 'registrar-matricula',
                                                title: 'registrar-matricula',
                                                component: RegistrarMatriculaComponent
                                        },
                                        {
                                                path: 'registrar-pago-matricula',
                                                title: 'registrar-pago-matricula',
                                                component: RegistrarPagoMatriculaComponent
                                        },
                                        {
                                                path: 'registrar-pago-mensual',
                                                title: 'registrar-pago-mensual',
                                                component: RegistrarPagoMensualComponent
                                        }
                                ]
                        }
                ]

        }
];
