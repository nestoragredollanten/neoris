package com.na.neorisproject.exceptions;

/**
 * @author nestor.agredo
 * @project neoris-project
 * @class ArgumentRequiredException
 */
public class ArgumentRequiredException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ArgumentRequiredException(String mensaje) {
        super(mensaje);
    }

}
