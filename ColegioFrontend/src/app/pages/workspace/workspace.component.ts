import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PerfilComponent } from './perfil/perfil.component';

@Component({
        selector: 'app-home',
        standalone: true,
        imports: [
                CommonModule,
                PerfilComponent,
                RouterOutlet
        ],
        templateUrl: './workspace.component.html',
        styleUrl: './workspace.component.scss'
})
export class WorkspaceComponent {

}
