package br.com.company.fks.rotina;

import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.servico.EmailNotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@EnableScheduling
public class EmailRotinaAgendada {

    private Calendar hoje = Calendar.getInstance();

    @Autowired
    private EmailNotificacaoService emailNotificacaoService;

    @Autowired
    private FeriadoRepository feriadoRepository;

    /**
     * 12:00:00 am => 0 0 0 * * *
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleFixedDelayTask() {
        if (possoExecutar()) {
            emailNotificacaoService.enviarEmailsPorData();
        }
    }

    private boolean possoExecutar () {
        boolean bool = false;
        Long feriado = feriadoRepository.countByDataFeriado(Calendar.getInstance());
        if (hoje.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                && hoje.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
                && feriado.intValue() == 0) {
            bool = true;
        }
        return bool;
    }
}
