package com.pulse.provarh.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import com.pulse.provarh.datasource.model.Ponto;
import com.pulse.provarh.respository.FuncionarioRepository;
import com.pulse.provarh.respository.PontoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters.LocalDateToDateConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/ponto")
public class PontoController {
    @Autowired
    private PontoRepository pontoRepo;
    @Autowired
    private FuncionarioRepository funcrepo;


    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<Ponto>> buscaPontoId(
            @PathVariable(name = "id", required = true) final Long idfuncioarioLong) {
        return ResponseEntity.ok(pontoRepo.findById(idfuncioarioLong));
    }
    @GetMapping(path = "/idfuncionario/{id}")
    public ResponseEntity<List<Ponto>> buscaFuncionarioId(
            @PathVariable(name = "id", required = true) final Long idfuncioarioLong) {
        return ResponseEntity.ok(pontoRepo.findByFuncionarioId(idfuncioarioLong));
    }

    @GetMapping(path = "/list/all")
    public ResponseEntity<List<Ponto>> buscarTodosPontos() {
        return ResponseEntity.ok(pontoRepo.findAll());
    }

    /*
    @param funcionarioId (long)
    */
    @PostMapping(path = "/registrar")
    public ResponseEntity<String> CadastraPontoId(
            @RequestParam final long idfunc) {
        final TimeZone tzone = TimeZone.getTimeZone("America/Fortaleza");
        TimeZone.setDefault(tzone);
        // cria novo objeto de Ponto
        final Ponto pontos = new Ponto();
        // obtem agora
        final Date in = new Date();
        final LocalDate ldt = LocalDate.ofInstant(in.toInstant(), ZoneId.systemDefault());
        final Date dataO = LocalDateToDateConverter.INSTANCE.convert(ldt);
        // variaveis de tempo e verificação
        final LocalTime agora = LocalTime.now();
        final LocalTime rage11 = LocalTime.of(8, 00);
        final LocalTime rage12 = LocalTime.of(8, 15);
        final LocalTime rage21 = LocalTime.of(12, 00);
        final LocalTime rage22 = LocalTime.of(12, 15);
        final LocalTime rage31 = LocalTime.of(14, 00);
        final LocalTime rage32 = LocalTime.of(14, 15);
        final LocalTime rage41 = LocalTime.of(18, 00);
        final LocalTime rage42 = LocalTime.of(18, 15);
        // compara o Agora com as horas de range
        final int isrange11 = agora.compareTo(rage11);
        final int isrange12 = agora.compareTo(rage12);
        final int isrange21 = agora.compareTo(rage21);
        final int isrange22 = agora.compareTo(rage22);
        final int isrange31 = agora.compareTo(rage31);
        final int isrange32 = agora.compareTo(rage32);
        final int isrange41 = agora.compareTo(rage41);
        final int isrange42 = agora.compareTo(rage42);
        // verifica se já há @Data e @Funcionario existente em Ponto
        final boolean isFunPonto = pontoRepo.existsByDataPontoAndFuncionarioId(dataO, idfunc);
        final boolean isFun = funcrepo.existsById(idfunc);
        final boolean isData = pontoRepo.existsByDataPonto(dataO);
        final DayOfWeek diasemana = ldt.getDayOfWeek();
        System.out.println("Existe Data:" + isData + "|| Existe Funcio: " + isFun);

        if (!isFunPonto && isFun)// se não houver @funcionario em PONTO e FUNCIONARIO
        {
            if (!isData)// verifica se há data existente
            {
                pontos.setFuncionario(funcrepo.getOne(idfunc));
                pontos.setDataPonto(dataO);
                pontos.setDayOfSem(diasemana);
                    if(isrange11>= 0 && isrange12 <= 0 ) // Verifica o @agora estiver entre os valores de ranges(8:00 e 8:15)
                    {

                        pontos.setCheckOne(LocalTime.of(8, 00, 00));
                    }
                    else if(isrange12> 0 && isrange21 < 0)
                    {

                        pontos.setCheckOne(agora);
                    }
                    else if(isrange21>= 0 && isrange22 <= 0) // 12:00 e 12:15
                    {
                        pontos.setCheckTwo(LocalTime.of(12, 00, 00));
                    }
                    else if(isrange22> 0 && isrange31 < 0)
                    {
                        pontos.setCheckTwo(agora);
                    }      
                    else if(isrange31>= 0 && isrange32 <= 0) // 14:00 e 14:15
                    {


                        pontos.setCheckThree(LocalTime.of(14, 00, 00));
                        }
                    else if(isrange32> 0 && isrange41 < 0)
                    {
                        pontos.setCheckThree(agora);
                        } 
                    else if(isrange41>= 0 && isrange42 <= 0) // 18:00 e 18:15
                    {
                        pontos.setFuncionario(funcrepo.getOne(idfunc));

                        pontos.setCheckFour(LocalTime.of(18, 00, 00));
                        }
                    else{
                        pontos.setFuncionario(funcrepo.getOne(idfunc));

                        pontos.setHoraExtra(agora);
                    }
                    pontoRepo.saveAndFlush(pontos);
                    return ResponseEntity.ok("Info: Ponto diário iniciado!");

                }
                    else
                    {
                        return ResponseEntity.ok("Error: Data existente");
                    }

                }
                else
                {
                    
                        final Ponto anterior = pontoRepo.findByDataPontoAndFuncionarioId(dataO, idfunc);
                        final boolean isNullOne = pontoRepo.existsByIdAndCheckOneIsNull(anterior.getId());
                        final boolean isNullTwo =  pontoRepo.existsByIdAndCheckTwoIsNull(anterior.getId());
                        final boolean isNullThree = pontoRepo.existsByIdAndCheckThreeIsNull(anterior.getId());
                        final boolean isNullFour = pontoRepo.existsByIdAndCheckFourIsNull(anterior.getId());
                        final boolean isNullHoraExtra = pontoRepo.existsByIdAndHoraExtraIsNull(anterior.getId());
                        
                        pontos.setId(anterior.getId());
                        pontos.setFuncionario(funcrepo.getOne(idfunc));
                        pontos.setDataPonto(dataO);
                        pontos.setDayOfSem(diasemana);
                        System.out.println("||Ñ Existe 1:" + isNullOne +"||Ñ Existe 2:" + isNullTwo +"||Ñ Existe 3:" + isNullThree + "|| Existe 4:" + isNullFour + "||IDPONTO: " + anterior.getId() + "|| Agora" + agora); 
                        
                        if(!isNullOne) // verifica se já há valores persistidos para não haver perca de dados
                        {
                            pontos.setCheckOne(anterior.getCheckOne());
                        }
                        if(!isNullTwo){
                            pontos.setCheckTwo(anterior.getCheckTwo());
                        }
                        if(!isNullThree){
                            pontos.setCheckThree(anterior.getCheckThree());
                        }
                        if(!isNullFour){
                            pontos.setCheckFour(anterior.getCheckFour());
                        } 

                        if(isrange11>= 0 && isrange12 <= 0 && isNullOne) // Verifica o @agora estiver entre os valores de ranges(8:00 e 8:15)
                        {

                            pontos.setCheckOne(LocalTime.of(8, 00, 00));
                        }
                        if(isrange12> 0 && isrange21 < 0 && isNullOne)
                        {

                            pontos.setCheckOne(agora);
                        }
                        if(isrange21>= 0 && isrange22 <= 0 && isNullTwo) // 12:00 e 12:15
                        {

                            pontos.setCheckTwo(LocalTime.of(12, 00, 00));
                        }
                        if(isrange22> 0 && isrange31 < 0 && isNullTwo)
                        {

                            pontos.setCheckTwo(agora);
                        }      
                        if(isrange31>= 0 && isrange32 <= 0 && isNullThree) // 14:00 e 14:15
                        {

                            pontos.setCheckThree(LocalTime.of(14, 00, 00));
                        }
                        if(isrange32> 0 && isrange41 < 0 && isNullThree)
                        {
                            pontos.setCheckThree(agora);
                        } 
                        if(isrange41>= 0 && isrange42 <= 0 && isNullFour) // 18:00 e 18:15
                        {
                            pontos.setCheckFour(LocalTime.of(18, 00, 00));
                        }
                        if (ldt.getDayOfWeek() == DayOfWeek.SUNDAY && isNullHoraExtra) // computa Hora Extra no Domingo
                         {
                            pontos.setHoraExtra(agora);
                        }
                    //pontos.setSaldoDia(saldoDia);
                    
                    //final LocalTime somatempo = LocalTime.of(00, 00);
                    //pontos.setSaldoDia(somatempo.plusMinutes(anterior.getCheckOne().getMinute()).plusMinutes(anterior.getCheckTwo().getMinute()).plusMinutes(anterior.getCheckThree().getMinute()).plusMinutes(anterior.getCheckFour().getMinute()));
                    pontoRepo.saveAndFlush(pontos);
                    return ResponseEntity.ok("INFO: Pontos Atualizados");
        }

    } 
}