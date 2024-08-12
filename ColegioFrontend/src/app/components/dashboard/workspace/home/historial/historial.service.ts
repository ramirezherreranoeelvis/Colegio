import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
        providedIn: 'root'
})
export class HistorialService {
        private url = "http://localhost:8080/historial"

        constructor(private httpClient: HttpClient) {}
        
        public obtenerTemporadas(): Observable<[]> {
                return this.httpClient.get<[]>(this.url).pipe(
                        map(response => response)
                );
        }
}
