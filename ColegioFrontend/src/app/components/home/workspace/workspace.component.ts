import { Component } from '@angular/core';
import { MatriculaComponent } from "./matricula/matricula.component";

@Component({
  selector: 'app-workspace',
  standalone: true,
  imports: [MatriculaComponent],
  templateUrl: './workspace.component.html',
  styleUrl: './workspace.component.scss'
})
export class WorkspaceComponent {

}
