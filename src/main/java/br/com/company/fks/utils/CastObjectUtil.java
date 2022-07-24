package br.com.company.fks.utils;

public final class CastObjectUtil {

    private CastObjectUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * Efetua o cast dos objeto informado
     *
     * @param o
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T cast(Object o, Class<T> clazz) {
        if (o != null) {
            return clazz.cast(o);
        }
        return null;
    }

}
