package br.com.company.fks.utils;

import br.com.company.fks.excecao.ObjectMapperException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ControllerUtil {

    private static final Logger LOGGER = Logger.getLogger(ControllerUtil.class);

    private ControllerUtil() {
        throw new IllegalAccessError("Classe Utiliataria");
    }

    public static <T> T montarFiltroDTO(String filtro, Class<T> clss) throws ObjectMapperException {
        ObjectMapper objectMapper = new ObjectMapper();
        T object;
        try {
            object = objectMapper.readValue(filtro, clss);
        } catch (IOException e) {
            String message = "Ocorreu uma falha ao converter o objeto da requisição.";
            LOGGER.error(message, e);
            throw new ObjectMapperException(message, e);
        }
        return clss.cast(object);
    }

    public static String criarObjetoJson(String nomeObjeto, String valorStringObjeto) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(nomeObjeto, valorStringObjeto);
        return objectNode.toString();
    }

}
