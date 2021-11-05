package com.example.springbootupdate.user;

import com.example.springbootupdate.Repository.UserRepository;
import com.example.springbootupdate.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadByUsername(String email) throws UsernameNotFoundException{
        final Optional<User> optionalUser=userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new UsernameNotFoundException(MessageFormat.format("user with email{0} cannot be found"));
        }
    }
}
