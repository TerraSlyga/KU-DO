package org.example.kudo.user;

public record UserCreateCommand(
        String email,
        String password,
        String displayName,
        String firstName,
        String lastName
) {
}
