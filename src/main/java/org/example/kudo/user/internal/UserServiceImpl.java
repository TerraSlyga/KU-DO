package org.example.kudo.user.internal;


import lombok.RequiredArgsConstructor;
import org.example.kudo.user.UserCreateCommand;
import org.example.kudo.user.UserRegisteredEvent;
import org.example.kudo.user.UserResponse;
import org.example.kudo.user.UserService;
import org.example.kudo.user.internal.exception.UserAlreadyExistsException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    @Transactional
    public UserResponse create(UserCreateCommand command) {
        if(userRepository.existsByEmail(command.email())){
            throw new UserAlreadyExistsException(command.email());
        }

        String encodedPassword = passwordEncoder.encode(command.password());

        User user = new User(
                command.email(),
                encodedPassword,
                command.firstName(),
                command.lastName(),
                command.displayName()
        );

        User userCreated = userRepository.save(user);

        applicationEventPublisher.publishEvent(new UserRegisteredEvent(
                    userCreated.getId(),
                    command.email()
        ));

        return toResponse(userCreated);
    }

    @Override
    public Optional<UserResponse> findById(UUID id) {
        return userRepository.findById(id).map(this::toResponse);
    }

    @Override
    public Optional<UserResponse> findByEmail(String email) {
        return userRepository.findByEmail(email).map(this::toResponse);
    }

    private UserResponse toResponse(User userCreated) {
        return new UserResponse(
                userCreated.getId(),
                userCreated.getEmail(),
                userCreated.getDisplayName(),
                userCreated.getFirstName(),
                userCreated.getLastName()
        );
    }
}
