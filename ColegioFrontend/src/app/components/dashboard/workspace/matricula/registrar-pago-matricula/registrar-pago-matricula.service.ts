import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudentRegistrarMatricula } from '../../../../../model/registrarMatricula/StudentRegistrarMatricula';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
        providedIn: 'root'
})
export class RegistrarPagoMatriculaService {
        private url: string = "http://localhost:8080/payment";
        private urlParent: string = "http://localhost:8080/parent";

        constructor(private httpClient: HttpClient) { }

        public getStudent(dniParent: string): Observable<StudentRegistrarMatricula[]> {
                const params = new HttpParams().set('dniParent', dniParent);
                const urlGetStudent = `${this.urlParent}/students`;
                return this.httpClient.get<StudentRegistrarMatricula[]>(urlGetStudent, { params }).pipe(
                        map(response => response)
                );
        }
}
