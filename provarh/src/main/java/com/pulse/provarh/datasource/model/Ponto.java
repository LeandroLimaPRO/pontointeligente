package com.pulse.provarh.datasource.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "ponto")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "funcionario_id", nullable = false)
    @JsonBackReference
    private Funcionario funcionario;

    @Column
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date dataPonto;
    @Column
    private DayOfWeek dayOfSem;
    @Column  // 8:00 se a pessoa bater o ponto até 8:15 é o ckp1 e é considerado 8:00 10h
    private LocalTime checkOne;
    @Column // 12:00 se~~~~
    private LocalTime  checkTwo;
    @Column
    private LocalTime checkThree;
    @Column
    private LocalTime  checkFour;
    @Column
    private LocalTime  horaExtra;
    @Column//8h dia, conseguiu 9h, saldo é 1h
    private LocalTime  saldoDia;
    @Column // row sofrer alteração salvar now.
    @CreationTimestamp
    private Date dataAtualizacao;

    @SuppressWarnings("unused")
    public Ponto() {

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataPonto() {
        return this.dataPonto;
    }

    public void setDataPonto(Date dataPonto) {
        this.dataPonto = dataPonto;
    }

    public DayOfWeek getDayOfSem() {
        return this.dayOfSem;
    }

    public void setDayOfSem(DayOfWeek dayOfSem) {
        this.dayOfSem = dayOfSem;
    }

    public LocalTime getCheckOne() {
        return this.checkOne;
    }

    public void setCheckOne(LocalTime checkOne) {
        this.checkOne = checkOne;
    }

    public LocalTime getCheckTwo() {
        return this.checkTwo;
    }

    public void setCheckTwo(LocalTime checkTwo) {
        this.checkTwo = checkTwo;
    }

    public LocalTime getCheckThree() {
        return this.checkThree;
    }

    public void setCheckThree(LocalTime checkThree) {
        this.checkThree = checkThree;
    }

    public LocalTime getCheckFour() {
        return this.checkFour;
    }

    public void setCheckFour(LocalTime checkFour) {
        this.checkFour = checkFour;
    }

    public LocalTime getHoraExtra() {
        return this.horaExtra;
    }

    public void setHoraExtra(LocalTime horaExtra) {
        this.horaExtra = horaExtra;
    }

    public LocalTime getSaldoDia() {
        return this.saldoDia;
    }

    public void setSaldoDia(LocalTime saldoDia) {
        this.saldoDia = saldoDia;
    }

    public Date getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ponto)) {
            return false;
        }
        Ponto ponto = (Ponto) o;
        return id == ponto.id && Objects.equals(funcionario, ponto.funcionario) && Objects.equals(dataPonto, ponto.dataPonto) && Objects.equals(dayOfSem, ponto.dayOfSem) && Objects.equals(checkOne, ponto.checkOne) && Objects.equals(checkTwo, ponto.checkTwo) && Objects.equals(checkThree, ponto.checkThree) && Objects.equals(checkFour, ponto.checkFour) && Objects.equals(horaExtra, ponto.horaExtra) && Objects.equals(saldoDia, ponto.saldoDia) && Objects.equals(dataAtualizacao, ponto.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funcionario, dataPonto, dayOfSem, checkOne, checkTwo, checkThree, checkFour, horaExtra, saldoDia, dataAtualizacao);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", funcionario='" + getFuncionario() + "'" +
            ", dataPonto='" + getDataPonto() + "'" +
            ", dayOfSem='" + getDayOfSem() + "'" +
            ", checkOne='" + getCheckOne() + "'" +
            ", checkTwo='" + getCheckTwo() + "'" +
            ", checkThree='" + getCheckThree() + "'" +
            ", checkFour='" + getCheckFour() + "'" +
            ", horaExtra='" + getHoraExtra() + "'" +
            ", saldoDia='" + getSaldoDia() + "'" +
            ", dataAtualizacao='" + getDataAtualizacao() + "'" +
            "}";
    }

}