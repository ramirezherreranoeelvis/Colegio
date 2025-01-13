import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Student } from '../../../../model/student';
import { Pago } from '../../../..//model/Pago';
import { ParentService } from '../../parent.service';
import { PaymentComponent } from '../../../../components/atoms/payment/payment.component';
import { PaymentService } from '../../../../components/atoms/payment/payment.service';
import { TextGradientComponent } from '../../../../components/atoms/text-gradient/text-gradient.component';
import { SelectListComponent } from '../../../../components/atoms/select-list/select-list.component';
import List from '../../../../components/atoms/select-list/list';
import { firstValueFrom } from 'rxjs';


@Component({
        selector: 'app-registrar-pago-matricula',
        standalone: true,
        imports: [
                PaymentComponent,
                TextGradientComponent,
                SelectListComponent
        ],
        templateUrl: './registrar-pago-matricula.component.html',
        styleUrl: './registrar-pago-matricula.component.scss'
})
export class RegistrarPagoMatriculaComponent implements OnInit {

        protected dniParent: string = "99233923";
        protected students: Student[];
        protected studentSelect: Student;
        protected matriculaPendiente: Pago;
        stutentList: List[]
        constructor(private paymentService: PaymentService, private parentService: ParentService) { }

        public ngOnInit(): void {
                this.getStudents();
        }
        async getStudents() {
                try {
                        this.students = await firstValueFrom(this.parentService.getStudent(this.dniParent));
                        this.stutentList = this.students.map(student => {
                                return {
                                        id: student.dni,
                                        value: `${student.name} ${student.surnamePaternal} ${student.surnameMaternal}`
                                }
                        })
                } catch (error) {
                        console.error('Error fetching students', error);
                }
        }

        public updateDataStudentSelect(dni: string): void {
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
