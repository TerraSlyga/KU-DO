package org.example.kudo.user;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        String displayName,
        String firstName,
        String lastName
) {
}
