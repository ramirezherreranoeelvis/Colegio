import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
      selector: 'app-workspace',
      standalone: true,
      imports: [CommonModule, RouterOutlet],
      templateUrl: './workspace.component.html',
      styleUrl: './workspace.component.scss',
})
export class WorkspaceComponent {}
