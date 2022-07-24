package br.com.company.fks.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por urls do FKS
 */

@Component
public final class URLIntegracaoUtils {

    @Value("${siorg.url}")
    private String urlSiorg;

    /**
     * Obter url Órgão.
     * @return url: http://acessos-se.dev.nuvem.gov.br/api/organizacoes/public/listar-orgaos-por-origem/SIORG
     */
    public String getUrlOrgaoSiorgAcesso() {
        return String.format(urlSiorg);
    }
}