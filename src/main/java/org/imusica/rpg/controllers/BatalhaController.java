/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.controllers;

import javax.validation.Valid;
import org.imusica.rpg.dao.FakeDatabase;
import org.imusica.rpg.esb.publishers.BatalhaManager;
import org.imusica.rpg.model.Batalha;
import org.imusica.rpg.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bq4d
 */
@RestController
@RequestMapping(path="/api/batalha")
public class BatalhaController {
    
    /**
     * Serviço de Batalha a ser utilizado.
     */
    @Autowired
    private BatalhaManager bManager;

    @Autowired
    private FakeDatabase fakeDB;
    
    @PostMapping("/escolherNickname")
    public ResponseEntity<Batalha> nickname(@RequestBody String nickname) {
        if(fakeDB.getRankingByNickname(nickname) == null) {            
            bManager.setBatalha(new Batalha(nickname, null, null));
        }
        return ResponseEntity.ok(bManager.getBatalha());
    }
    
    @PostMapping("/escolherHeroi")
    public ResponseEntity<Batalha> escolherHeroi(@RequestBody String heroiId) {
        try
        {
            if(fakeDB.getHeroById(Integer.parseInt(heroiId)) == null) {
                return new ResponseEntity("Heroi não encontrado", HttpStatus.NOT_FOUND);
            }
            Batalha batalha = bManager.getBatalha();
            batalha.setHeroi(fakeDB.getHeroById(Integer.parseInt(heroiId)));
            bManager.setBatalha(batalha);
            return ResponseEntity.ok(batalha);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/batalhar")
    public ResponseEntity<Batalha> batalhar(@Valid @RequestBody Batalha batalha ) {
        if((batalha.getNickname() == null) || (batalha.getNickname().length() == 0)) {
            return new ResponseEntity("Escolha um Nickname antes de iniciar a batalha", HttpStatus.BAD_REQUEST);
        }
        
        if(batalha.getHeroi() == null) {
            return new ResponseEntity("Escolha um personagem antes de iniciar a batalha", HttpStatus.NOT_FOUND);
        }
        bManager.sortearOponente();
        bManager.iniciarBatalha();
        return ResponseEntity.ok(bManager.getBatalha());
    }

    @GetMapping("/resultado")
    public ResponseEntity<Personagem> resultado() {
        return ResponseEntity.ok(bManager.getBatalha().getWinner());
    }
}
