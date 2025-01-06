import { CommonModule } from '@angular/common';
import { Component} from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

declare var paypal;
@Component({
	selector: 'app-matricula',
	standalone: true,
	imports: [
		CommonModule,
		RouterOutlet,
		RouterLink
	],
	templateUrl: './matricula.component.html',
	styleUrl: './matricula.component.scss'
})
export class MatriculaComponent {

}
