package com.srijanmukherjee.yeetcode.aop;

import com.srijanmukherjee.yeetcode.controller.TagController;
import com.srijanmukherjee.yeetcode.exception.ErrorMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {TagController.class})
public class TopicRestControllerAdvice {
    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage handleDuplicateTopic() {
        return new ErrorMessage("Topic already exists");
    }
}
