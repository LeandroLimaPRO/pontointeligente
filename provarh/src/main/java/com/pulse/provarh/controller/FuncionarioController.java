package com.pulse.provarh.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pulse.provarh.datasource.model.Funcionario;
import com.pulse.provarh.respository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters.LocalDateTimeToDateConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Optional<Funcionario>> buscafuncioarioid(
            @PathVariable(name = "id", required = true) final Long idfuncioarioLong) {
        return ResponseEntity.ok(funcionarioRepository.findById(idfuncioarioLong));
    }

    @GetMapping(path = "/list/all")
    public ResponseEntity<List<Funcionario>> buscartodos() {
        return ResponseEntity.ok(funcionarioRepository.findAll());
    }
    @GetMapping(path= "/list/ck4") // lista todos os funcionarios com menos de 4
    public ResponseEntity<List<Funcionario>> buscarmenorquatro(){
        final Date in = new Date();
        final LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        final ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        final Date output = Date.from(zdt.toInstant());
        return ResponseEntity.ok(funcionarioRepository.findByPonto_DataPontoAndPonto_CheckFourIsNullOrPonto_CheckThreeIsNullOrPonto_CheckTwoIsNullOrPonto_CheckOneIsNull(output));
    } 
    @GetMapping(path = "/list/idadesaldo")
    public ResponseEntity<List<Funcionario>> buscaridadesaldo(){
        return ResponseEntity.ok(funcionarioRepository.findByDataNascimentoLessThanEqualAndPonto_SaldoDiaGreaterThanEqual(LocalDateTimeToDateConverter.INSTANCE.convert(LocalDateTime.parse("2007-12-03T10:15:30")), LocalTime.of(2, 0)));
    }

    @PostMapping("/login")
    public ResponseEntity<Optional<Funcionario>> login(@RequestParam final String email, @RequestParam final String senha) {

        return ResponseEntity.ok(funcionarioRepository.findByEmailAndSenha(email,senha));
    }

    @PostMapping(path = "/cadastro")
    public void cadastro(@RequestBody final Funcionario funcionario) {
        funcionarioRepository.saveAndFlush(funcionario);
    }

    @PutMapping("/atualizar/{id}")
    public Funcionario atualizar(@RequestBody final Funcionario novoFuncionario, @PathVariable final Long id) {

        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNomeCompleto(novoFuncionario.getNomeCompleto());
            funcionario.setCpf(novoFuncionario.getCpf());
            funcionario.setSenha(novoFuncionario.getSenha());
            funcionario.setEmail(novoFuncionario.getEmail());
            funcionario.setDataNascimento(novoFuncionario.getDataNascimento());
            funcionario.setEndereco(novoFuncionario.getEndereco());
            funcionario.setTelefone(novoFuncionario.getTelefone());
            funcionario.setPonto(novoFuncionario.getPonto());
            return funcionarioRepository.save(funcionario);
        }).orElseGet(() -> {
            novoFuncionario.setId(id);
            return funcionarioRepository.saveAndFlush(novoFuncionario);
        });
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable final Long id) {
        funcionarioRepository.deleteById(id);
    }


    // redireciona a página inicial
    @PostMapping("/logout")
    public RedirectView handleFoo() {
        return new RedirectView("/");
    }
    

}