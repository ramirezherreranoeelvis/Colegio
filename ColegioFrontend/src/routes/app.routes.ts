import { Routes } from '@angular/router';
import { LoginComponent } from '../app/pages/login/login.component';
import { WorkspaceComponent } from '../app/pages/workspace/workspace.component';
import { workspace } from './workspace.routes';
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
                children: workspace
        }
];