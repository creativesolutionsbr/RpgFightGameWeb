/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.esb.events;

import java.util.Random;
import org.springframework.context.ApplicationEvent;

/**
 * Evento para jogar dados.
 * @author bq4d
 */
public class RolarDadoEvent extends ApplicationEvent {
    
    /**
     * Numero de dados
     */
    private int numDados;
    
    /**
     * Numero de faces
     */
    private int numFaces;
    
    /**
     * Resultado apos rolar o(s) dado(s).
     */
    private int resultado;
    
    /**
     * Construtor do evento
     * @param source - atributo da superclasse.
     * @param tipoDado - tipo do dado 1d6, 1d10, etc...
     */
    public RolarDadoEvent(Object source, String tipoDado) {
        super(source);
        init(tipoDado);
        jogarDado();
    }
    
    private void init(String tipoDado) {
        String[] result = tipoDado.split("d");
        this.numDados = Integer.parseInt(result[0]);
        this.numFaces = Integer.parseInt(result[1]);
        this.resultado = 0;
    }
    
    private void jogarDado() {
        int i = 1;        
        Random dado = new Random();
        while (i <= numDados) {            
            this.resultado += (dado.nextInt(numFaces) +1);
            i++;
        }
    }

    public int getResultado() {
        return resultado;
    }
}
