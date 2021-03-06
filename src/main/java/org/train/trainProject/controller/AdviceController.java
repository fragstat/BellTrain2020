package org.train.trainProject.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.train.trainProject.view.aspect.ErrorView;
import org.train.trainProject.view.aspect.ResponseView;
import org.train.trainProject.view.aspect.SuccessView;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;
import java.text.ParseException;

@ControllerAdvice
public class AdviceController implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorView> constraintViolationExceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorView("wrong input parameters"));
    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<ErrorView> noResultExceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorView(e.getMessage()));
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<ErrorView> parseExceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorView("wrong date format, required " +
                "yyyy-mm-dd"));
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    @ResponseBody
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<?
            extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof ErrorView) {
            return o;
        }
        return new ResponseView(o);
    }
}
