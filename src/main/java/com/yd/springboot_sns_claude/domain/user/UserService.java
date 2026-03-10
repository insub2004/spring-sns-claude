package com.yd.springboot_sns_claude.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(String username, String rawPassword) {
        if (userRepository.existsByUsername(username)) {
            throw new UserException(UserException.UserErrorCode.DUPLICATE_USERNAME);
        }
        String encodedPassword = passwordEncoder.encode(rawPassword);
        return userRepository.save(User.create(username, encodedPassword));
    }
}
