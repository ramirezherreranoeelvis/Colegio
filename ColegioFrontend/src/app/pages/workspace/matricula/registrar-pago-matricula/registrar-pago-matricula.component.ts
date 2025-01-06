import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Student } from '../../../../model/student';
import { Pago } from '../../../..//model/Pago';
import { ParentService } from '../../parent.service';
import { PaymentComponent } from '../../../../components/atoms/payment/payment.component';
import { PaymentService } from '../../../../components/atoms/payment/payment.service';


@Component({
        selector: 'app-registrar-pago-matricula',
        standalone: true,
        imports: [PaymentComponent],
        templateUrl: './registrar-pago-matricula.component.html',
        styleUrl: './registrar-pago-matricula.component.scss'
})
export class RegistrarPagoMatriculaComponent implements OnInit {

        protected dniParent: string = "99233923";
        protected students: Student[];
        protected studentSelect: Student;
        protected matriculaPendiente: Pago;

        constructor(private paymentService: PaymentService, private parentService: ParentService) { }

        public ngOnInit(): void {
                this.parentService.getStudent(this.dniParent).subscribe(
                        (data: Student[]) => {
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
                this.paymentService.obtenerDeudas(this.studentSelect.dni).subscribe(
                        (data: Pago[]) => {
                                this.matriculaPendiente = data.find(pago => pago.description === "Matricula");
                        },
                        (error) => {
                                console.error('No se pudo obtener los pagos pendientes', error);
                        }
                );
        }




}
