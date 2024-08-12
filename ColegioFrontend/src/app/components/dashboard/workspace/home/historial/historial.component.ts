import { Component, OnInit } from '@angular/core';
import { HistorialService } from './historial.service';

@Component({
	selector: 'app-historial',
	standalone: true,
	imports: [],
	templateUrl: './historial.component.html',
	styleUrl: './historial.component.scss'
})
export class HistorialComponent implements OnInit {

	constructor(private historialService: HistorialService) { }
	ngOnInit(): void {
		this.historialService.obtenerTemporadas().subscribe(
			(data: []) => {
				this.ch = data
			}
		);
	}
	ndias = 5
	historial = [
		{
			"name": "Semana Actual",
			"dias": [
				{
					name: "lunes",
					entrada: {
						content: "03/06/2024",
						status: ""
					},
					salida: {
						content: "03/06/2024",
						status: "asistio"
					},
					elementoFinal: false
				},
				{
					name: "martes",
					entrada: {
						content: "04/06/2024",
						status: ""
					},
					salida: {
						content: "04/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "miercoles",
					entrada: {
						content: "05/06/2024",
						status: ""
					},
					salida: {
						content: "05/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "jueves",
					entrada: {
						content: "06/06/2024",
						status: ""
					},
					salida: {
						content: "06/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "viernes",
					entrada: {
						content: "07/06/2024",
						status: ""
					},
					salida: {
						content: "07/06/2024",
						status: ""
					},
					elementoFinal: true
				}
			]
		},
		{
			"name": "Semana Pasada",
			"dias": [
				{
					name: "lunes",
					entrada: {
						content: "03/06/2024",
						status: ""
					},
					salida: {
						content: "03/06/2024",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "martes",
					entrada: {
						content: "04/06/2024",
						status: ""
					},
					salida: {
						content: "04/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "miercoles",
					entrada: {
						content: "05/06/2024",
						status: ""
					},
					salida: {
						content: "05/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "jueves",
					entrada: {
						content: "06/06/2024",
						status: ""
					},
					salida: {
						content: "06/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "viernes",
					entrada: {
						content: "07/06/2024",
						status: ""
					},
					salida: {
						content: "07/06/2024",
						status: ""
					},
					elementoFinal: true
				}
			]
		},
		{
			"name": "Semana Ante pasada",
			"dias": [
				{
					name: "lunes",
					entrada: {
						content: "03/06/2024",
						status: ""
					},
					salida: {
						content: "03/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "martes",
					entrada: {
						content: "04/06/2024",
						status: ""
					},
					salida: {
						content: "04/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "miercoles",
					entrada: {
						content: "05/06/2024",
						status: ""
					},
					salida: {
						content: "05/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "jueves",
					entrada: {
						content: "06/06/2024",
						status: ""
					},
					salida: {
						content: "06/06/2024",
						status: ""
					},
					elementoFinal: false
				},
				{
					name: "viernes",
					entrada: {
						content: "07/06/2024",
						status: ""
					},
					salida: {
						content: "07/06/2024",
						status: ""
					},
					elementoFinal: true
				}
			]
		}
	]

	x = [
		{
			"name": "Semana Actual",
			"dias": [
				{
					name: "lunes",
					entrada: {
						content: "2025/04/24",
						status: "asistio"
					},
					salida: {
						content: "2025/04/24",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "martes",
					entrada: {
						content: "2025/04/25",
						status: "asistio"
					},
					salida: {
						content: "2025/04/25",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "miercoles",
					entrada: {
						content: "2025/04/26",
						status: "asistio"
					},
					salida: {
						content: "2025/04/26",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "jueves",
					entrada: {
						content: "2025/04/27",
						status: "asistio"
					},
					salida: {
						content: "2025/04/27",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "viernes",
					entrada: {
						content: "2025/04/28",
						status: "asistio"
					},
					salida: {
						content: "2025/04/28",
						status: "falto"
					},
					elementoFinal: true
				}

			]
		},
		{
			"name": "Semana Pasada",
			"dias": [
				{
					name: "lunes",
					entrada: {
						content: "2025/04/17",
						status: "asistio"
					},
					salida: {
						content: "2025/04/17",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "martes",
					entrada: {
						content: "2025/04/18",
						status: "asistio"
					},
					salida: {
						content: "2025/04/18",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "miercoles",
					entrada: {
						content: "2025/04/19",
						status: "asistio"
					},
					salida: {
						content: "2025/04/19",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "jueves",
					entrada: {
						content: "2025/04/20",
						status: "asistio"
					},
					salida: {
						content: "2025/04/20",
						status: "falto"
					},
					elementoFinal: true
				}

			]
		},
		{
			"name": "Semana Ante pasada",
			"dias": [
				{
					name: "lunes",
					entrada: {
						content: "2025/04/10",
						status: "asistio"
					},
					salida: {
						content: "2025/04/10",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "martes",
					entrada: {
						content: "2025/04/11",
						status: "asistio"
					},
					salida: {
						content: "2025/04/11",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "miercoles",
					entrada: {
						content: "2025/04/12",
						status: "asistio"
					},
					salida: {
						content: "2025/04/12",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "jueves",
					entrada: {
						content: "2025/04/13",
						status: "asistio"
					},
					salida: {
						content: "2025/04/13",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "viernes",
					entrada: {
						content: "2025/04/14",
						status: "asistio"
					},
					salida: {
						content: "2025/04/14",
						status: "falto"
					},
					elementoFinal: true
				}

			]
		},
		{
			"name": "Semana 1",
			"dias": [
				{
					name: "lunes",
					entrada: {
						content: "2025/04/03",
						status: "asistio"
					},
					salida: {
						content: "2025/04/03",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "martes",
					entrada: {
						content: "2025/04/04",
						status: "asistio"
					},
					salida: {
						content: "2025/04/04",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "miercoles",
					entrada: {
						content: "2025/04/05",
						status: "asistio"
					},
					salida: {
						content: "2025/04/05",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "jueves",
					entrada: {
						content: "2025/04/06",
						status: "asistio"
					},
					salida: {
						content: "2025/04/06",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "viernes",
					entrada: {
						content: "2025/04/07",
						status: "asistio"
					},
					salida: {
						content: "2025/04/07",
						status: "falto"
					},
					elementoFinal: false
				},
				{
					name: "sabado",
					entrada: {
						content: "2025/04/08",
						status: "asistio"
					},
					salida: {
						content: "2025/04/08",
						status: "falto"
					},
					elementoFinal: true
				}

			]
		}
	]
	y = [
		{
			"name": "Semana 18",
			"dias": [
				{
					"name": "domingo",
					"entrada": {
						"content": "2025/04/27",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "lunes",
					"entrada": {
						"content": "2025/04/28",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				}
			]
		},
		{
			"name": "Semana 16",
			"dias": [
				{
					"name": "domingo",
					"entrada": {
						"content": "2025/04/13",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "lunes",
					"entrada": {
						"content": "2025/04/14",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "jueves",
					"entrada": {
						"content": "2025/04/17",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "viernes",
					"entrada": {
						"content": "2025/04/18",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "sábado",
					"entrada": {
						"content": "2025/04/19",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				}
			]
		},
		{
			"name": "Semana 17",
			"dias": [
				{
					"name": "domingo",
					"entrada": {
						"content": "2025/04/20",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "jueves",
					"entrada": {
						"content": "2025/04/24",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "viernes",
					"entrada": {
						"content": "2025/04/25",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "sábado",
					"entrada": {
						"content": "2025/04/26",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				}
			]
		},
		{
			"name": "Semana 14",
			"dias": [
				{
					"name": "jueves",
					"entrada": {
						"content": "2025/04/03",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "viernes",
					"entrada": {
						"content": "2025/04/04",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "sábado",
					"entrada": {
						"content": "2025/04/05",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				}
			]
		},
		{
			"name": "Semana 15",
			"dias": [
				{
					"name": "domingo",
					"entrada": {
						"content": "2025/04/06",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "lunes",
					"entrada": {
						"content": "2025/04/07",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "martes",
					"entrada": {
						"content": "2025/04/08",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "jueves",
					"entrada": {
						"content": "2025/04/10",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "viernes",
					"entrada": {
						"content": "2025/04/11",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				},
				{
					"name": "sábado",
					"entrada": {
						"content": "2025/04/12",
						"status": "asistio"
					},
					"salida": {
						"content": "",
						"status": "falto"
					},
					"elementoFinal": false
				}
			]
		}
	]

	ch = []
}
