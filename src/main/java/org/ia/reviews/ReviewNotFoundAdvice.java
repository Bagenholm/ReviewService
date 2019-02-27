package org.ia.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReviewNotFoundAdvice {

    @ExceptionHandler(ReviewException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reviewNotFound(ReviewException exception){
        return exception.s;
    }
}
