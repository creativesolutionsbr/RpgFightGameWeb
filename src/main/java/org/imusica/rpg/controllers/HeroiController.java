/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.controllers;

import java.util.List;
import org.imusica.rpg.dao.FakeDatabase;
import org.imusica.rpg.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bq4d
 */
@RestController
@RequestMapping(path="/api/heroi")
public class HeroiController {

    @Autowired
    private FakeDatabase fakeDB;
    
    /**
     * Método de acesso para listar todos os herois.
     * 
     * @return Lista dos herois.
     */
    @GetMapping
    public ResponseEntity<List<Personagem>> listar() {
        return ResponseEntity.ok(fakeDB.findAllHeros());
    }
    
}
