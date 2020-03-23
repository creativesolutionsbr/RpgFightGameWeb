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
public class Personagem {

    /**
     * Id unico do personagem.
     */
    private int personagemId;
    
    /**
     * Nome do personagem
     */
    private String nomePersonagem;

    /**
     * Quantidade de pontos de vida (PdV)
     */
    private int pontosVida;

    /**
     * Pontos de força.
     */
    private int forca;

    /**
     * Pontos de defesa.
     */
    private int defesa;

    /**
     * Pontos de agilidade.
     */
    private int agilidade;

    /**
     * Fator de Dano (FdD).
     */
    private String fatorDano;

    /**
     * Tipo do personagem.
     */
    private boolean monstro;
    
    /**
     * Construtor padrão
     */
    public Personagem() {
    }

    /**
     * Construtor com parametros
     * @param personagemId - Id do personagem
     * @param nomePersonagem - nome do personagem
     * @param pontosVida - pontos de vida inicial
     * @param forca - pontos de força inicial
     * @param defesa - pontos de defesa inicial
     * @param agilidade - pontos de agilidade
     * @param fatorDano - dado de fator de dano
     */
    public Personagem(int personagemId, String nomePersonagem, int pontosVida, int forca, int defesa, int agilidade, String fatorDano, boolean ehMonstro) {
        this.personagemId = personagemId;
        this.nomePersonagem = nomePersonagem;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.fatorDano = fatorDano;
        this.monstro = ehMonstro;
    }

    public int getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(int personagemId) {
        this.personagemId = personagemId;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public String getFatorDano() {
        return fatorDano;
    }

    public void setFatorDano(String fatorDano) {
        this.fatorDano = fatorDano;
    }

    public boolean isMonstro() {
        return monstro;
    }

    @Override
    public String toString() {
        return "Personagem{" + "nomePersonagem=" + nomePersonagem + ", pontosVida=" + pontosVida + ", forca=" + forca + ", defesa=" + defesa + ", agilidade=" + agilidade + ", fatorDano=" + fatorDano + '}';
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.personagemId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personagem other = (Personagem) obj;
        if (this.personagemId != other.personagemId) {
            return false;
        }
        return true;
    }

}
