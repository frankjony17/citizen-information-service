package br.com.company.fks.servico.usuario;

import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.servico.UnidadeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioRelatorioServiceTest {

    @InjectMocks
    private UsuarioRelatorioService usuarioRelatorioService;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private Subunidade subunidade;

    @Mock
    private UnidadeService unidadeService;

    @Mock
    private Unidade unidade;

    @Test
    public void montarUsuarioRelatorioDTO(){
        when(unidadeService.getOneSubunidadePeloUsuarioCpf("000000000")).thenReturn(subunidade);
        when(usuarioAcessos.getCpfUsuario()).thenReturn("000000000");
        when(subunidade.getNomeSubunidade()).thenReturn("nomeSubunidade");
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getNomeUnidade()).thenReturn("nomeUnidade");
        usuarioRelatorioService.montarUsuarioRelatorioDTO(usuarioAcessos);
    }
}