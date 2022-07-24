package br.com.company.fks.rotina;

import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.servico.EmailNotificacaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class EmailRotinaAgendadaTest {

    @InjectMocks
    private EmailRotinaAgendada emailRotinaAgendada;

    @Mock
    private FeriadoRepository feriadoRepository;

    @Mock
    private Calendar dataFeriado;

    @Mock
    private EmailNotificacaoService emailNotificacaoService;

    @Test
    public void scheduleFixedDelayTask(){
        when(feriadoRepository.countByDataFeriado(dataFeriado)).thenReturn(1L);
        emailNotificacaoService.enviarEmailsPorData();
        emailRotinaAgendada.scheduleFixedDelayTask();
    }

}