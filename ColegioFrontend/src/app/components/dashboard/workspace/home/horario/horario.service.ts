import { Injectable } from '@angular/core';
import { DayHorario } from '../../../../../model/horario/dayHorario';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Temporada } from '../../../../../model/Temporada';

@Injectable({
        providedIn: 'root'
})
export class HorarioService {
        private urlEnrollment: string = "http://localhost:8080/enrollment";
        private url: string = "http://localhost:8080/horario";

        constructor(private httpClient: HttpClient) { }

        public obtenerHorarioPorTemporada(idSeason: number, dniStudent: string): Observable<DayHorario[]> {
                const urlHorarioMatricula = `${this.url}/horario`;
                const params = new HttpParams().set('idSeason', idSeason).set('dniStudent', dniStudent);
                return this.httpClient.get<DayHorario[]>(urlHorarioMatricula, { params }).pipe(
                        map(response => response)
                );
        }

        public obtenerTemporadas(dniStudent: string): Observable<Temporada[]> {
                const params = new HttpParams().set('dniStudent', dniStudent);
                const urlTemporadas = `${this.url}/temporadas`;
                return this.httpClient.get<Temporada[]>(urlTemporadas, { params }).pipe(
                        map(response => response)
                );
        }

        public getHorarioMatricula(idEnrollment: number): Observable<DayHorario[]> {
                const params = new HttpParams().set('idEnrollment', idEnrollment.toString());
                const urlHorarioMatricula = `${this.urlEnrollment}/horario`;
                return this.httpClient.get<DayHorario[]>(urlHorarioMatricula, { params }).pipe(
                        map(response => response)
                );
        }
}
