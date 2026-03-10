package com.yd.springboot_sns_claude.controller.dto;

import com.yd.springboot_sns_claude.domain.user.User;

public record UserSignupResponse(Long id, String username) {

    public static UserSignupResponse from(User user) {
        return new UserSignupResponse(user.getId(), user.getUsername());
    }
}
