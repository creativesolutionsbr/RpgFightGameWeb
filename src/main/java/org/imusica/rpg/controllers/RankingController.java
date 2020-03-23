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
import org.imusica.rpg.model.Ranking;
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
@RequestMapping(path="/api/ranking")
public class RankingController {
    
    @Autowired
    private FakeDatabase fakeDB;
    
    /**
     * Método de acesso para listar todos os rankings.
     * 
     * @return Lista dos rankings.
     */
    @GetMapping
    public ResponseEntity<List<Ranking>> listar() {
        return ResponseEntity.ok(fakeDB.listAllRanking());
    }

}
