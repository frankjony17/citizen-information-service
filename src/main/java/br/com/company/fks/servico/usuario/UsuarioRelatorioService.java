package br.com.company.fks.servico.usuario;

import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.TempUsuarioAcessosRepository;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.TempPerfisAcessos;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.FiltroUsuarioDTO;
import br.com.company.fks.modelo.dto.PerfilAcessosDTO;
import br.com.company.fks.modelo.dto.PerfilDTO;
import br.com.company.fks.modelo.dto.UsuarioRelatorioDTO;
import br.com.company.fks.modelo.dto.UsuariosAcessoDTO;
import br.com.company.fks.servico.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioRelatorioService {

    @Autowired
    private UnidadeService unidadeService;

    @Autowired
    private SubunidadeRepository subunidadeRepository;

    @Autowired
    private TempUsuarioAcessosRepository tempUsuarioAcessosRepository;

    public UsuarioRelatorioDTO montarUsuarioRelatorioDTO(UsuarioAcessos usuarioAcessos) {
        UsuarioRelatorioDTO usuarioRelatorioDTO = new UsuarioRelatorioDTO();
        usuarioRelatorioDTO.setNomeUsuario(usuarioAcessos.getNomeUsuario());
        usuarioRelatorioDTO.setPerfilUsuario(usuarioAcessos.getPerfilUsuario());
        usuarioRelatorioDTO.setTelefoneUsuario(usuarioAcessos.getTelefoneUsuario());
        usuarioRelatorioDTO.setEmailUsuario(usuarioAcessos.getEmailUsuario());
        usuarioRelatorioDTO.setNomeSubunidade(unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioAcessos.getCpfUsuario()).getNomeSubunidade());
        usuarioRelatorioDTO.setNomeUnidade(usuarioAcessos.getUnidade().getNomeUnidade());
        return usuarioRelatorioDTO;
    }

    public List<UsuariosAcessoDTO> montarUsuariosAcessoDTO (FiltroUsuarioDTO parms) {
        Boolean ativo = null;
        Boolean existeAcessos = null;
        List<UsuariosAcessoDTO> usuariosAcessoDTOList =  new ArrayList<>();

        if (parms.getStatusUsuario() != null && parms.getStatusUsuario().equals("Ativo")) { ativo = true; }
        if (parms.getStatusUsuario() != null && parms.getStatusUsuario().equals("Inativo")) { ativo = false; }
        if (parms.getStatusUsuario() != null && parms.getStatusUsuario().equals("Usuario Não Encontrado No Acessos")) { existeAcessos = false; }

        tempUsuarioAcessosRepository.findUsuariosPerfis(parms.getNomePerfil(), parms.getCpfUsuario(), parms.getIdUnidade(), parms.getIdsSubunidade(), ativo, existeAcessos, new PageRequest(parms.getOffset(), parms.getLimit())).forEach(tup -> {
            UsuariosAcessoDTO dto = new UsuariosAcessoDTO(tup.getId(), tup.getUsuarioCpf(), tup.getUsuarioNome(), tup.getUsuarioTelefoneTrabalho(), tup.getUsuarioAtivo());
            dto.setEmail(tup.getUsuarioEmail());
            dto.setTelefoneCelular(tup.getUsuarioTelefoneCelular());
            dto.setExisteAcessos(tup.getUsuarioExisteAcessos());
            dto.setPerfil(getPerfis(tup.getTempPerfisAcessos()));
            usuariosAcessoDTOList.add(dto);
        });
        return usuariosAcessoDTOList;
    }

    private List<PerfilAcessosDTO> getPerfis (List<TempPerfisAcessos> tempPerfisAcessosList) {
        List<PerfilAcessosDTO> perfilList = new ArrayList<>();
        for (TempPerfisAcessos tp : tempPerfisAcessosList) {
            PerfilAcessosDTO perfilAcessosDTO = new PerfilAcessosDTO();
            PerfilDTO perfilDTO = new PerfilDTO(tp.getPerfilId(), tp.getPerfilNome(), tp.getPerfilDescricao(), tp.getPerfilUnidadeId() != null ? unidadeService.buscarUnidade(tp.getPerfilUnidadeId()) : null, tp.getPerfilAtivo());
            perfilDTO.setSubunidades(getSubunidades(tp.getPerfilSubunidadesIds()));
            perfilDTO.setExcluido(tp.getPerfilExcluido());
            perfilDTO.setExisteAcessos(tp.getPerfilExisteAcessos());
            perfilDTO.setAtivo(tp.getPerfilAtivo());
            perfilAcessosDTO.setPerfil(perfilDTO);
            perfilList.add(perfilAcessosDTO);
        }
        return perfilList;
    }

    private List<Subunidade> getSubunidades (String ids) {
        List<String> longList = Arrays.asList(ids.split("#"));
        List<Subunidade> subunidadeList = new ArrayList<>();
        longList.forEach(str -> {
            if (!str.equals("#") && !str.equals("")) {
                Long id = Long.parseLong(str);
                subunidadeList.add(subunidadeRepository.findOne(id));
            }
        });
        return subunidadeList;
    }
}

