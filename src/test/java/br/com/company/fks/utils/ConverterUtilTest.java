package br.com.company.fks.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterUtilTest {

    public static String converteObjetoEmJson(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
