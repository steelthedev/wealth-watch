package dev.steelthedev.WealthWatch.API.Auth.Model;

import java.math.BigInteger;

public record RegisterRequest(
        String username,
        String email,
        String password,
        BigInteger phone
) {
}
