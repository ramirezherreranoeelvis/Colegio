import { Component, OnInit } from '@angular/core';
import { TemporadaService } from '../../temporada.service';
import { FormsModule } from '@angular/forms';
import { NotasService } from './notas.service';
import { Promedios } from '../../../../../../model/notas/promedios';
import { Temporada } from '../../../../../../model/Temporada';

@Component({
      selector: 'app-notas-generales',
      standalone: true,
      imports: [FormsModule],
      templateUrl: './notas-generales.component.html',
      styleUrl: './notas-generales.component.scss',
})
export class NotasGeneralesComponent implements OnInit {
      protected temporadas: Temporada[];
      protected dniStudent = '21787088';
      protected year = '0';
      protected cursoNotas: Promedios;

      constructor(
            private temporadaService: TemporadaService,
            private notasService: NotasService,
      ) {}

      public ngOnInit(): void {
            this.temporadaService
                  .findAllSeasonByStudent(this.dniStudent)
                  .subscribe((data: Temporada[]) => {
                        this.temporadas = data;
                  });
      }

      protected updateDataCoursesSelect(): void {
            this.notasService
                  .obtenerPromediosGenerales(this.dniStudent, this.year)
                  .subscribe(
                        (data: Promedios) => {
                              this.cursoNotas = data;
                        },
                        (error) => {
                              this.cursoNotas = null;
                        },
                  );
      }
}
