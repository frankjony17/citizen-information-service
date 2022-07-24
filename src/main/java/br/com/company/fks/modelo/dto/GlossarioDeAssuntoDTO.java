package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GlossarioDeAssuntoDTO {
    private String nomeTema;
    private List<SubtemaDTO> subtemas = new ArrayList<>();
}
