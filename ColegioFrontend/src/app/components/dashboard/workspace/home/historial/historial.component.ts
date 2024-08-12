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
				this.historial = data
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

}
