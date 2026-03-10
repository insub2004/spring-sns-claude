package com.yd.springboot_sns_claude.domain.user;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {

    private final UserErrorCode errorCode;

    public UserException(UserErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public UserErrorCode getErrorCode() {
        return errorCode;
    }

    public enum UserErrorCode {
        DUPLICATE_USERNAME("이미 사용 중인 사용자명입니다.", HttpStatus.CONFLICT);

        private final String message;
        private final HttpStatus status;

        UserErrorCode(String message, HttpStatus status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public HttpStatus getStatus() {
            return status;
        }
    }
}
