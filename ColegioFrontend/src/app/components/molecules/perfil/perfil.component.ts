import { Component, EventEmitter, Input, Output } from '@angular/core';
import { LineSeparatorComponent } from '../../atoms/line-separator/line-separator.component';
import List from '../../atoms/select-list/list';

@Component({
        selector: 'perfil',
        imports: [],
        templateUrl: './perfil.component.html',
        styleUrl: './perfil.component.scss'
})
export class PerfilComponent {
        @Input() user: User = new User("Alberto Edu Alanya Suarez", "12345678", "AAlanyaSu");
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