package com.example.firstAPI.services.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class DbIntegrityException extends SQLIntegrityConstraintViolationException {
    public DbIntegrityException(String message){
        super(message);
    }
}
