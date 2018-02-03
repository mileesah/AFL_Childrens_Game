package au.com.afl.exercise.service;


import au.com.afl.exercise.exception.GameException;
import au.com.afl.exercise.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Integer numberOfPlayers;
    private Integer counterLimit;

    public Game(){
        this.players = new ArrayList<Player>();
    }



    public void init(Integer numberOfPlayers, Integer counterLimit) {
        this.numberOfPlayers = numberOfPlayers;
        this.counterLimit = counterLimit;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public Integer getCounterLimit() {
        return counterLimit;
    }

}