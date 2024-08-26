import { Component, OnInit } from '@angular/core';
import { TemporadaService } from '../../temporada.service';
import { Temporada } from '../../../../../model/Temporada';
import { FormsModule } from '@angular/forms';

@Component({
        selector: 'app-notas-generales',
        standalone: true,
        imports: [FormsModule],
        templateUrl: './notas-generales.component.html',
        styleUrl: './notas-generales.component.scss'
})
export class NotasGeneralesComponent implements OnInit {
        protected temporadas: Temporada[];
        protected dniStudent = "21787088";
        protected year = "0";
        constructor(private temporadaService: TemporadaService) { }

        public ngOnInit(): void {
                this.temporadaService.findAllSeasonByStudent(this.dniStudent).subscribe(
                        (data: Temporada[]) => {
                                this.temporadas = data
                        }
                )

        }

        protected updateDataCoursesSelect(): void { }
}
