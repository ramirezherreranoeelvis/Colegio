import { Injectable } from '@angular/core';
import { DayHorario } from '../../../../../model/horario/dayHorario';
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
        providedIn: 'root'
})
export class RegistrarMatriculaService {
        private url: string = "http://localhost:8080/enrollment";

        constructor(private httpClient: HttpClient) { }

        public getHorarioMatricula(idEnrollment: number): Observable<DayHorario[]> {
                const params = new HttpParams().set('idEnrollment', idEnrollment.toString());
                const urlHorarioMatricula = `${this.url}/horario-matricula`;
                return this.httpClient.get<DayHorario[]>(urlHorarioMatricula, { params }).pipe(
                        map(response => response)
                );
        }

        public getStudent(dniParent: string): Observable<StudentRegistrarMatricula[]> {
                const params = new HttpParams().set('dniParent', dniParent);
                const urlGetStudent = `${this.url}/students`;
                return this.httpClient.get<StudentRegistrarMatricula[]>(urlGetStudent, { params }).pipe(
                        map(response => response)
                );
        }

        public registrarMatricula(student: StudentRegistrarMatricula): Observable<string> {
                var idEnrollment: number = student.nextEnrollment.idEnrollment;
                var dniStudent: string = student.dni;
                const params = new HttpParams()
                        .set('dniStudent', dniStudent)
                        .set('idEnrollment', idEnrollment.toString());
                const urlRegistrarMatricula = `${this.url}/registrar-matricula`;
                return this.httpClient.post<string>(urlRegistrarMatricula, null, { params }).pipe(
                        map(response => response)
                );
        }
}
