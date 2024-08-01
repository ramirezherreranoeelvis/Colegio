import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PaypalService } from '../paypal.service';

@Component({
        selector: 'app-registrar-pago-matricula',
        standalone: true,
        imports: [],
        templateUrl: './registrar-pago-matricula.component.html',
        styleUrl: './registrar-pago-matricula.component.scss'
})
export class RegistrarPagoMatriculaComponent implements OnInit {

        public pagosRealizados: any[] = [];

        constructor(private paypalService: PaypalService) { }

        @ViewChild('paypal', { static: true }) paypalElement: ElementRef;
        
        public ngOnInit(): void {
                this.paypalService.loadPayPalScript().then(() => {
                        this.realizarPago('10.00'); // Monto inicial a pagar
                }).catch(err => {
                        console.error('PayPal script could not be loaded.', err);
                });
        }
        protected realizarPago(monto: string): void {
                this.paypalService.renderizarBotonPaypal(
                        this.paypalElement,
                        monto,
                        this.registrarPago.bind(this),
                        this.handlePagoError.bind(this)
                );
        }

        protected registrarPago(detalles: any): void {
                this.pagosRealizados.push(detalles);
                alert('Pago realizado con éxito. Gracias ' + detalles.payer.name.given_name);
        }
        protected handlePagoError(err: any): void {
                console.error('Error durante el pago', err);
        }
}
