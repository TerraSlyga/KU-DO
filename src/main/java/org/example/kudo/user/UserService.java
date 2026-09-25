package org.example.kudo.user;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserResponse create(UserCreateCommand command);
    Optional<UserResponse> findById(UUID id);
    Optional<UserResponse> findByEmail(String email);
}
