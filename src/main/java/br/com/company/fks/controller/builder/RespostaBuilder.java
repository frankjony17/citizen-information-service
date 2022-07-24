package br.com.company.fks.controller.builder;

/**
 * Created by FKSolutions Tecnologia on 04/10/2016.
 */

public final class RespostaBuilder<T> {

    private final Resposta<T> resposta;

    private RespostaBuilder() {
        resposta = new Resposta<>();
    }

    /**
     * @return
     */
    public static RespostaBuilder getBuilder() {
        return new RespostaBuilder();
    }

    /**
     * @return
     */
    public Resposta<T> build() {
        return resposta;
    }

    /**
     * @param resultado
     * @return
     */
    public RespostaBuilder<T> setResultado(T resultado) {
        resposta.setResultado(resultado);
        return this;
    }

    public RespostaBuilder<T> setErro(String erro) {
        resposta.getErros().add(erro);
        return this;
    }
}