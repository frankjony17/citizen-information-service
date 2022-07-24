package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

@RunWith(PowerMockRunner.class)
public class ConsultaHistoricoRecursoDTOTest {

    @InjectMocks
    private ConsultaHistoricoRecursoDTO consultaHistoricoRecursoDTO;

    @Mock
    private Calendar data;

    @Test
    public void getId() {
        consultaHistoricoRecursoDTO.getId();
    }

    @Test
    public void getNomeResponsavel() {
        consultaHistoricoRecursoDTO.getNomeResponsavel();
    }

    @Test
    public void getTipoTratamentoRecurso() {
        consultaHistoricoRecursoDTO.getTipoTratamentoRecurso();
    }

    @Test
    public void getData() {
        consultaHistoricoRecursoDTO.getData();
    }

    @Test
    public void setId() {
        consultaHistoricoRecursoDTO.setId(1L);
    }

    @Test
    public void setNomeResponsavel() {
        consultaHistoricoRecursoDTO.setNomeResponsavel("nomeResponsavel");
    }

    @Test
    public void setTipoTratamentoRecurso() {
        consultaHistoricoRecursoDTO.setTipoTratamentoRecurso("tipoTratamentoRecursi");
    }

    @Test
    public void setData() {
        consultaHistoricoRecursoDTO.setData(data);
    }
}