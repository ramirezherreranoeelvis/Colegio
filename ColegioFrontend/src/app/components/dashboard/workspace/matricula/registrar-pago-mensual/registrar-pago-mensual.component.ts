import { Component, OnInit } from '@angular/core';
import { ParentService } from '../../parent.service';
import { PaymentService } from '../../../../payment/payment.service';
import { PaymentComponent } from "../../../../payment/payment.component";
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { Pago } from '../../../../../model/Pago';

@Component({
        selector: 'app-registrar-pago-mensual',
        standalone: true,
        imports: [PaymentComponent],
        templateUrl: './registrar-pago-mensual.component.html',
        styleUrl: './registrar-pago-mensual.component.scss'
})
export class RegistrarPagoMensualComponent implements OnInit {

        protected dniParent: string = "99233923";
        protected students: StudentRegistrarMatricula[];
        protected studentSelect: StudentRegistrarMatricula;
        protected mensualidadesPendientes: Pago[];
        protected pagoSelect: Pago;
        protected isDetalles:boolean = false;

        constructor(private paymentService: PaymentService, private parentService: ParentService) { }

        public ngOnInit(): void {
                this.parentService.getStudent(this.dniParent).subscribe(
                        (data: StudentRegistrarMatricula[]) => {
                                this.students = data;
                        },
                        (error) => {
                                console.error('Error fetching students', error);
                        }
                );
        }

        public updateDataStudentSelect(event: Event): void {
                this.isDetalles = false;
                const dni = (event.target as HTMLSelectElement).value;
                if (dni === "0") {
                        this.studentSelect = null;
                        this.mensualidadesPendientes = null; // Resetea el monto cuando no hay selección
                        return;
                }
                this.studentSelect = this.students.find(s => s.dni === dni);
                this.paymentService.obtenerDeudas(this.studentSelect.dni).subscribe(
                        (data: Pago[]) => {
                                this.mensualidadesPendientes = data.filter(pago => pago.description === "mensualidad");
                        },
                        (error) => {
                                console.error('No se pudo obtener los pagos pendientes', error);
                        }
                );
        }

        protected verDetalles(idPago: number) {
                this.pagoSelect = this.mensualidadesPendientes.find(pago => pago.idPago == idPago);
                this.isDetalles = true;
        }
}
