import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { AuthService } from '../../core/auth.service';
import { User } from '../../model/user';

@Injectable({
        providedIn: 'root'
})
export class LoginService {

        private url: string = "http://localhost:8080/login";

        constructor(private httpClient: HttpClient, private authService: AuthService) { }

        public ingresarAlSistema(username: string, password: string): Observable<User> {
                var usernameUrl = "username=" + username;
                var passwordUrl = "password=" + password

                return this.httpClient.get<User>(this.url + "?" + usernameUrl + "&" + passwordUrl)
                        .pipe(
                                map(user => {
                                        if (user.accessEnabled) {
                                                this.authService.setCurrentUser(user)
                                        }
                                        return user;
                                })
                        );
        }
}
