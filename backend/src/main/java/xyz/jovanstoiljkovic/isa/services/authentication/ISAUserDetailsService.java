package xyz.jovanstoiljkovic.isa.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.jovanstoiljkovic.isa.models.User;
import xyz.jovanstoiljkovic.isa.models.UserPrincipal;
import xyz.jovanstoiljkovic.isa.repositories.UserRepository;

@Service
public class ISAUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepo.findByUsername(username);

        if(user == null){
            System.out.printf("User %s does not exist!", username);
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }

        return new UserPrincipal(user);
    }
}
