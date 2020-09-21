package com.pulse.provarh.respository;

import com.pulse.provarh.datasource.model.Funcionario;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{
    Optional<Funcionario> findByNomeCompleto(String nomeCompleto);
    Boolean existsByNomeCompleto(String nomeCompleto);

    Boolean existsByEmail(String email);
    Optional<Funcionario> findByEmailAndSenha(String email, String senha);
    List<Funcionario> findByPonto_DataPontoAndPonto_CheckFourIsNull(Date output);
	List<Funcionario> findByPonto_DataPontoAndPonto_CheckFourIsNullOrPonto_CheckThreeIsNullOrPonto_CheckTwoIsNullOrPonto_CheckOneIsNull(
            Date output);
    List<Funcionario> findByDataNascimentoLessThanEqualAndPonto_SaldoDiaGreaterThanEqual(Date maxData, LocalTime minSaldo);
    
}