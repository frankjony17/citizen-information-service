package br.com.company.fks.command;

import br.com.company.fks.modelo.TipoRecurso;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class ImportacaoRecursoServiceCommandImplTest {

    @InjectMocks
    private ImportacaoRecursoServiceCommandImpl importacaoRecursoServiceCommand;

    @Mock
    private TipoRecurso tipoRecurso;

    @Test
    public void definirTipoRecursoCase1(){
        when(tipoRecurso.getId()).thenReturn(1L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Ausência de justificativa legal para classificação", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase2(){
        when(tipoRecurso.getId()).thenReturn(2L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Autoridade classificadora não informada", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase3(){
        when(tipoRecurso.getId()).thenReturn(3L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Data da classificação (de inicio ou fim) não informada", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase4(){
        when(tipoRecurso.getId()).thenReturn(4L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Deferimento de pedido de revisão para transformar pedido em manifestação", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase5(){
        when(tipoRecurso.getId()).thenReturn(5L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Grau de classificação inexistente", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase6(){
        when(tipoRecurso.getId()).thenReturn(6L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Grau de sigilo não informado", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase7(){
        when(tipoRecurso.getId()).thenReturn(7L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Informação classificada por autoridade sem competência", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase8(){
        when(tipoRecurso.getId()).thenReturn(8L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Informação incompleta", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase9(){
        when(tipoRecurso.getId()).thenReturn(9L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Informação recebida não corresponde à solicitada", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase10(){
        when(tipoRecurso.getId()).thenReturn(10L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Informação recebida por meio diferente do solicitado", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase11(){
        when(tipoRecurso.getId()).thenReturn(11L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Justificativa para o sigilo insatisfatória/não informada", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase12(){
        when(tipoRecurso.getId()).thenReturn(12L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Outros", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase13(){
        when(tipoRecurso.getId()).thenReturn(13L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Prazo de classificação inadequado para o grau de sigilo", tipoRecurso);
    }

    @Test
    public void definirTipoRecursoCase14(){
        when(tipoRecurso.getId()).thenReturn(14L);
        importacaoRecursoServiceCommand.definirTipoRecurso("Resposta não foi dada no prazo", tipoRecurso);
    }

}