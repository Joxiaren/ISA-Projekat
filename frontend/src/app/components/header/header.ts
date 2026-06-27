import { Component, computed, inject, Signal } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { SearchBar } from 'app/components/search-bar/search-bar';
import { LoginService } from 'app/services/login-service';

@Component({
  selector: 'app-header',
  imports: [RouterLink, SearchBar],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  router = inject(Router);
  loginService = inject(LoginService);

  username: Signal<string> = computed(() => {
    if(this.loginService.payload() == null) return null;
    return this.loginService.payload()['sub'];
  });

  adminAccess : Signal<boolean> = computed(() => this.loginService.validateAuthority(['ADMIN'], true));


  logout(){
    this.loginService.logout();
    this.router.navigate(['login']);
  }
}
