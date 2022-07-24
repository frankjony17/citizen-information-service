package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ConsultaUsuarioPerfilDTO {
    private Long id;
    private String nome;
    private String email;
    private List<PerfilAcessosDTO> perfil;
    private String telefoneUsuario;
    private Boolean inexistenteNoAcesso;
}
