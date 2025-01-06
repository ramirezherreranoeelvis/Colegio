import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { RouterLink } from '@angular/router';
import { HamburgerMenuComponent } from '../../../components/atoms/hamburger-menu/hamburger-menu.component';
import { LineSeparatorComponent } from '../../../components/atoms/line-separator/line-separator.component';

@Component({
	selector: 'app-perfil',
	standalone: true,
	imports: [
		CommonModule,
		RouterLink,
		HamburgerMenuComponent,
		LineSeparatorComponent
	],
	templateUrl: './perfil.component.html',
	styleUrl: './perfil.component.scss'
})
export class PerfilComponent {
	protected user: User = new User("Alberto Edu Alanya Suarez", "12345678", "AAlanyaSu");

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
class User {
	private _name: string = "";
	private _dni: string = "";
	private _user: string = "";

	public constructor(name: string, dni: string, user: string) {
		this._name = name;
		this._dni = dni;
		this._user = user;
	}

	public get name(): string {
		return this._name;
	}
	public get dni(): string {
		return this._dni;
	}
	public get user(): string {
		return this._user;
	}

}
