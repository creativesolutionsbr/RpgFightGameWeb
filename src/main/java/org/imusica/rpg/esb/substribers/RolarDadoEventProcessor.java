/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.esb.substribers;

import org.imusica.rpg.esb.events.RolarDadoEvent;
import org.imusica.rpg.esb.publishers.BatalhaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Subscriber/Listener para o evento RolarDado
 * @author bq4d
 */
@Component
public class RolarDadoEventProcessor implements ApplicationListener<RolarDadoEvent> {
    
    @Autowired
    private BatalhaManager batalha;

    @Override
    public void onApplicationEvent(RolarDadoEvent event){
        batalha.setValorDado(event.getResultado());
    }
}
