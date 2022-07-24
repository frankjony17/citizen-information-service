package br.com.company.fks.utils;

import br.com.company.fks.repositorio.FeriadoRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por tratar datas
 * Created by diego on 09/12/16.
 */
public final class DataUtil {

    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String HH_MM = "HH:mm";

    private DataUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * Formata data e hora
     *
     * @param data
     * @param pattern
     * @return String com a data e hora formatados
     */
    public static String formataDataHora(Date data, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (data != null) {
            return simpleDateFormat.format(data);
        } else {
            return null;
        }
    }

    /**
     * Retorna Data atual formatada
     *
     * @return String com data atual formatada
     */
    public static String getDataAtualFormatada() {
        return formataDataHora(new Date(), DD_MM_YYYY);
    }

    /**
     * Retorna Hora atual formatada
     *
     * @return String com hora atual formatada
     */
    public static String getHoraAtualFormatada() {
        return formataDataHora(new Date(), HH_MM);
    }

    /**
     * Converte objeto Date para LocalDate
     *
     * @param data
     * @return
     */
    public static LocalDate converterLocalDate(Date data) {
        Optional<Date> optional = Optional.ofNullable(data);
        if (optional.isPresent()) {
            return LocalDate.parse(new SimpleDateFormat(YYYY_MM_DD).format(data));
        }
        return null;
    }

    public static Calendar addDays(Calendar calendar, int days) {
        Calendar newCalendar = null;
        if (calendar != null) {
            newCalendar = Calendar.getInstance();
            newCalendar.setTimeInMillis(calendar.getTimeInMillis());
            newCalendar.add(Calendar.DAY_OF_MONTH, days);
        }
        return newCalendar;
    }

    public static Boolean isAntes19Hs(Calendar dataCientificacao) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        String hora = simpleDateFormat.format(dataCientificacao.getTime());
        return Integer.parseInt(hora) < 19;
    }

    public static Calendar recuperarProximoDiaUtil(Calendar calendar, List<Calendar> feriados) {
        Calendar proximoDiaUtil = Calendar.getInstance();
        proximoDiaUtil.setTimeInMillis(calendar.getTimeInMillis());
        do {
            proximoDiaUtil.add(Calendar.DAY_OF_MONTH, 1);
        } while (!isDiaUtil(proximoDiaUtil, feriados));
        return proximoDiaUtil;
    }

    public static Calendar somarDiasUteis(Calendar calendar, int quantidadeDias, List<Calendar> feriados) {
        Calendar novoCalendar = Calendar.getInstance();
        novoCalendar.setTimeInMillis(calendar.getTimeInMillis());
        for (int i = 0; i < quantidadeDias; i++) {
            novoCalendar.add(Calendar.DATE, 1);
            if (novoCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                    || novoCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                quantidadeDias++;
            }
            for (Calendar feriado : feriados) {
                Boolean isFeriadoFinalDeSemana = verificaFeriadoFinalDeSemana(feriado);
                if (!isFeriadoFinalDeSemana && feriado.get(Calendar.DAY_OF_MONTH) == novoCalendar.get(Calendar.DAY_OF_MONTH)
                        && feriado.get(Calendar.MONTH) == novoCalendar.get(Calendar.MONTH)
                        && feriado.get(Calendar.YEAR) == novoCalendar.get(Calendar.YEAR)) {
                    quantidadeDias++;
                }
            }
        }
        return novoCalendar;
    }

    public static Boolean verificaFeriadoFinalDeSemana(Calendar feriado) {
        Boolean isFeriadoFinalDeSemana = false;
        if (feriado.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || feriado.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            isFeriadoFinalDeSemana = true;
        }
        return isFeriadoFinalDeSemana;
    }

    public static Calendar getDataHoraFinalDiaImportacao(Calendar calendar) {
        Calendar newCalendar = null;
        if (calendar != null) {
            newCalendar = Calendar.getInstance();
            newCalendar.setTimeInMillis(calendar.getTimeInMillis());
            newCalendar.set(Calendar.HOUR_OF_DAY, 18);
            newCalendar.set(Calendar.MINUTE, 59);
            newCalendar.set(Calendar.SECOND, 59);
            newCalendar.set(Calendar.MILLISECOND, 999);
        }
        return newCalendar;
    }

    public static Boolean isDiaUtil(Calendar calendar, List<Calendar> feriados) {
        Boolean isDiaUtil = false;
        if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
                && !isFeriado(calendar, feriados)) {
            isDiaUtil = true;
        }
        return isDiaUtil;
    }

    public static Boolean isFeriado(Calendar calendar, List<Calendar> feriados) {
        Boolean isFeriado = false;
        for (Calendar feriado : feriados) {
            if (feriado.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)
                    && feriado.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
                    && feriado.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                isFeriado = true;
            }
        }
        return isFeriado;
    }

    public static Calendar getDataHoraInicioDia(Calendar calendar) {
        Calendar newCalendar = null;
        if (calendar != null) {
            newCalendar = Calendar.getInstance();
            newCalendar.setTimeInMillis(calendar.getTimeInMillis());
            newCalendar.set(Calendar.HOUR, 0);
            newCalendar.set(Calendar.HOUR_OF_DAY, 0);
            newCalendar.set(Calendar.MINUTE, 0);
            newCalendar.set(Calendar.SECOND, 0);
            newCalendar.set(Calendar.MILLISECOND, 0);
        }
        return newCalendar;
    }

    public static Calendar getDataHoraFinalDia(Calendar calendar) {
        Calendar newCalendar = null;
        if (calendar != null) {
            newCalendar = Calendar.getInstance();
            newCalendar.setTimeInMillis(calendar.getTimeInMillis());
            newCalendar.set(Calendar.HOUR_OF_DAY, 23);
            newCalendar.set(Calendar.MINUTE, 59);
            newCalendar.set(Calendar.SECOND, 59);
            newCalendar.set(Calendar.MILLISECOND, 999);
        }
        return newCalendar;
    }

    public static String getDataFormatada(Calendar calendar) {
        String dataFormatada = null;
        if (calendar != null) {
            dataFormatada = formataDataHora(calendar.getTime(), DD_MM_YYYY);
        }
        return dataFormatada;
    }

    public static boolean getDiasUteis (Calendar dataInicial, FeriadoRepository feriadoRepository, int dias) {
        int i=0;
        boolean bool = true;
        if (dataInicial != null) {
            while (i < dias) {
                dataInicial = addDays(dataInicial, 1);
                Long feriado = feriadoRepository.countByDataFeriado(dataInicial);
                if (feriado.intValue()==0 && dataInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && dataInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    i++;
                }
            }
            dataInicial = DataUtil.getDataHoraInicioDia(dataInicial);
            bool = dataInicial.compareTo(getDataHoraInicioDia(Calendar.getInstance())) < 0;
        }
        return bool;
    }
}
