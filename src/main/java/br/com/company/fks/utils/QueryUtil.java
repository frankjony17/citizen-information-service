package br.com.company.fks.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Calendar;

public class QueryUtil {

    private static final String IGNORA_CLAUSULA = "ignoraClausula";
    private static final String NAO_IGNORA_CLAUSULA = "naoIgnoraClausula";

    private QueryUtil() {
        throw new IllegalAccessError("Classe Utiliataria");
    }

    public static String definirSeIgnoraClausula(Long objeto) {
        String ignoraClausula = IGNORA_CLAUSULA;
        if (objeto != null) {
            ignoraClausula = NAO_IGNORA_CLAUSULA;
        }
        return ignoraClausula;

    }  public static String definirSeIgnoraClausula(Integer objeto) {
        String ignoraClausula = IGNORA_CLAUSULA;
        if (objeto != null) {
            ignoraClausula = NAO_IGNORA_CLAUSULA;
        }
        return ignoraClausula;
    }

    public static String definirSeIgnoraClausula(String objeto) {
        String ignoraClausula = IGNORA_CLAUSULA;
        if (StringUtils.isNotEmpty(objeto)) {
            ignoraClausula = NAO_IGNORA_CLAUSULA;
        }
        return ignoraClausula;
    }

    public static String definirSeIgnoraClausula(Calendar objeto) {
        String ignoraClausula = IGNORA_CLAUSULA;
        if (objeto != null) {
            ignoraClausula = NAO_IGNORA_CLAUSULA;
        }
        return ignoraClausula;
    }

    public static String definirSeIgnoraClausula(Boolean objeto) {
        String ignoraClausula = IGNORA_CLAUSULA;
        if (objeto != null && objeto) {
            ignoraClausula = NAO_IGNORA_CLAUSULA;
        }
        return ignoraClausula;
    }
}
