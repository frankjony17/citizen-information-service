package br.com.company.fks.servico;

import br.gov.cgu.esic.pedido.RequestObterPedido;
import br.gov.cgu.esic.pedido.ResponseObterPedido;
import br.gov.cgu.esic.pedido.ResponsePedido;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoLocator;
import br.gov.cgu.esic.pedido.ServicoConsultaPedidoSoap_BindingStub;
import br.com.company.fks.utils.DataUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Calendar;
@Service
@PropertySource("classpath:application.properties")
public class ConsultaPedido {

    @Value("${wsesic.senha}")
    private String password;

    private static final Logger LOGGER = Logger.getLogger(ConsultaPedido.class);

    public ResponsePedido[] consultaPedido(Boolean tipoConsulta) {
        ResponsePedido[] pedidos = new ResponsePedido[0];
        try {
            RequestObterPedido request = new RequestObterPedido();
            request.setUsuario("wsmeconomia");
            request.setSenha("indh3829");
            Calendar dataFim = Calendar.getInstance();
            request.setDtAberturaInicio(tipoConsulta(tipoConsulta));
            request.setDtAberturaFim(dataFim);
            ServicoConsultaPedidoLocator locator = new ServicoConsultaPedidoLocator();
            ServicoConsultaPedidoSoap_BindingStub cliente = (ServicoConsultaPedidoSoap_BindingStub) locator.getServicoConsultaPedidoSoap();
            ResponseObterPedido response;
            response = cliente.obterPedidos(request);
            pedidos = response.getPedidos();
        } catch (RemoteException e) {
            LOGGER.error("ERRO AO OBTER PEDIDOS", e);
        } catch (ServiceException e) {
            LOGGER.error("ERRO RECUPERAR O SERVIÇO DE CONSULTA DE PEDIDOS", e);
        }
        return pedidos;
    }

    public ResponsePedido[] consultaPedido(String protocolo) {
        ResponsePedido[] pedido = new ResponsePedido[0];
        try {
            RequestObterPedido request = new RequestObterPedido();
            request.setUsuario("wsmeconomia");
            request.setSenha("indh3829");
            request.setProtocolo(protocolo);
            ServicoConsultaPedidoLocator locator = new ServicoConsultaPedidoLocator();
            ServicoConsultaPedidoSoap_BindingStub cliente = (ServicoConsultaPedidoSoap_BindingStub) locator.getServicoConsultaPedidoSoap();
            ResponseObterPedido response;
            response = cliente.obterPedidos(request);
            pedido = response.getPedidos();
        } catch (RemoteException e) {
            LOGGER.error("ERRO AO OBTER PEDIDOS", e);
        } catch (ServiceException e) {
            LOGGER.error("ERRO RECUPERAR O SERVIÇO DE CONSULTA DE PEDIDOS", e);
        }
        return pedido;
    }

    public Calendar tipoConsulta(Boolean tipoConsulta) {
        Calendar dataInicio;
        if (tipoConsulta) {
            dataInicio = DataUtil.addDays(Calendar.getInstance(), -1);
            return dataInicio;
        } else {
            dataInicio = DataUtil.addDays(Calendar.getInstance(), -90);
            return dataInicio;
        }
    }
}