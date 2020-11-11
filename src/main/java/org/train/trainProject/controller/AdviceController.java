package org.train.trainProject.controller;

import org.aspectj.lang.annotation.Aspect;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.train.trainProject.view.ErrorView;
import org.train.trainProject.view.ResponseView;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class AdviceController implements ResponseBodyAdvice<Object> {

    @ExceptionHandler({ConstraintViolationException.class, NoResultException.class})
    public ErrorView responseMyException(Exception e) {
        return new ErrorView(e.getMessage());
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
