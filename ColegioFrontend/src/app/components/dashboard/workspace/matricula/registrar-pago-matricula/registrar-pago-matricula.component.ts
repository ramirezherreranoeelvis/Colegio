import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PaypalService } from '../paypal.service';
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { RegistrarPagoMatriculaService } from './registrar-pago-matricula.service';

@Component({
        selector: 'app-registrar-pago-matricula',
        standalone: true,
        imports: [],
        templateUrl: './registrar-pago-matricula.component.html',
        styleUrl: './registrar-pago-matricula.component.scss'
})
export class RegistrarPagoMatriculaComponent implements OnInit {

        public pagosRealizados: any[] = [];
        protected dniParent: string = "99233923";
        protected students: StudentRegistrarMatricula[];
        protected studentSelect: StudentRegistrarMatricula;

        constructor(private paypalService: PaypalService, private registrarPagoMatriculaService: RegistrarPagoMatriculaService) { }

        @ViewChild('paypal', { static: true }) paypalElement: ElementRef;

        public ngOnInit(): void {
                this.registrarPagoMatriculaService.getStudent(this.dniParent).subscribe(
                        (data: StudentRegistrarMatricula[]) => {
                                this.students = data;
                        },
                        (error) => {
                                console.error('Error fetching students', error);
                        }
                );
        }

        public updateDataStudentSelect(event: Event): void {
                const dni = (event.target as HTMLSelectElement).value
                if (dni == "0") {
                        this.studentSelect = null;
                        return;
                }
                this.studentSelect = this.students.find(s => s.dni == dni)
        }

        private paypal(): void {
                this.paypalService.loadPayPalScript().then(() => {
                        this.realizarPago('10.00');
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
