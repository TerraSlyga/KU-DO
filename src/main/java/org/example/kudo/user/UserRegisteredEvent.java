package org.example.kudo.user;

import java.util.UUID;

public record UserRegisteredEvent(
        UUID userId,
        String email
) {}
