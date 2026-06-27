package xyz.jovanstoiljkovic.isa.controllers.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.jovanstoiljkovic.isa.dtos.RegisterDTO;
import xyz.jovanstoiljkovic.isa.dtos.user.UserDTO;
import xyz.jovanstoiljkovic.isa.dtos.login.LoginRequestDTO;
import xyz.jovanstoiljkovic.isa.dtos.login.LoginResponseDTO;
import xyz.jovanstoiljkovic.isa.services.UserService;
import xyz.jovanstoiljkovic.isa.services.authentication.AuthenticationService;

@RestController
@RequestMapping(value = {"/auth"})
@Profile("!no-security")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterDTO registerDTO){
        return userService.register(registerDTO).map(registered -> ResponseEntity.status(HttpStatus.CREATED).body(registered))
                .orElse(ResponseEntity.badRequest().build());
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginDTO){
        LoginResponseDTO response = authService.verify(loginDTO);
        if(response.getToken() == null) return ResponseEntity.status(401).build();

        return ResponseEntity.status(200).body(response);
    }
}
