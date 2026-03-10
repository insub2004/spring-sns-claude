package com.yd.springboot_sns_claude.domain.user;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    protected User() {}

    private User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User create(String username, String encodedPassword) {
        return new User(username, encodedPassword);
    }
}
