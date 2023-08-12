package dev.steelthedev.WealthWatch.API.Auth.Services;

import dev.steelthedev.WealthWatch.API.User.Model.User;

import java.util.Optional;

public interface AuthServiceInt {
    Optional<User> getAuthenticatedUser();
}
