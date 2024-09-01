import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Promedio } from '../../../../../model/notas/promedio';

@Injectable({
        providedIn: 'root'
})
export class NotasService {

        private url: string = "http://localhost:8080/notas";

        constructor(private httpClient: HttpClient) { }

        protected obtenerPromediosGenerales(dniStudent: string, year: string): Observable<Promedio[]> {
                const urlPromedioGeneral = `${this.url}/promedios`;
                const params = new HttpParams().set('dniStudent', dniStudent).set('year', year);
                return this.httpClient.get<Promedio[]>(urlPromedioGeneral, { params });
        }

}
