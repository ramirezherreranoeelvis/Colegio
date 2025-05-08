import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { IReport } from '../../../../../../model/report';

@Injectable({
      providedIn: 'root',
})
export class IncidentesService {
      private url = 'http://localhost:8080/incidentes';

      constructor(private httpClient: HttpClient) {}

      public obtenerIncidentes(dni: string): Observable<IReport[]> {
            const params = new HttpParams().set('dni', dni);
            return this.httpClient
                  .get<IReport[]>(this.url, { params })
                  .pipe(map((data) => data));
      }
}
