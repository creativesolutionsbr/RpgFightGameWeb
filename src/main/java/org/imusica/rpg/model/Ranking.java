/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.model;

/**
 *
 * @author bq4d
 */
public class Ranking implements Comparable {

    private String nickname;
    
    private Integer pontuacao;
    
    private Integer turno;

    public Ranking() {
    }

    public Ranking(String nickname, Integer pontuacao, Integer turno) {
        this.nickname = nickname;
        this.pontuacao = pontuacao;
        this.turno = turno;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }    

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }
    
    @Override
    public int compareTo(Object outroRanking) {
        if (this.pontuacao > ((Ranking)outroRanking).getPontuacao()) {
            return 1;
        }
        if (this.pontuacao < ((Ranking)outroRanking).getPontuacao()) {
            return -1;
        }
        return 0;
    }
}
