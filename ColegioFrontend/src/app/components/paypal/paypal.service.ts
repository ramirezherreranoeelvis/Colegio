import { Injectable, ElementRef } from '@angular/core';

declare var paypal

@Injectable({
        providedIn: 'root'
})
export class PaypalService {

        constructor() { }

        public loadPayPalScript(): Promise<void> {
                return new Promise((resolve, reject) => {
                        const script = document.createElement('script');
                        script.src = 'https://www.paypal.com/sdk/js?client-id=AZ3ZMyV0QjkOid1JQnGFWmz-NXDL2hpmVbhu1NwVe6xgeT-2wr2q2lKNOYf8R4zNmrmDBgUnWw2kQIMH';
                        script.onload = () => resolve();
                        script.onerror = () => reject(new Error('PayPal script load error'));
                        document.body.appendChild(script);
                });
        }

        public renderizarBotonPaypal(elementRef: ElementRef, monto: string, onPagoAprobado: (detalles: any) => void, onPagoError: (err: any) => void): void {
                paypal.Buttons({
                        style: {
                                layout: 'horizontal'
                        },
                        createOrder: (data, actions) => {
                                return actions.order.create({
                                        purchase_units: [{
                                                amount: {
                                                        value: monto
                                                }
                                        }]
                                });
                        },
                        onApprove: (data, actions) => {
                                return actions.order.capture().then(details => {
                                        onPagoAprobado(details);
                                });
                        },
                        onError: (err) => {
                                onPagoError(err);
                        }
                }).render(elementRef.nativeElement);
        }
}
