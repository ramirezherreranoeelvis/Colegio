import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../../../../../model/cursos/curso';
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

        public verCursoSeleccionado(codigoCurso: string): Observable<Curso> {
                const params: HttpParams = new HttpParams().set("code", codigoCurso)
                const url: string = `${this.url}/curso`
                return this.httpCLient.get<Curso>(url, { params }).pipe(map(response => response));
        }
        public verCursoSeleccionadoByStudent(codigoCurso: string, dniStudent: string): Observable<Curso> {
                const params: HttpParams = new HttpParams().set("code", codigoCurso).set("dni", dniStudent)
                const url: string = `${this.url}/cursoByStudent`
                return this.httpCLient.get<Curso>(url, { params }).pipe(map(response => response));
        }
}
