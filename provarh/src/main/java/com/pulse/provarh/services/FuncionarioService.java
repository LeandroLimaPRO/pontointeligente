package com.pulse.provarh.services;


import com.pulse.provarh.datasource.model.Funcionario;
import com.pulse.provarh.respository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;


public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void cadastro(final Funcionario funcionario) {
        funcionarioRepository.saveAndFlush(funcionario);
    }   

    public void setFuncionarioRepository(final FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    
}