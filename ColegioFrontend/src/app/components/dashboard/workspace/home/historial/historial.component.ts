import { Component, OnInit } from '@angular/core';
import { HistorialService } from './historial.service';
import { SemanaHistorial } from '../../../../../model/semanaHistorial';

@Component(
	{
		selector: 'app-historial',
		standalone: true,
		imports: [],
		templateUrl: './historial.component.html',
		styleUrl: './historial.component.scss'
	}
)
export class HistorialComponent implements OnInit {

	constructor(private historialService: HistorialService) { }
	ngOnInit(): void {
		this.historialService.obtenerTemporadas("21787088").subscribe(
			(data: []) => {
				this.historial = data
			}
		);
	}
	ndias = 5
	historial: SemanaHistorial[] = null

}