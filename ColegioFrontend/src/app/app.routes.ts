import { Routes } from '@angular/router';
import { DashboardComponent } from './components/templates/dashboard/dashboard.component';
import { CursosComponent } from './components/templates/dashboard/workspace/home/cursos/cursos.component';
import { HistorialComponent } from './components/templates/dashboard/workspace/home/historial/historial.component';
import { HomeComponent } from './components/templates/dashboard/workspace/home/home.component';
import { HorarioComponent } from './components/templates/dashboard/workspace/home/horario/horario.component';
import { NotasGeneralesComponent } from './components/templates/dashboard/workspace/home/notas-generales/notas-generales.component';
import { ReportesIncidentesComponent } from './components/templates/dashboard/workspace/home/reportes-incidentes/reportes-incidentes.component';
import { MatriculaComponent } from './components/templates/dashboard/workspace/matricula/matricula.component';
import { RegistrarMatriculaComponent } from './components/templates/dashboard/workspace/matricula/registrar-matricula/registrar-matricula.component';
import { RegistrarPagoMatriculaComponent } from './components/templates/dashboard/workspace/matricula/registrar-pago-matricula/registrar-pago-matricula.component';
import { RegistrarPagoMensualComponent } from './components/templates/dashboard/workspace/matricula/registrar-pago-mensual/registrar-pago-mensual.component';
import { LoginComponent } from './components/templates/login/login.component';


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
                path: 'dashboard',
                title: 'dashboard',
                component: DashboardComponent,
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
