package org.example.kudo.user.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String displayName;

    public  User(String email, String password, String firstName, String lastName, String displayName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
    }
}
