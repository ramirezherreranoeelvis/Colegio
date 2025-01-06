import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Temporada } from '../../model/Temporada';
import { map, Observable } from 'rxjs';

@Injectable({
        providedIn: 'root'
})
export class TemporadaService {
        private url = "http://localhost:8080/temporada";
        
        constructor(private httpCLient: HttpClient) { }

        public findAllSeasonByStudent(dniStudent: string): Observable<Temporada[]> {
                const params: HttpParams = new HttpParams().set("dniStudent", dniStudent)
                return this.httpCLient.get<Temporada[]>(this.url, { params });
        }

}
