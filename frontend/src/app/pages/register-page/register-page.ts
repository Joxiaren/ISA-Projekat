import { Component, inject, runInInjectionContext, signal, WritableSignal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'app/services/login-service';

@Component({
  selector: 'app-register-page',
  imports: [ReactiveFormsModule],
  templateUrl: './register-page.html',
  styleUrl: './register-page.css',
})
export class RegisterPage {
  loginService = inject(LoginService);
  router = inject(Router);
  registerWarning : WritableSignal<string> = signal("");

  form = new FormGroup({
    username: new FormControl(),
    password: new FormControl(),
    confirmPassword: new FormControl()
  });

  ngOnInit(): void{
    this.registerWarning.set("");
  }

  register(){
    if(!this.form.valid){
      this.registerWarning.set("Non valid form");
      return;
    }
    let registerUser = this.form.value;
    if (registerUser.password != registerUser.confirmPassword){
      this.registerWarning.set("Passwords don't match");
      return;
    }
    this.loginService.register(registerUser).subscribe({
      "next": () => this.router.navigate(['']),
      "error": (res) => {
          this.registerWarning.set("Could not register user");
      }
    });
  }
}
