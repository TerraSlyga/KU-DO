package org.example.kudo.user.internal.exception;

import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super("User with id " + id + " not found");
    }
}
