package dev.steelthedev.WealthWatch.API.User.Controller;

import dev.steelthedev.WealthWatch.API.User.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/:id")
    public Optional<User> getUser(@PathVariable Long id){
        return getUser(id);
    }
}
