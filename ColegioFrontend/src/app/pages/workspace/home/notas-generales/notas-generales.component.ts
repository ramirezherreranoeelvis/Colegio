import { Component, OnInit } from '@angular/core';
import { TemporadaService } from '../../temporada.service';
import { FormsModule } from '@angular/forms';
import { NotasService } from './notas.service';
import { Promedios } from '../../../../model/notas/promedios';
import { SelectListComponent } from '../../../../components/atoms/select-list/select-list.component';
import { firstValueFrom } from 'rxjs';
import List from '../../../../components/atoms/select-list/list';
import { TextGradientComponent } from '../../../../components/atoms/text-gradient/text-gradient.component';

@Component({
        selector: 'app-notas-generales',
        standalone: true,
        imports: [
                FormsModule,
                SelectListComponent,
                TextGradientComponent
        ],
        templateUrl: './notas-generales.component.html',
        styleUrl: './notas-generales.component.scss'
})

export class NotasGeneralesComponent implements OnInit {
        protected temporadasList: List[];
        protected dniStudent = "21787088";
        protected cursoNotas: Promedios;

        constructor(private temporadaService: TemporadaService, private notasService: NotasService) { }

        public ngOnInit(): void {
                this.getTemporadas();

        }
        protected async getTemporadas() {
                try {
                        const temporadas = await firstValueFrom(this.temporadaService.findAllSeasonByStudent(this.dniStudent));
                        this.temporadasList = temporadas.map((t) => {
                                return { id: t.year, value: t.year } as List
                        });
                } catch (error) {
                        error(error);
                }
        }

        protected async updateDataCoursesSelect(year: string) {
                if (year == "0") {
                        this.cursoNotas = null;
                        return
                };
                try {
                        this.cursoNotas = await firstValueFrom(this.notasService.obtenerPromediosGenerales(this.dniStudent, year));
                } catch (error) {
                        error(error);
                }
        }
}