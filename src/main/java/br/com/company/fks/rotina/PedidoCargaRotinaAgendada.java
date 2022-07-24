package br.com.company.fks.rotina;

import br.com.company.fks.servico.ConsultaPedido;
import br.com.company.fks.servico.ConsultaRecurso;
import br.com.company.fks.servico.ImportacaoPedidoService;
import br.com.company.fks.servico.ImportacaoRecursoService;
import br.com.company.fks.wsdl.ConsultaAnexoPedido;
import br.gov.cgu.esic.pedido.ResponseArquivo;
import br.gov.cgu.esic.pedido.ResponsePedido;
import br.gov.cgu.esic.recurso.ResponseRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

@Component
@EnableScheduling
public class PedidoCargaRotinaAgendada {

    private static final long SEGUNDO = 1000;

    private static final long MINUTO = SEGUNDO * 60;

    private static final Boolean CONSULTA_A_CADA_TRINTA_MINUTOS = true;

    private static final Boolean CONSULTA_DIARIA = false;

    private ConsultaPedido consultaPedido = new ConsultaPedido();

    private ConsultaRecurso consultaRecurso = new ConsultaRecurso();

    @Autowired
    private ConsultaAnexoPedido consultaAnexoPedido;

    @Autowired
    private ImportacaoPedidoService importacaoPedidoService;

    @Autowired
    private ImportacaoRecursoService importacaoRecursoService;

//    @Scheduled(fixedDelay = MINUTO * 30)
    public void verificaACadaTrintaMinutos() throws IOException, ServiceException {
        ResponsePedido[] pedidos = consultaPedido.consultaPedido(CONSULTA_A_CADA_TRINTA_MINUTOS);
        for (ResponsePedido pedido : pedidos) {
            ResponseArquivo[] arquivos = consultaAnexoPedido.consultaAnexosPedido(pedido.getProtocolo());
            importacaoPedidoService.sincronizarBaseDeDadosPedidos(pedido, arquivos);
        }
        ResponseRecurso[] recursos = consultaRecurso.consultaRecurso(CONSULTA_A_CADA_TRINTA_MINUTOS);
        for (ResponseRecurso recurso : recursos) {
            importacaoRecursoService.sincronizarBaseDeDadosRecursos(recurso);
        }
    }

//    @Scheduled(cron = "0 0 0 * * *")
    public void verificaDiariamenteMeiaNoite() throws IOException, ServiceException {
        ResponsePedido[] pedidos = consultaPedido.consultaPedido(CONSULTA_DIARIA);
        for (ResponsePedido pedido : pedidos) {
            ResponseArquivo[] arquivos = consultaAnexoPedido.consultaAnexosPedido(pedido.getProtocolo());
            importacaoPedidoService.sincronizarBaseDeDadosPedidos(pedido, arquivos);
        }
        ResponseRecurso[] recursos = consultaRecurso.consultaRecurso(CONSULTA_A_CADA_TRINTA_MINUTOS);
        for (ResponseRecurso recurso : recursos) {
            importacaoRecursoService.sincronizarBaseDeDadosRecursos(recurso);
        }
    }
}
