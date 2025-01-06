import { Component, OnInit } from '@angular/core';
import { IncidentesService } from './incidentes.service';
import { Student } from '../../../../model/student';
import { FormsModule } from '@angular/forms';
import { ParentService } from '../../parent.service';
import { Report } from '../../../../model/report';

@Component({
        selector: 'app-reportes-incidentes',
        standalone: true,
        imports: [FormsModule],
        templateUrl: './reportes-incidentes.component.html',
        styleUrl: './reportes-incidentes.component.scss'
})
export class ReportesIncidentesComponent implements OnInit {


        protected dniParent: string = "99233923";
        protected studentSelectDNI: string = "0";
        protected students: Student[] = [];
        protected reportes: Report[] = [];

        constructor(private incidentesService: IncidentesService, private parentService: ParentService) { }


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

        public updateDataStudentSelect(): void {
                //si no se escojio ninguno los datos se borran
                if (this.studentSelectDNI == "0") {
                        return;
                }
                this.incidentesService.obtenerIncidentes(this.studentSelectDNI).subscribe(
                        (data: Report[]) => {
                                this.reportes = data;
                        }
                )
        }
}
