package br.com.company.fks.utils;

import br.com.company.fks.repositorio.FeriadoRepository;
import gherkin.lexer.Ca;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by diego on 03/01/17.
 */
@RunWith(PowerMockRunner.class)
public class DataUtilTest {

    private static final String DD_MM_YYYY = "dd/MM/yyyy";
    private static final String HH_MM = "HH:mm";

    @Mock
    private FeriadoRepository feriadoRepository;

    @Test(expected = IllegalAccessError.class)
    @SneakyThrows
    public void testaInstancia() {
        Constructor<DataUtil> constructor = DataUtil.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void formataDataHoraFormatandoData() {
        Date data = new Date();
        String dataFormatada = dataFormatada(data, DD_MM_YYYY);
        assertEquals(dataFormatada, DataUtil.formataDataHora(data, DD_MM_YYYY));
    }

    @Test
    public void formataDataHoraFormatandoDataNull() {
        assertEquals(null, DataUtil.formataDataHora(null, DD_MM_YYYY));
    }

    @Test
    public void formataDataHoraFormatandoHora() {
        Date data = new Date();
        String horaFormatada = dataFormatada(data, HH_MM);
        assertEquals(horaFormatada, DataUtil.formataDataHora(data, HH_MM));
    }

    @Test
    public void formataDataAtual() {
        Date data = new Date();
        String horaFormatata = dataFormatada(data, DD_MM_YYYY);
        assertEquals(horaFormatata, DataUtil.getDataAtualFormatada());
    }

    @Test
    public void formataHoraAtual() {
        Date data = new Date();
        String horaFormatata = dataFormatada(data, HH_MM);
        assertEquals(horaFormatata, DataUtil.getHoraAtualFormatada());
    }

    private String dataFormatada(Date data, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(data);
    }

    @Test
    @SneakyThrows
    public void converterLocalDate() {
        LocalDate dataAtual = LocalDate.now();
        Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataAtual.toString());
        LocalDate dataEsperada = DataUtil.converterLocalDate(data);
        assertEquals(dataAtual, dataEsperada);
    }

    @Test
    @SneakyThrows
    public void converterLocalDateRetornadoNulo() {
        LocalDate dataEsperada = DataUtil.converterLocalDate(null);
        assertNull(dataEsperada);
    }

    @Test
    public void testeIsAntes19Hs() {
        Calendar newCalendar = null;
        Calendar calendar = Calendar.getInstance();
        newCalendar = Calendar.getInstance();
        newCalendar.setTimeInMillis(calendar.getTimeInMillis());
        newCalendar.set(Calendar.HOUR_OF_DAY, 18);
        newCalendar.set(Calendar.MINUTE, 59);
        newCalendar.set(Calendar.SECOND, 59);
        newCalendar.set(Calendar.MILLISECOND, 999);
        Boolean teste = DataUtil.isAntes19Hs(newCalendar);
        assertTrue(teste);
    }

    @Test
    public void getDataHoraFinalDiaImportacaoTest(){
        Calendar calendar = Calendar.getInstance();
        DataUtil.getDataHoraFinalDiaImportacao(calendar);
    }

    @Test
    public void getDataHoraFinalDiaImportacaoNull(){
        Calendar calendar = null;
        DataUtil.getDataHoraFinalDiaImportacao(null);
    }

    @Test
    public void getDataHoraInicioDiaTest(){
        Calendar calendar = Calendar.getInstance();
        DataUtil.getDataHoraInicioDia(calendar);
    }

    @Test
    public void getDataHoraFinalDia(){
        Calendar calendar = Calendar.getInstance();
        DataUtil.getDataHoraFinalDia(calendar);
    }

    @Test
    public void getDataFormatadaTest(){
        Calendar calendar = Calendar.getInstance();
        DataUtil.getDataFormatada(calendar);

    }


    @Test
    public void getDataFormatadaNullTest(){
        Calendar calendar = null;
        DataUtil.getDataFormatada(calendar);
    }

    @Test
    public void verificaFeriadoFinalDeSemanaTest(){
        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.SATURDAY);
        DataUtil.verificaFeriadoFinalDeSemana(calendar);
        assertTrue(true);

    }

    @Test
    public void verificaFeriadoFinalDeSemanaIfTest(){
        Calendar calendar = Calendar.getInstance();
        calendar.setWeekDate(7, 7, 1);
        DataUtil.verificaFeriadoFinalDeSemana(calendar);
        assertTrue(true);

    }

    @Test
    public void addDaysTest(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(anyLong());
        DataUtil.addDays(calendar, 5);
        assertTrue(true);
    }

    @Test
    public void addDaysTestNull(){
        Calendar calendar = null;
        DataUtil.addDays(calendar, 1);
        assertNull(null);
    }

    @Test
    public void isDiaUtil(){
        Calendar calendar = Calendar.getInstance();
        List<Calendar> calendarList = new ArrayList<>();
        calendar.get(Calendar.THURSDAY);
        DataUtil.isDiaUtil(calendar, calendarList);
        assertTrue(true);
    }

    @Test
    public void isNaoDiaUtil(){
        Calendar calendar = Calendar.getInstance();
        List<Calendar> calendarList = new ArrayList<>();
        calendarList.add(calendar);
        calendar.get(Calendar.DAY_OF_MONTH);
        calendar.get(Calendar.MONTH);
        calendar.get(calendar.YEAR);
        DataUtil.isFeriado(calendar, calendarList);
        assertTrue(true);
    }

    @Test
    public void isFeriado(){
        Calendar calendar = Calendar.getInstance();
        List<Calendar> calendarList = new ArrayList<>();
        calendarList.add(calendar);
        calendar.get(Calendar.DAY_OF_MONTH);
        calendar.get(Calendar.MONTH);
        calendar.get(calendar.YEAR);
        DataUtil.isFeriado(calendar, calendarList);
        assertTrue(true);
    }

    @Test
    public void verificaFeriadoFinalDeSemanaNullTest(){
        Calendar calendar = Calendar.getInstance();
        DataUtil.verificaFeriadoFinalDeSemana(calendar);
        assertTrue(true);
    }

    @Test
    public void recuperarProximoDiaUtil(){
        List<Calendar> calendarList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(anyLong());
        calendar.get(Calendar.DAY_OF_MONTH);
        DataUtil.recuperarProximoDiaUtil(calendar, calendarList);
        assertTrue(true);
    }

    @Test
    public void somarDiasUteisTest(){
        List<Calendar> calendarList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(anyLong());
        calendar.get(Calendar.DATE);
        DataUtil.somarDiasUteis(calendar, 1, calendarList);
        assertTrue(true);
    }

    @Test
    public void somarDiasUteisTest2(){
        List<Calendar> calendarList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        DataUtil.somarDiasUteis(calendar, 0, calendarList);
        assertTrue(true);
    }

    @Test
    public void getDiasUteisTest(){
        Calendar calendar = Calendar.getInstance();
        DataUtil.getDiasUteis(calendar, feriadoRepository, 1);
        assertTrue(true);
    }

    @Test
    public void getDiasUteisTestNull(){
        DataUtil.getDiasUteis(null, feriadoRepository, 1);
        assertNull(null);
    }

}
