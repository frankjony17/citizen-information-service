package br.com.company.fks.servico;

import br.gov.cgu.esic.recurso.RequestObterRecurso;
import br.gov.cgu.esic.recurso.ResponseObterRecurso;
import br.gov.cgu.esic.recurso.ResponseRecurso;
import br.gov.cgu.esic.recurso.ServicoConsultaRecursoLocator;
import br.gov.cgu.esic.recurso.ServicoConsultaRecursoSoapStub;
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
public class ConsultaRecurso {

    @Value("${wsesic.senha}")
    private String password;

    private static final Logger LOGGER = Logger.getLogger(ConsultaRecurso.class);

    public ResponseRecurso[] consultaRecurso(Boolean tipoConsulta) {
        ResponseRecurso[] recursos = new ResponseRecurso[0];
        try {
            RequestObterRecurso request = new RequestObterRecurso();
            request.setUsuario("wsmeconomia");
            request.setSenha("indh3829");
            Calendar dataFim = Calendar.getInstance();
            request.setDtAberturaInicio(tipoConsulta(tipoConsulta));
            request.setDtAberturaFim(dataFim);
            ServicoConsultaRecursoLocator locator = new ServicoConsultaRecursoLocator();
            ServicoConsultaRecursoSoapStub cliente = (ServicoConsultaRecursoSoapStub) locator.getServicoConsultaRecursoSoap();
            ResponseObterRecurso response;
            response = cliente.obterRecursos(request);
            recursos = response.getRecursos();
        } catch (RemoteException e) {
            LOGGER.error("ERRO AO OBTER RECURSOS", e);
        } catch (ServiceException e) {
            LOGGER.error("ERRO RECUPERAR O SERVIÇO DE CONSULTA DE RECURSOS", e);
        }
        return recursos;
    }

    public Calendar tipoConsulta(Boolean tipoConsulta) {
        Calendar dataInicio;
        if (tipoConsulta) {
            dataInicio = DataUtil.addDays(Calendar.getInstance(), -100);
            return dataInicio;
        } else {
            dataInicio = DataUtil.addDays(Calendar.getInstance(), -90);
            return dataInicio;
        }
    }
}