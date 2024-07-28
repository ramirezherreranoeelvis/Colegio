import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { User } from './model/user';

@Component({
        selector: 'app-root',
        standalone: true,
        imports: [
                CommonModule,
                RouterOutlet,
                RouterLink
        ],
        templateUrl: './app.component.html',
        styleUrls: ['./app.component.scss']
})
export class AppComponent {
        
        public user: User;

}