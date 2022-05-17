package com.fatec.bibliotecanos.services.exceptions;

public class EmprestimoDevolucaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmprestimoDevolucaoException(String msg) {
        super(msg);
    }

}