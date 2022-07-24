package br.com.company.fks.servico;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Feriado;
import br.com.company.fks.modelo.dto.FeriadoDTO;
import br.com.company.fks.modelo.dto.ConsultaFeriadoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Slf4j
public class FeriadoService {

    @Autowired
    private FeriadoRepository feriadoRepository;

     private Calendar cal = Calendar.getInstance();
     private int anoAtual = cal.get(Calendar.YEAR);

    @Transactional
    public void salvar(Feriado cadastrarFeriado) throws IntegracaoException{
        log.debug("Salvando fériado");
        cadastrarFeriado.setAno(anoAtual);
        List<Calendar> listaFeriado = listaFeriadosFKS();
        if(listaFeriado.size() == 0){
            feriadoRepository.save(cadastrarFeriado);
        }else {
            for (Calendar feriado:listaFeriado) {
                if(feriado.get(Calendar.DAY_OF_MONTH) == cadastrarFeriado.getDataFeriado().get(Calendar.DAY_OF_MONTH)
                        && feriado.get(Calendar.MONTH) == cadastrarFeriado.getDataFeriado().get(Calendar.MONTH)
                        && feriado.get(Calendar.YEAR) == cadastrarFeriado.getDataFeriado().get(Calendar.YEAR)) {
                    log.error("Erro ao salvar data duplicada");
                    throw new IntegracaoException("A data informada já possui cadastro");
                }
            }
            feriadoRepository.save(cadastrarFeriado);
        }
    }

    @Transactional
    public void editarFeriadoFKS(Feriado feriado) throws IntegracaoException{
        feriadoRepository.save(feriado);
    }

    public Resposta<List<FeriadoDTO>> consultarFeriado(ConsultaFeriadoDTO parms) throws IntegracaoException {
        List<FeriadoDTO> feriadoList = new ArrayList<>();
        Resposta<List<FeriadoDTO>> resposta = new Resposta<>();

        feriadoRepository.findFeriados(
                parms.getPeriodoInicialFeriado(),
                parms.getPeriodoFinalFeriado(), new PageRequest(parms.getOffset(), parms.getLimit())).forEach(f -> {
            FeriadoDTO dto = new FeriadoDTO();
            dto.setId(f.getId());
            dto.setNome(f.getNome());
            dto.setAno(f.getAno());
            dto.setDataFeriado(f.getDataFeriado());
            dto.setDescricao(f.getDescricao());
            feriadoList.add(dto);
        });
        resposta.setResultado(feriadoList);
        resposta.setTotalElementos(feriadoRepository.countFeriados(
                parms.getPeriodoInicialFeriado(),
                parms.getPeriodoFinalFeriado())
        );
        return resposta;
    }

    public FeriadoDTO buscarFeriado(Long id) {
        Feriado feriado = feriadoRepository.findOne(id);
        return converterFeriadoDTO(feriado);
    }

    private FeriadoDTO converterFeriadoDTO(Feriado feriado) {
        FeriadoDTO feriadoDTO = new FeriadoDTO();
        feriadoDTO.setDataFeriado(feriado.getDataFeriado());
        feriadoDTO.setDescricao(feriado.getDescricao());
        feriadoDTO.setId(feriado.getId());
        feriadoDTO.setNome(feriado.getNome());
        return feriadoDTO;
    }

    public void deletarFeriado(Long id) {
        if(id !=null) {
            feriadoRepository.delete(id);
        }
    }

    public List<Calendar> listaFeriadosFKS() {
        List<Feriado> listaCadastroFeriado = feriadoRepository.findAll();
        List<Calendar> listaFeriados = new ArrayList<>();
        for (Feriado lista: listaCadastroFeriado) {
            listaFeriados.add(lista.getDataFeriado());
        }
        return listaFeriados;
    }



}
