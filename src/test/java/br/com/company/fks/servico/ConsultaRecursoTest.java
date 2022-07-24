package br.com.company.fks.servico;

import br.gov.cgu.esic.recurso.RequestObterRecurso;
import br.gov.cgu.esic.recurso.ResponseObterRecurso;
import br.gov.cgu.esic.recurso.ServicoConsultaRecursoLocator;
import br.gov.cgu.esic.recurso.ServicoConsultaRecursoSoap;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.rmi.RemoteException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 30/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConsultaRecursoTest {
    @InjectMocks
    private ConsultaRecurso consultaRecurso;

    @Mock
    private ServicoConsultaRecursoLocator servicoConsultaRecursoLocator;

    @Mock
    private ServicoConsultaRecursoSoap servicoConsultarecursosoap;

    @Mock
    private RequestObterRecurso requestObterRecurso;

    @Mock
    private ResponseObterRecurso responseObterRecurso;

//    @Test
//    @SneakyThrows
//    public void consultaRecurso() {
//        when(servicoConsultaRecursoLocator.getServicoConsultaRecursoSoap()).thenReturn(servicoConsultarecursosoap);
//        when(servicoConsultarecursosoap.obterRecursos(requestObterRecurso)).thenReturn(responseObterRecurso);
//        consultaRecurso.consultaRecurso(true);
//    }
//
//    @Test
//    @SneakyThrows
//    public void consultaRecursoRemoteException() {
//        when(servicoConsultaRecursoLocator.getServicoConsultaRecursoSoap()).thenReturn(servicoConsultarecursosoap);
//        Mockito.doThrow(RemoteException.class).when(servicoConsultarecursosoap).obterRecursos(requestObterRecurso);
//        consultaRecurso.consultaRecurso(true);
//    }

    @Test
    public void tipoConsulta() {
        consultaRecurso.tipoConsulta(false) ;
    }
}