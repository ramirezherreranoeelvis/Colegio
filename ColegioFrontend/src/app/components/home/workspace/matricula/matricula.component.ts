import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

declare var paypal;
@Component({
	selector: 'app-matricula',
	standalone: true,
	imports: [],
	templateUrl: './matricula.component.html',
	styleUrl: './matricula.component.scss'
})
export class MatriculaComponent implements OnInit {

	@ViewChild('paypal', { static: true }) paypaElement: ElementRef;
	protected producto = {
		description: 'producto en venta',
		precio: 599.99,
		img: 'imagen de tu producto'
	}
	protected title: string = "angular-paypal-payment"

	ngOnInit(): void {
		paypal
			.Buttons({
				createOrder: (data, actions) => {
					return actions.order.create({
						purchase_units: [
							{
								description: this.producto.description,
								amount: {
									currency_code: 'PEN',
									value: this.producto.precio
								}
							}
						]
					})
				},
				onApprove: async (data, actions) => {
					const order = await actions.order.capture();
					console.log(order)
				},
				onError: err => {
					console.log();
				}
			})
			.render(this.paypaElement.nativeElement);
	}

}
