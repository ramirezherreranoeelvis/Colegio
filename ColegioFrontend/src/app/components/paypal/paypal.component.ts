import { Component, ElementRef, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { PaypalService } from './paypal.service';

@Component({
        selector: 'app-paypal',
        standalone: true,
        imports: [],
        templateUrl: './paypal.component.html',
        styleUrl: './paypal.component.scss'
})
export class PaypalComponent implements OnInit, OnChanges {

        protected pagosRealizados: any[] = [];
        @Input() dinero: any;

        @ViewChild('paypal', { static: true }) paypalElement: ElementRef;
        constructor(private paypalService: PaypalService) { }

        ngOnInit(): void {
                this.paypalService.loadPayPalScript().then(() => {
                        this.realizarPago(this.dinero);
                }).catch(err => {
                        console.error('PayPal script could not be loaded.', err);
                });
        }

        ngOnChanges(changes: SimpleChanges): void {
                if (changes['dinero'] && changes['dinero'].currentValue) {
                        this.paypalService.loadPayPalScript().then(() => {
                                this.realizarPago(this.dinero);
                        }).catch(err => {
                                console.error('PayPal script could not be loaded.', err);
                        });
                }
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
