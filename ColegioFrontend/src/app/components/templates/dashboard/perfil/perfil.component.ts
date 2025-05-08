import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { RouterLink } from '@angular/router';
import { HamburgerMenuComponent } from '../../../atoms/hamburger-menu/hamburger-menu.component';

@Component({
      selector: 'app-perfil',
      standalone: true,
      imports: [CommonModule, RouterLink, HamburgerMenuComponent],
      templateUrl: './perfil.component.html',
      styleUrl: './perfil.component.scss',
})
export class PerfilComponent {
      protected user: IUser = {
            name: 'Alberto Edu Alanya Suarez',
            dni: '12345678',
            user: 'AAlanyaSu',
      };

      @ViewChild('perfilSection') perfilSection!: ElementRef;

      toggleMenu() {
            const perfilElement = this.perfilSection.nativeElement;
            if (perfilElement.classList.contains('noVisible')) {
                  perfilElement.classList.remove('noVisible'); // Quitar clase
            } else {
                  perfilElement.classList.add('noVisible'); // Agregar clase
            }
      }
}
interface IUser {
      name: string;
      dni: string;
      user: string;
}
