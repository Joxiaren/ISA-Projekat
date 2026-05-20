package xyz.jovanstoiljkovic.isa.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import xyz.jovanstoiljkovic.isa.dtos.login.LoginRequestDTO;
import xyz.jovanstoiljkovic.isa.dtos.login.LoginResponseDTO;

@Service
@Profile("!no-security")
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTService jwtService;

    public LoginResponseDTO verify(LoginRequestDTO loginRequestDTO){
        LoginResponseDTO loginResponse = new LoginResponseDTO();
        try{
            Authentication auth = authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
            if(auth.isAuthenticated()) loginResponse.setToken(jwtService.generateToken(loginRequestDTO.getUsername()));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return loginResponse;
    }

}
