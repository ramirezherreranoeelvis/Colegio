import { Component } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
    selector: 'app-cursos',
    standalone: true,
    imports: [FormsModule],
    templateUrl: './cursos.component.html',
    styleUrl: './cursos.component.scss'
})
export class CursosComponent {
    protected cursos =
        [
            {
                "id": "1",
                "name": "Quimica",
                "year": "2021",
                "profesor": "Juan Perez",
                "portada": "https://th.bing.com/th/id/OIP.jJDC4qtOkTRMTvXNkxqAGwHaEJ?w=333&h=187&c=7&r=0&o=5&pid=1.7"
            },
            {
                "id": "2",
                "name": "Razonamiento Matematico",
                "year": "2021",
                "profesor": "Maria Lopez",
                "portada": "https://th.bing.com/th/id/OIP.9la3bj-7ElNWvOOg6c1qVgHaHa?w=186&h=186&c=7&r=0&o=5&pid=1.7"
            },
            {
                "id": "3",
                "name": "Literatura",
                "year": "2021",
                "profesor": "Carlos Ramirez",
                "portada": "https://th.bing.com/th/id/OIP.sUnkj2ZZSlQXIgyAORPXrQHaD4?w=269&h=180&c=7&r=0&o=5&pid=1.7"
            }
        ]
    protected nameFind = '';

}
