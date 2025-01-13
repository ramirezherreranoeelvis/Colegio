import { CommonModule } from '@angular/common';
import { Component} from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NavButtonsComponent } from '../../../components/molecules/nav-buttons/nav-buttons.component';
import List from '../../../components/atoms/select-list/list';

declare var paypal;
@Component({
	selector: 'app-matricula',
	standalone: true,
	imports: [
		CommonModule,
		RouterOutlet,
		NavButtonsComponent
	],
	templateUrl: './matricula.component.html',
	styleUrl: './matricula.component.scss'
})
export class MatriculaComponent {
	routes: List[] = [
                { id: "/workspace/matricula/registrar-matricula", value: "registrar matricula" },
                { id: "/workspace/matricula/registrar-pago-matricula", value: "pago matricula" },
                { id: "/workspace/matricula/registrar-pago-mensual", value: "pago mensualidad" }
        ]
}
