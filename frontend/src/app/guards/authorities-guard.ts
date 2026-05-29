import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from 'app/services/login-service';

export const authoritiesGuard: CanActivateFn = (route, state) => {
  let loginService = inject(LoginService);
  let router = inject(Router);

  if(loginService.validateAuthority(route.data['authorities'], false)) return true;
  else if(loginService.token() === ""){
    return router.parseUrl("/login");
  }
  return router.parseUrl("/");
};
