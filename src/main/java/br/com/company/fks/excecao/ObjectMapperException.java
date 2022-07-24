package br.com.company.fks.excecao;

public class ObjectMapperException extends Exception {

    public ObjectMapperException(String mensagem) {

        super(mensagem);
    }

    public ObjectMapperException(String mensagem, Exception e) {

        super(mensagem, e);
    }

}
