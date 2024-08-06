import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PaypalService } from '../../../../paypal/paypal.service';
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { RegistrarPagoMatriculaService } from './registrar-pago-matricula.service';
import { Pago } from '../../../../../model/Pago';
import { PaypalComponent } from '../../../../paypal/paypal.component';

@Component({
        selector: 'app-registrar-pago-matricula',
        standalone: true,
        imports: [PaypalComponent],
        templateUrl: './registrar-pago-matricula.component.html',
        styleUrl: './registrar-pago-matricula.component.scss'
})
export class RegistrarPagoMatriculaComponent implements OnInit {

        protected pagosRealizados: any[] = [];
        protected dniParent: string = "99233923";
        protected students: StudentRegistrarMatricula[];
        protected studentSelect: StudentRegistrarMatricula;
        protected matriculaPendiente: Pago;

        constructor(private registrarPagoMatriculaService: RegistrarPagoMatriculaService) { }

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
                const dni = (event.target as HTMLSelectElement).value;
                if (dni === "0") {
                        this.studentSelect = null;
                        this.matriculaPendiente = null; // Resetea el monto cuando no hay selección
                        return;
                }
                this.studentSelect = this.students.find(s => s.dni === dni);
                this.registrarPagoMatriculaService.obtenerDeudas(this.studentSelect.dni).subscribe(
                        (data: Pago[]) => {
                                this.matriculaPendiente = data.find(pago => pago.description === "Matricula");
                        },
                        (error) => {
                                console.error('No se pudo obtener los pagos pendientes', error);
                        }
                );
        }

        public cancelarPago(idPayment: number): void {
                this.registrarPagoMatriculaService.cancelarPago(idPayment).subscribe(
                        response => {
                                console.log(response);
                                alert('Pago cancelado exitosamente.');
                        },
                        error => {
                                console.error('Error al cancelar el pago', error);
                        }
                );
        }


}
