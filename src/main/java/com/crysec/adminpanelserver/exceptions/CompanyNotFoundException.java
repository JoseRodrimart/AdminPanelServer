package com.crysec.adminpanelserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends  RuntimeException{

    public CompanyNotFoundException(Long id) {
        super("Could not find company with the id: " + id);
    }

    public CompanyNotFoundException(String name) {
        super("Could not find company with the name: " + name);
    }
}
