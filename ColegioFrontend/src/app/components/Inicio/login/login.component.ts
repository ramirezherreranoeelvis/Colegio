import { CommonModule, NgClass } from '@angular/common';
import { Component, NgModule } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
        selector: 'app-login',
        standalone: true,
        imports: [
                CommonModule,
                FormsModule
        ],
        templateUrl: './login.component.html',
        styleUrl: './login.component.scss'
})
export class LoginComponent {
        public username: string = "";
        public password: string = "";

        constructor(private router: Router) { }

        protected goToSesion(form: NgForm) {
                this.router.navigate(['home']);
        }

        //styles:
        /* sombra en click */
        protected contenedorActivo: number = 0;
        protected selectInputText(contenedor: number): void {
                this.contenedorActivo = contenedor;
        }
}
