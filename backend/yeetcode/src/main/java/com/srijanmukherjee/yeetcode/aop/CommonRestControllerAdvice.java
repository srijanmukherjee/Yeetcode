package com.srijanmukherjee.yeetcode.aop;

import com.srijanmukherjee.yeetcode.exception.ErrorMessage;
import com.srijanmukherjee.yeetcode.exception.ResourceNotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonRestControllerAdvice {
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage handleExpiredJwt() {
        return new ErrorMessage("Token has expired");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFound(final ResourceNotFoundException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler({BadCredentialsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleBadCredentials() {
        return new ErrorMessage("Invalid username or password");
    }

    @ExceptionHandler(DisabledException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage handleDisabledUser() {
        return new ErrorMessage("Account is disabled");
    }

    @ExceptionHandler(LockedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage handleLockedUser() {
        return new ErrorMessage("Account is not activated");
    }
}
