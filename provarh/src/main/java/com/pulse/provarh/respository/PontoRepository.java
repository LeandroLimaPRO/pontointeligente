package com.pulse.provarh.respository;

import java.util.Date;
import java.util.List;

import com.pulse.provarh.datasource.model.Ponto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {

	List<Ponto> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	boolean existsByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	boolean existsByDataPonto(Date data);
	boolean existsByDataPontoAndFuncionarioId(Date data, Long funcionarioId);
	Ponto findByDataPontoAndFuncionarioId(Date data, Long funcionarioId);
	boolean findByIdAndCheckOneIsNull(long id);
	boolean findByIdAndCheckTwoIsNull(long id);
	boolean findByIdAndCheckThreeIsNull(long id);
	boolean findByIdAndCheckFourIsNull(long id);
	boolean existsByIdAndCheckOneIsNull(long id);
	boolean existsByIdAndCheckTwoIsNull(long id);
	boolean existsByIdAndCheckThreeIsNull(long id);
	boolean existsByIdAndCheckFourIsNull(long id);
	boolean existsByIdAndHoraExtraIsNull(long id);


}

