import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { User } from './model/user';
import { CourseCardComponent } from './components/sub-components/atoms/course-card/course-card.component';

@Component({
        selector: 'app-root',
        standalone: true,
        imports: [
                CommonModule,
                RouterOutlet,
                RouterLink,
                CourseCardComponent
        ],
        templateUrl: './app.component.html',
        styleUrls: ['./app.component.scss']
})
export class AppComponent {
        
        public user: User;

}