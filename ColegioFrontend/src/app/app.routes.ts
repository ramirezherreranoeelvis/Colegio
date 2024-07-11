import { Routes } from '@angular/router';
import { LoginComponent } from './components/Inicio/login/login.component';
import { DashboardComponent } from './components/contenido/dashboard/dashboard.component';

export const routes: Routes = [
    {
        path: '',
        component: LoginComponent
    },
    {
        path: 'login',
        title: 'login',
        component: LoginComponent
    },
    {
        path: 'dahsboard',
        title: 'dahsboard',
        component: DashboardComponent
    },
];
