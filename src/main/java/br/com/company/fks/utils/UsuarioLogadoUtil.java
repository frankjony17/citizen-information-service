package br.com.company.fks.utils;

import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.gov.mpog.acessos.cliente.dto.UsuarioLogadoDTOV2;
import br.gov.mpog.acessos.cliente.servico.AcessosClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLogadoUtil {

    @Autowired
    private AcessosClienteService acessosClienteService;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    private UsuarioLogadoDTOV2 usuarioLogadoDTOV2;

    private UsuarioAcessos usuarioDataBase;

    private void init() {
        usuarioLogadoDTOV2 = acessosClienteService.buscarUsuarioLogadoV2();
        usuarioDataBase = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoDTOV2.getCpf());
    }

    public String getCpf () {
        init();
        return usuarioLogadoDTOV2.getCpf();
    }

    public String getNome () {
        init();
        return usuarioLogadoDTOV2.getNome();
    }

    public String getPerfil () {
        init();
        return usuarioDataBase != null ? usuarioDataBase.getPerfilUsuario() : "";
    }

    public UsuarioAcessos getUsuario () {
        init();
        return usuarioDataBase;
    }
}
