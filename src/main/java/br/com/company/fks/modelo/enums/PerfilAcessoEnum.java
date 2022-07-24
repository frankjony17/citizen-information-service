package br.com.company.fks.modelo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PerfilAcessoEnum {

    ATENDENTE_SIC("FKS.ATENDENTE.SIC", 1, "Atendente SIC"),
    ADMIN("FKS.ADMIN", 2, "Administrador FKS"),
    OBSERVADOR_SIC("FKS.OBSERVADOR.SIC", 3, "Observador SIC"),
    AUTORIDADE_MAXIMA("FKS.AUTORIDADE.MAXIMA", 4, "Autoridade Máxima"),
    PONTO_FOCAL("FKS.PONTO.FOCAL", 5, "Ponto Focal (PF)"),
    AUTORIDADE_HIERARQUICA("FKS.AUTORIDADE.HIERARQUICA", 6, "Autoridade Hierárquica"),
    OBSERVADOR_UNIDADE("FKS.OBSERVADOR.UNIDADE", 7, "Observador Unidade"),
    RESPONDENTE("FKS.RESPONDENTE", 8, "Respondente"),
    TECNICO("FKS.TECNICO", 9, "Técnico"),
    PONTO_FOCAL_AUTORIDADE_MAXIMA("FKS.PONTO.FOCAL.AUTORIDADE.MAXIMA", 10, "Ponto Focal Autoridade Máxima (PF)");

    private String perfil;
    private int idPerfil;
    private String descricao;

    PerfilAcessoEnum(String perfil, int idPerfil, String descricao) {
        this.perfil = perfil;
        this.idPerfil = idPerfil;
        this.descricao = descricao;
    }

    public static int getIdByPerfil(String perfil) {
        PerfilAcessoEnum[] enuns = PerfilAcessoEnum.values();
        int ret = 0;

        for (PerfilAcessoEnum enumPerfil : enuns) {
            if (enumPerfil.getPerfil().equals(perfil)) {
                ret = enumPerfil.getIdPerfil();
                break;
            }
        }

        return ret;
    }

    public static String getPerfilById(int id) {
        PerfilAcessoEnum[] enuns = PerfilAcessoEnum.values();
        String perfil = "";

        for (PerfilAcessoEnum enumPerfil : enuns) {
            if (enumPerfil.getIdPerfil() == id) {
                perfil = enumPerfil.getPerfil();
                break;
            }
        }
        return perfil;
    }

}
