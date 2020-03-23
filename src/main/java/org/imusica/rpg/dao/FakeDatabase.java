/*
 * Petrobras Distribuidora S.A.
 * Copyright (C) 2019 Petrobras Distribuidora S.A.
 * 
 * ------------------------------------------------
 * Sonda ProcWork Informatica Ltda.
 */
package org.imusica.rpg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.imusica.rpg.model.Batalha;
import org.imusica.rpg.model.Personagem;
import org.imusica.rpg.model.Ranking;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author bq4d
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FakeDatabase {
    
    private static Map<Integer,Personagem> heroiList = new HashMap<>();
    private static Map<Integer,Personagem> oponenteList = new HashMap<>();
    private static Map<String,Ranking> rankingList = new HashMap<>();
        
    static {
        heroiList.put(1, new Personagem(1,"Guerreiro", 12, 4, 3, 3, "2d4", false));
        heroiList.put(2, new Personagem(2,"Bárbaro", 13, 6, 1, 3, "2d6", false));
        heroiList.put(3, new Personagem(3,"Paladino", 15, 2, 5, 1, "2d4", false));

        oponenteList.put(1, new Personagem(4,"Morto-Vivo", 25, 4, 0, 1, "2d4", true));
        oponenteList.put(2, new Personagem(5,"Orc", 20, 6, 2, 2, "1d8", true));
        oponenteList.put(3, new Personagem(6,"Kobold", 20, 4, 2, 4, "3d2", true));
        
        rankingList.put("Jhon"   ,new Ranking("Jhon", 300, 3));
        rankingList.put("Michael",new Ranking("Michael", 200, 2));
        rankingList.put("Adrian" ,new Ranking("Adrian", 100, 1));
    }
    
    public Personagem getHeroById(int id) {
        return heroiList.get(id);
    }
    
    public List<Personagem> findAllHeros() {
        return new ArrayList<>(heroiList.values());
    }

    public Personagem getOponentById(int id) {
        return oponenteList.get(id);
    }
    
    public List<Ranking> listAllRanking() {
        return new ArrayList<>(rankingList.values());
    }
    
    public Ranking getRankingByNickname(String nickname) {
        return rankingList.get(nickname);
    }
        
    public void updateRanking(String nickName, int points) {
        Ranking rank = rankingList.get(nickName);
        if(rank != null) {
            rank.setPontuacao((rank.getPontuacao() + points) - rank.getTurno());
            rank.setTurno(rank.getTurno() + 1);
        } else {
            rank = new Ranking(nickName, points, 1);
            rankingList.put(nickName, rank);
        }
        rankingList.put(nickName, rank);
    }
}
