package br.com.company.fks.excecao;

public class FKSException extends RuntimeException {


    public FKSException(String var) {
        super(var);
    }

    public FKSException(String message, Throwable cause) {
        super(message, cause);
    }

}
