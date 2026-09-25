package org.example.kudo.user.internal.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private static final String BASE_MESSAGE_START = "User with email: '";
    private static final String BASE_MESSAGE_END = "' already exists";

    public UserAlreadyExistsException(String message) {
        super(BASE_MESSAGE_START + message + BASE_MESSAGE_END);
    }
    public UserAlreadyExistsException(String message, Throwable cause) {
        super(BASE_MESSAGE_START + message + BASE_MESSAGE_END + message, cause);
    }
}
