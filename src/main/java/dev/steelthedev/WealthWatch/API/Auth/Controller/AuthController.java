package dev.steelthedev.WealthWatch.API.Auth.Controller;

import dev.steelthedev.WealthWatch.API.Auth.Model.LoginRequest;
import dev.steelthedev.WealthWatch.API.Auth.Model.RegisterRequest;
import dev.steelthedev.WealthWatch.API.Auth.Services.AuthServices;
import dev.steelthedev.WealthWatch.API.User.Model.Role;
import dev.steelthedev.WealthWatch.API.User.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController(AuthServices authServices, BCryptPasswordEncoder encoder) {
        this.authServices = authServices;
        this.encoder = encoder;
    }

    private final AuthServices authServices;
    private final BCryptPasswordEncoder encoder;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "User created successfully")
    public void registerUser(@RequestBody RegisterRequest request){
        authServices.signUp(new User(
                request.username(),
                request.email(),
                encoder.encode(request.password()),
                request.phone(),
                Role.USER

        ));
    }

    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String,String> loginUser(@RequestBody LoginRequest loginRequest){
        String token = authServices.login(loginRequest.username(),loginRequest.password());
        return Map.of("token",token);
    }
}
