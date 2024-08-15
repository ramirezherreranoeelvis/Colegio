import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../../../../../model/curso';
import { map } from 'rxjs/operators'

@Injectable({
        providedIn: 'root'
})
export class CursoService {
        
        private url = "http://localhost:8080/cursos";
        constructor(private httpCLient: HttpClient) { }

        public findCursosByStudentByYear(dniStudent: string, year: string): Observable<Curso[]> {
                const params: HttpParams = new HttpParams().set("dni", dniStudent).set("year", year)
                return this.httpCLient.get<Curso[]>(this.url, { params }).pipe(
                        map(response => response)
                );
        }
}
