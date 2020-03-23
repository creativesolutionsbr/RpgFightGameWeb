/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.esb.substribers;

import org.imusica.rpg.dao.FakeDatabase;
import org.imusica.rpg.esb.events.ProcessaAtaqueEvent;
import org.imusica.rpg.esb.publishers.BatalhaManager;
import org.imusica.rpg.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author bq4d
 */
@Component
public class ProcessarAtaqueEventProcessor implements ApplicationListener<ProcessaAtaqueEvent>{

    @Autowired
    private BatalhaManager bManager;
    
    @Autowired
    private FakeDatabase fakedb;

    @Override
    public void onApplicationEvent(ProcessaAtaqueEvent event) {
        this.bManager.rolarDado("1d10");
        int valorDado = this.bManager.getValorDado();
        int valorAtacante = valorDado + event.getAtacante().getAgilidade() + event.getAtacante().getForca();
        int valorDefesa = valorDado + event.getDefensor().getAgilidade() + event.getDefensor().getDefesa(); 
        int valorDano = 0;
        Personagem winner = null;
        
        if(valorAtacante > valorDefesa) {
            // o atacante é o vencedor e o dano é calculado
            valorDano = this.calculaDano(event.getDefensor());
            event.getDefensor().setPontosVida(event.getDefensor().getPontosVida() - valorDano);
            winner = event.getAtacante();
        } else if(valorDefesa == valorAtacante) {
            // Caso dê empate, o defensor ganha e nenhum dano é sofrido.
            winner = event.getDefensor();
        } else {
            // se não houver vencedor, sorteia.
            winner = (valorDano % 2 == 0) ? event.getAtacante() : event.getDefensor();
        }
        
        if(event.getAtacante().getPontosVida() <= 0) {
            bManager.getBatalha().setWinner(event.getDefensor());
            if(!event.getAtacante().isMonstro()) {
                fakedb.updateRanking(bManager.getBatalha().getNickname(), 100);
            }
        } else if(event.getDefensor().getPontosVida() <= 0) {
            bManager.getBatalha().setWinner(event.getAtacante());
            if(!event.getAtacante().isMonstro()) {
                fakedb.updateRanking(bManager.getBatalha().getNickname(), 100);
            }
        } else if((event.getAtacante().getPontosVida() > 0) || (event.getDefensor().getPontosVida() > 0)) {
            if(winner.equals(event.getAtacante()) ) {
                bManager.processaAtaque(event.getDefensor(), winner);
            } 
            else {
                bManager.processaAtaque(event.getAtacante(), winner);
            }            
        } 
    }
        
    private int calculaDano(Personagem personagem) {
        int result;
        this.bManager.rolarDado(personagem.getFatorDano());
        result = this.bManager.getValorDado() + personagem.getForca();
        return result;
    }
}
