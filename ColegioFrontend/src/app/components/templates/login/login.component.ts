import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { LoginService } from './login.service';
import { User } from '../../../model/user';

@Component({
      selector: 'app-login',
      standalone: true,
      imports: [CommonModule, FormsModule],
      templateUrl: './login.component.html',
      styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
      protected contenedorActivo: number = 0;

      constructor(
            private router: Router,
            private loginService: LoginService,
      ) {}

      public goToSesion(form: NgForm) {
            const { username, password } = form.value;
            this.loginService.ingresarAlSistema(username, password).subscribe(
                  (userData: User) => {
                        if (!userData.accessEnabled) {
                              alert('Usted no tiene acceso al sistema');
                              return;
                        }
                        this.router.navigate(['dashboard']);
                  },
                  (error) => {
                        alert('No se pudo ingresar');
                        console.error(
                              'Error al obtener los datos del usuario:',
                              error,
                        );
                  },
            );
      }

      protected selectInputText(contenedor: number): void {
            this.contenedorActivo = contenedor;
      }
}
