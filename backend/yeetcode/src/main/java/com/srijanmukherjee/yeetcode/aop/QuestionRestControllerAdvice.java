package com.srijanmukherjee.yeetcode.aop;

import com.srijanmukherjee.yeetcode.controller.QuestionController;
import com.srijanmukherjee.yeetcode.exception.ErrorMessage;
import com.srijanmukherjee.yeetcode.exception.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {QuestionController.class})
public class QuestionRestControllerAdvice {
    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage handleDuplicateQuestion() {
        return new ErrorMessage("Question already exists");
    }
}
