import { Component } from '@angular/core';
import { MatriculaComponent } from "./matricula/matricula.component";
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
        selector: 'app-workspace',
        standalone: true,
        imports: [
                CommonModule,
                RouterOutlet,
                RouterLink,
                MatriculaComponent
        ],
        templateUrl: './workspace.component.html',
        styleUrl: './workspace.component.scss'
})
export class WorkspaceComponent {

}
