import { Injectable } from '@angular/core';
import { DayHorario } from '../../../../../model/horario/dayHorario';
import { Student } from '../../../../../model/student';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
        providedIn: 'root'
})
export class RegistrarMatriculaService {
        private urlEnrollment: string = "http://localhost:8080/enrollment";

        constructor(private httpClient: HttpClient) { }

        public getHorarioMatricula(idEnrollment: number): Observable<DayHorario[]> {
                const params = new HttpParams().set('idEnrollment', idEnrollment.toString());
                const urlHorarioMatricula = `${this.urlEnrollment}/horario`;
                return this.httpClient.get<DayHorario[]>(urlHorarioMatricula, { params }).pipe(
                        map(response => response)
                );
        }

        public registrarMatricula(student: Student): Observable<string> {
                var idEnrollment: number = student.nextEnrollment.idEnrollment;
                var dniStudent: string = student.dni;
                const params = new HttpParams()
                        .set('dniStudent', dniStudent)
                        .set('idEnrollment', idEnrollment.toString());
                const urlRegistrarMatricula = `${this.urlEnrollment}/registrar`;
                return this.httpClient.post<string>(urlRegistrarMatricula, null, { params }).pipe(
                        map(response => response)
                );
        }
}
