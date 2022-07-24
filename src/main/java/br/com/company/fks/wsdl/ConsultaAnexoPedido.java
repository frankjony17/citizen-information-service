package br.com.company.fks.wsdl;

import br.com.company.fks.servico.ConsultaPedido;
import br.gov.cgu.esic.pedido.ResponseArquivo;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoLocator;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoSoap_BindingStub;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

@Service
public class ConsultaAnexoPedido {

    private static final Logger LOGGER = Logger.getLogger(ConsultaPedido.class);

    @Value("${wsesic.usuario}")
    private String usuario;

    @Value("${wsesic.senha}")
    private String senha;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private AnexoUtils anexoUtils;

    public ResponseArquivo[] consultaAnexosPedido(String protocolo) throws IOException, ServiceException {

        ResponseArquivo[] arquivos;

        try {
            ServicoConsultaPedidoLocator locator = new ServicoConsultaPedidoLocator();
            ServicoConsultaPedidoSoap_BindingStub cliente = (ServicoConsultaPedidoSoap_BindingStub)locator.getServicoConsultaPedidoSoap();

            arquivos = cliente.obterAnexosPedidos(usuario, senha, protocolo).getArquivos();

            for (ResponseArquivo arquivo : arquivos) {
                byte[] decoded = Base64.decodeBase64(arquivo.getArquivoZipAndBase64().getBytes());
                anexoUtils.dezipaSalva(decoded, protocolo ,arquivo.getNomeArquivo());
            }
        }
        catch(IOException | ServiceException e) {
            LOGGER.error("ERRO AO OBTER ANEXOS DE PEDIDO", e);
            throw e;
        }

        return arquivos;
    }
}