package dev.steelthedev.WealthWatch.API.Auth.Controller;

import dev.steelthedev.WealthWatch.API.Auth.Model.RegisterRequest;
import dev.steelthedev.WealthWatch.API.Auth.Services.AuthServices;
import dev.steelthedev.WealthWatch.API.User.Model.Role;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController(AuthServices authServices) {
        this.authServices = authServices;
    }

    private final AuthServices authServices;

    @PostMapping("/create")
    public void registerUser(@RequestBody RegisterRequest request){
        authServices.signUp(new User(
                request.username(),
                request.email(),
                request.password(),
                request.phone(),
                Role.USER,
                null
        ));
    }
}
