import { Component, OnInit } from '@angular/core';
import { ParentService } from '../../parent.service';
import { Student } from '../../../../model/student';
import { Pago } from '../../../../model/Pago';
import { PaymentComponent } from '../../../../components/atoms/payment/payment.component';
import { PaymentService } from '../../../../components/atoms/payment/payment.service';
import List from '../../../../components/atoms/select-list/list';
import { firstValueFrom } from 'rxjs';
import { SelectListComponent } from '../../../../components/atoms/select-list/select-list.component';
import { TextGradientComponent } from '../../../../components/atoms/text-gradient/text-gradient.component';

@Component({
        selector: 'app-registrar-pago-mensual',
        standalone: true,
        imports: [PaymentComponent, TextGradientComponent,
                SelectListComponent],
        templateUrl: './registrar-pago-mensual.component.html',
        styleUrl: './registrar-pago-mensual.component.scss'
})
export class RegistrarPagoMensualComponent implements OnInit {

        protected dniParent: string = "99233923";
        protected students: Student[];
        protected studentSelect: Student;
        protected mensualidadesPendientes: Pago[];
        protected pagoSelect: Pago;
        protected isDetalles: boolean = false;
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
        public updateDataStudentSelect(DNI: string): void {
                this.isDetalles = false;
                if (DNI === "0") {
                        this.studentSelect = null;
                        this.mensualidadesPendientes = null; // Resetea el monto cuando no hay selección
                        return;
                }
                this.studentSelect = this.students.find(s => s.dni === DNI);
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
