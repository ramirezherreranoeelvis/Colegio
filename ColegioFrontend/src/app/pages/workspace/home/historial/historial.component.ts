import { Component, OnInit } from '@angular/core';
import { HistorialService } from './historial.service';
import { SemanaHistorial } from '../../../../model/semanaHistorial';
import { firstValueFrom } from 'rxjs';
import { TableAttendanceHistoryComponent } from '../../../../components/atoms/table-attendance-history/table-attendance-history.component';

@Component(
	{
		selector: 'app-historial',
		standalone: true,
		imports: [TableAttendanceHistoryComponent],
		templateUrl: './historial.component.html',
		styleUrl: './historial.component.scss'
	}
)
export class HistorialComponent implements OnInit {

	constructor(private historialService: HistorialService) { }
	ngOnInit(): void {
		this.getTemporadas();
	}
	async getTemporadas() {
		try {
			this.historial = await firstValueFrom(this.historialService.obtenerTemporadas("21787088"))
		} catch (error) {
			console.error(error)
		}
	}
	ndias = 5
	historial: SemanaHistorial[] = null

}