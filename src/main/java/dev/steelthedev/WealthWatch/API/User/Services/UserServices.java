package dev.steelthedev.WealthWatch.API.User.Services;

import dev.steelthedev.WealthWatch.API.User.Model.User;
import dev.steelthedev.WealthWatch.API.User.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements UserDetailsService {
    private UserRepository userRepository;
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }
}
