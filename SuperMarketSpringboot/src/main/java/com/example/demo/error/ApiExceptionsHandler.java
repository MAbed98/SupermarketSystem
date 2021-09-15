package com.example.demo.error;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorResponse> handleApiExceptions(ApiBaseException ex, WebRequest request){
        List<String> detailserror = new ArrayList<>();
        detailserror.add(ex.getLocalizedMessage());
        ErrorResponse details = new ErrorResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString() , detailserror);
        return new ResponseEntity<>(details, ex.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setUri(request.getDescription(false));

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for(FieldError f: fieldErrors) {
            validationError.addError(f.getDefaultMessage());
        }


        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}