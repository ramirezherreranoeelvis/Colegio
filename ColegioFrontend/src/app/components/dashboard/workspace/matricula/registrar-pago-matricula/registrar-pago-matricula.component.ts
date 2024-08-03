import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PaypalService } from '../paypal.service';
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { RegistrarPagoMatriculaService } from './registrar-pago-matricula.service';
import { Pago } from '../../../../../model/Pago';

@Component({
        selector: 'app-registrar-pago-matricula',
        standalone: true,
        imports: [],
        templateUrl: './registrar-pago-matricula.component.html',
        styleUrl: './registrar-pago-matricula.component.scss'
})
export class RegistrarPagoMatriculaComponent implements OnInit {

        protected pagosRealizados: any[] = [];
        protected dniParent: string = "99233923";
        protected students: StudentRegistrarMatricula[];
        protected studentSelect: StudentRegistrarMatricula;
        protected matriculaPendiente: Pago;

        constructor(private paypalService: PaypalService, private registrarPagoMatriculaService: RegistrarPagoMatriculaService) { }

        @ViewChild('paypal', { static: true }) paypalElement: ElementRef;

        public ngOnInit(): void {
                this.registrarPagoMatriculaService.getStudent(this.dniParent).subscribe(
                        (data: StudentRegistrarMatricula[]) => {
                                this.students = data;
                                this.studentSelect = data[0]
                                this.registrarPagoMatriculaService.obtenerDeudas(this.studentSelect.dni).subscribe(
                                        (data: Pago[]) => {
                                                this.matriculaPendiente = data.find(pago => pago.description === "Matricula");
                                                this.paypal(this.matriculaPendiente.pay)
                                        },
                                        (error) => {
                                                console.error('No se pudo obtener los pagos pendientes', error);
                                        }
                                )
                        },
                        (error) => {
                                console.error('Error fetching students', error);
                        }
                );
        }

        public updateDataStudentSelect(event: Event): void {
                const dni = (event.target as HTMLSelectElement).value
                this.studentSelect = this.students.find(s => s.dni == dni)
                this.registrarPagoMatriculaService.obtenerDeudas(this.studentSelect.dni).subscribe(
                        (data: Pago[]) => {
                                this.matriculaPendiente = data.find(pago => pago.description === "Matricula");
                                this.paypal(this.matriculaPendiente.pay)
                        },
                        (error) => {
                                console.error('No se pudo obtener los pagos pendientes', error);
                        }
                )
        }

        private paypal(pay: number): void {
                this.paypalService.loadPayPalScript().then(() => {
                        this.realizarPago(pay + "");
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
