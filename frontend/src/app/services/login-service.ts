import { HttpClient } from '@angular/common/http';
import { computed, inject, Injectable, signal, WritableSignal } from '@angular/core';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  token : WritableSignal<string> = signal(""); 
  
  payload = computed( () =>{
    let tokenValue = this.token();  

    if(tokenValue == undefined || tokenValue === "") return null
    return JSON.parse(atob(this.token().split('.')[1])) 
  });

  http = inject(HttpClient);

  constructor(){
    let t = localStorage.getItem("token");

    if(t !== null){
      this.token.set(t);

    }
  }

  login(user: any){
    return this.http.post("http://localhost:3000/login", {username: user.username, password: user.password}).pipe(
      tap((r:any) => {
        this.token.set(r["token"]);
        localStorage.setItem("token", this.token())
      })
    );
  }

  getRoles(){
    if(this.payload() == undefined) return null;
    return this.payload()["roles"];
  }

  getUsername(){
    if(this.payload() == undefined) return null;
    return this.payload();
  }

  validateToken(){
    if(this.payload() == undefined) return false;

    let expTime = new Date(this.payload()['exp'] * 1000);
    let currentTime = new Date();

    if(expTime < currentTime) {
      this.logout();
      return false;
    }

    return true;
  }
  
  validateRole(roles: any, all: boolean){
    if(!this.validateToken()) return false;
    let userRoles = this.getRoles();

    if(userRoles != null){
      let skupRoles = new Set(roles);
      let skupUserRoles = new Set(userRoles);

      let result = skupRoles.intersection(skupUserRoles);

      if(all && result.size === roles.size) return true;
      else if( !all && result.size > 0) return true; 

      return true;
    }
    
    return false;
  }

  logout(){
    localStorage.removeItem("token");
    this.token.set("");
  }
}
