import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { LoginService } from '../services/login-service';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  let loginService = inject(LoginService);

  if(loginService.token() != ""){
    let newReq = req.clone({
      headers: req.headers.append("Authorization", loginService.token())
    })
    
    return next(newReq);
  }

  return next(req);
};
