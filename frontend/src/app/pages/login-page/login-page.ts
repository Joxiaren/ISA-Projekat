import { Component, inject, signal, WritableSignal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'app/services/login-service';

@Component({
  selector: 'app-login-page',
  imports: [ReactiveFormsModule],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css',
})
export class LoginPage {
  loginService = inject(LoginService);
  router = inject(Router);
  loginWarning : WritableSignal<string> = signal("");

  form = new FormGroup({
    username: new FormControl(),
    password : new FormControl()
  });
  
  ngOnInit(): void {
    this.loginWarning.set("");
  }

  login(){
    if(!this.form.valid){
      this.loginWarning.set("Non valid form");
      return; 
    } 

    this.loginService.login(this.form.value).subscribe({
      "next": () => this.router.navigate(['']) ,
      "error": (res) => { 
        this.loginWarning.set("Wrong credentials");
      } 
    });
  }
}
