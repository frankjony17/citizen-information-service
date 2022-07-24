package br.com.company.fks.utils;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.servico.PedidoService;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ExceptionsUtil {

    private static final Logger LOGGER = Logger.getLogger(PedidoService.class);

    public static void exceptionXssf(ByteArrayOutputStream byteArrayOutputStream, XSSFWorkbook xssfWorkbook) throws IntegracaoException, IOException {
        try {
            xssfWorkbook.write(byteArrayOutputStream);
            xssfWorkbook.close();
        } catch (IOException e) {
            String message = "Ocorreu um erro inesperado ao gerar os bytes do arquivo excel.";
            LOGGER.error(message);
            throw new IntegracaoException(message, e);
        } finally {
            xssfWorkbook.close();
        }
    }
}
