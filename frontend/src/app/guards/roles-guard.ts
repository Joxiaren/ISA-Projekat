import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from 'app/services/login-service';

export const rolesGuard: CanActivateFn = (route, state) => {
  let loginService = inject(LoginService);
  let router = inject(Router);

  if(loginService.validateRole(route.data["roles"], false)) return true;
  else if(loginService.token() === ""){
    return router.parseUrl("/login");
  }
  return router.parseUrl("/");
};
