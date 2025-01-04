import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';

@Component({
        selector: 'app-hamburger-menu',
        standalone: true,
        imports: [],
        templateUrl: './hamburger-menu.component.html',
        styleUrl: './hamburger-menu.component.scss'
})
export class HamburgerMenuComponent {
        @Output() clickMenu = new EventEmitter<void>();
        @ViewChild('menu') menu!: ElementRef;

        protected handleClick(): void {
                this.clickMenu.emit();
                const menuElement = this.menu.nativeElement;
                if (menuElement.classList.contains('menu__active')) {
                        menuElement.classList.remove('menu__active'); // Quitar clase
                } else {
                        menuElement.classList.add('menu__active'); // Agregar clase
                }
        }

}
