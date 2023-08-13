package dev.steelthedev.WealthWatch.API.User.Controller;

import dev.steelthedev.WealthWatch.API.User.Model.User;
import dev.steelthedev.WealthWatch.API.User.Services.UserServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/:id")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<User> getUser(@PathVariable Long id){
        return getUser(id);
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<User> getProfile(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            System.out.println(authentication.getAuthorities());
            return userServices.getProfile(authentication.getName());
        }else{
            return Optional.empty();
        }
    }
}
