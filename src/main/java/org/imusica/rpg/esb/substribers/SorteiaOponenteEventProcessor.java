/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.esb.substribers;

import org.imusica.rpg.dao.FakeDatabase;
import org.imusica.rpg.esb.events.SorteiaOponenteEvent;
import org.imusica.rpg.esb.publishers.BatalhaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author bq4d
 */
@Component
public class SorteiaOponenteEventProcessor implements ApplicationListener<SorteiaOponenteEvent>{

    @Autowired
    private FakeDatabase fakeDB;
    
    @Autowired
    private BatalhaManager manager;

    @Override
    public void onApplicationEvent(SorteiaOponenteEvent event) {
        this.manager.getBatalha().setOponente(fakeDB.getOponentById(event.getResultado()));
        System.out.println("Batalha entre: ");
        System.out.println(this.manager.getBatalha().getHeroi().getNomePersonagem());
        System.out.println(" X ");
        System.out.println(this.manager.getBatalha().getOponente().getNomePersonagem());
    }    
}
