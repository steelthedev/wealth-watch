package dev.steelthedev.WealthWatch.API.Auth.Services;

import dev.steelthedev.WealthWatch.API.User.Model.User;
import dev.steelthedev.WealthWatch.API.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    public AuthServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;


    public void signUp(User user){
         if (userRepository.findByUsername(user.getUsername()).isPresent()){
             throw new IllegalStateException("This user already exists");
         }

         if ( userRepository.findByEmail(user.getEmail()).isPresent()){
             throw new IllegalStateException("This user already exists");
         }

         userRepository.save(user);


    }
}
