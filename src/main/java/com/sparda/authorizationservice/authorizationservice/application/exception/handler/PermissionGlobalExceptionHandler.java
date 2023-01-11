package com.sparda.authorizationservice.authorizationservice.application.exception.handler;

import com.sparda.authorizationservice.authorizationservice.domain.core.exception.PermissionAlreadyExistsException;
import com.sparda.authorizationservice.authorizationservice.domain.core.exception.PermissionDomainException;
import com.sparda.authorizationservice.authorizationservice.domain.core.exception.PermissionNotFoundException;
import com.sparda.authorizationservice.common.application.exception.ErrorDTO;
import com.sparda.authorizationservice.common.application.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class PermissionGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {PermissionAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDTO handleException(PermissionAlreadyExistsException permissionAlreadyExistsException) {
        log.error(permissionAlreadyExistsException.getMessage(), permissionAlreadyExistsException);
        return ErrorDTO.builder().code(PermissionAlreadyExistsException.getErrorCode())
                .message(permissionAlreadyExistsException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {PermissionNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(PermissionNotFoundException permissionNotFoundException) {
        log.error(permissionNotFoundException.getMessage(), permissionNotFoundException);
        return ErrorDTO.builder().code(PermissionNotFoundException.getErrorCode())
                .message(permissionNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {PermissionDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(PermissionDomainException orderDomainException) {
        log.error(orderDomainException.getMessage(), orderDomainException);
        return ErrorDTO.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(orderDomainException.getMessage())
                .build();
    }
}
