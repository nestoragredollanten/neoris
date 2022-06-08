package com.na.neorisproject.exceptions;

/**
 * @author nestor.agredo
 * @project neoris-project
 * @class ModelNotFoundException
 */
public class ModelNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ModelNotFoundException(String message) {
        super(message);
    }
}
