import { Component, EventEmitter, Output } from '@angular/core';

@Component({
        selector: 'app-menu-exit',
        standalone: true,
        imports: [],
        templateUrl: './menu-exit.component.html',
        styleUrl: './menu-exit.component.scss'
})
export class MenuExitComponent {
        @Output() exit = new EventEmitter<void>();
        handleClick() {
                this.exit.emit();
        }
}
