package com.yd.springboot_sns_claude.controller;

import com.yd.springboot_sns_claude.controller.dto.UserSignupRequest;
import com.yd.springboot_sns_claude.controller.dto.UserSignupResponse;
import com.yd.springboot_sns_claude.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/users/signup")
    public ResponseEntity<UserSignupResponse> signup(@RequestBody UserSignupRequest request) {
        var user = userService.signup(request.username(), request.password());
        return ResponseEntity.ok(UserSignupResponse.from(user));
    }
}
