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
 * Evento que sorteia o oponente
 * @author bq4d
 */
public class SorteiaOponenteEvent extends ApplicationEvent {

    /**
     * Resultado do sorteio
     */
    private int resultado;
    
    /**
     * Cosntrutor 
     * @param source - objeto da superclasse
     */
    public SorteiaOponenteEvent(Object source) {
        super(source);
        this.sortear();
    }
    
    private void sortear() {
        Random sorter = new Random();
        this.resultado = sorter.nextInt(2)+1;
    }

    public int getResultado() {
        return resultado;
    }
}
