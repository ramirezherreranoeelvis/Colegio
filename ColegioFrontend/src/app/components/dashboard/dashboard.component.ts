import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PerfilComponent } from './perfil/perfil.component';
import { WorkspaceComponent } from "./workspace/workspace.component";
@Component({
        selector: 'app-home',
        standalone: true,
        imports: [
                CommonModule,
                RouterOutlet,
                RouterLink,
                PerfilComponent,
                WorkspaceComponent
        ],
        templateUrl: './dashboard.component.html',
        styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
        
}
