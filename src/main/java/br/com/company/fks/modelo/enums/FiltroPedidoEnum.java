package br.com.company.fks.modelo.enums;

import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Subtema;
import br.com.company.fks.modelo.dto.FiltroPedidoDTO;
import lombok.Getter;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public enum FiltroPedidoEnum {

    FILTRO_SUBTEMA(
            (Pedido pedido, FiltroPedidoDTO filtro) -> hasSubtema(pedido, filtro.getIdSubTema()),
            (FiltroPedidoDTO filtro) -> filtro.getIdSubTema() != null
    ),
    FILTRO_PALAVRA_CHAVE(
            (Pedido pedido, FiltroPedidoDTO filtro) -> hasPalavraChave(pedido, filtro.getIdPalavraChave()),
            (FiltroPedidoDTO filtro) -> filtro.getIdPalavraChave() != null
    );

    FiltroPedidoEnum(BiPredicate<Pedido, FiltroPedidoDTO> filter, Predicate<FiltroPedidoDTO> condition){
        this.condition = condition;
        this.filter = filter;
    }

    private BiPredicate<Pedido, FiltroPedidoDTO> filter;
    private Predicate<FiltroPedidoDTO> condition;

    public boolean isToRun(FiltroPedidoDTO filtro){
        return this.condition != null && this.condition.test(filtro);
    }

    private static boolean hasSubtema(Pedido pedido, Long idSubtema){
        List<Subtema> subtemas = pedido.getSubtemaList();
        for(Subtema subtema: subtemas){
            if(subtema.getId().equals(idSubtema)){
                return true;
            }
        }
        return false;
    }

    private static  boolean hasPalavraChave(Pedido pedido, Long idPalavraChave){
        List<PalavraChave> palavraChaveList = pedido.getPalavraChaveList();
        for(PalavraChave palavraChave : palavraChaveList){
            if(palavraChave.getId().equals(idPalavraChave)){
                return true;
            }
        }
        return false;
    }

    public static List<Pedido> runFilter(List<Pedido> pedidos, FiltroPedidoDTO filtroPedidoDTO, FiltroPedidoEnum filtro){
        return filtro.isToRun(filtroPedidoDTO) ? pedidos.stream().filter((Pedido pedido) -> filtro.getFilter().test(pedido, filtroPedidoDTO)).collect(Collectors.toList()) : pedidos;
    }

}