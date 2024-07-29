import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
	selector: 'app-perfil',
	standalone: true,
	imports: [
		CommonModule,
		RouterOutlet,
		RouterLink
	],
	templateUrl: './perfil.component.html',
	styleUrl: './perfil.component.scss'
})
export class PerfilComponent {
	protected user: User = new User("Alberto Edu Alanya Suarez", "12345678", "AAlanyaSu");
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
