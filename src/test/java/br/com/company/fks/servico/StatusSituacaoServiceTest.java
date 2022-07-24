package br.com.company.fks.servico;

import br.com.company.fks.modelo.StatusSituacao;
import br.com.company.fks.repositorio.StatusSituacaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatusSituacaoServiceTest {

    @InjectMocks
    private StatusSituacaoService service;

    @Mock
    private StatusSituacaoRepository repository;

    @Mock
    private StatusSituacao statusSituacao;

    @Test
    public void consultarStatusSituacao(){
        List<StatusSituacao> listaStatusSituacao = new ArrayList<>();
        listaStatusSituacao.add(statusSituacao);
        when(repository.findAll()).thenReturn(listaStatusSituacao);
        service.consultarStatusSituacao();
    }

}