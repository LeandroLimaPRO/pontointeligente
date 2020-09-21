package com.pulse.provarh.resource.model;

import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PontoResource {
    @JsonProperty
    private long ponto;
    @JsonProperty
    private Date data;
    @JsonProperty
    private LocalTime ckp1;
    @JsonProperty
    private LocalTime ckp2;
    @JsonProperty
    private LocalTime ckp3;
    @JsonProperty
    private LocalTime ckp4;
    @JsonProperty
    private LocalTime horaextra;
    @JsonProperty
    private LocalTime saldodia;
    @JsonProperty
    private Date atualizacao;

    
    @SuppressWarnings("unused")
    public PontoResource() {

    }

    public long getIdponto() {
        return this.ponto;
    }

    public void setIdponto(final long idponto) {
        this.ponto = idponto;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(final Date data) {
        this.data = data;
    }

    public LocalTime getCkp1() {
        return this.ckp1;
    }

    public void setCkp1(final LocalTime ckp1) {
        this.ckp1 = ckp1;
    }

    public LocalTime getCkp2() {
        return this.ckp2;
    }

    public void setCkp2(final LocalTime ckp2) {
        this.ckp2 = ckp2;
    }

    public LocalTime getCkp3() {
        return this.ckp3;
    }

    public void setCkp3(final LocalTime ckp3) {
        this.ckp3 = ckp3;
    }

    public LocalTime getCkp4() {
        return this.ckp4;
    }

    public void setCkp4(final LocalTime ckp4) {
        this.ckp4 = ckp4;
    }

    public LocalTime getHoraextra() {
        return this.horaextra;
    }

    public void setHoraextra(final LocalTime horaextra) {
        this.horaextra = horaextra;
    }

    public LocalTime getSaldodia() {
        return this.saldodia;
    }

    public void setSaldodia(final LocalTime saldodia) {
        this.saldodia = saldodia;
    }

    public Date getAtualizacao() {
        return this.atualizacao;
    }

    public void setAtualizacao(final Date atualizacao) {
        this.atualizacao = atualizacao;
    }



}