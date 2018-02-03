package au.com.afl.exercise.service;


import au.com.afl.exercise.exception.GameException;
import au.com.afl.exercise.model.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {

    private List<Player> players;
    private Integer numberOfPlayers;
    private Integer counterLimit;

    public Game(){
        this.players = new ArrayList<Player>();
    }


    /**
     * Method to initialize the players
     * @param numberOfPlayers
     * @param counterLimit
     * @throws GameException
     */
    public void init(Integer numberOfPlayers, Integer counterLimit) throws GameException {
        this.numberOfPlayers = numberOfPlayers;
        this.counterLimit = counterLimit;

        if(!isNumberGreaterThanZero(numberOfPlayers) || numberOfPlayers==1 ) {
            throw new GameException("Invalid Number of Players");
        }
        if( !isNumberGreaterThanZero(counterLimit) || counterLimit==numberOfPlayers){
            throw new GameException("Invalid counter limit");

        }
        initializePlayers(numberOfPlayers);

    }


    /**
     * Methos to start the game
     * @throws GameException
     */
    public void play() throws GameException {
        Integer currentCount = 0;
        Iterator<Player> playerIterator =  null;
        do {
            playerIterator = players.iterator();

            while (playerIterator.hasNext()) {

                Player player = playerIterator.next();

                currentCount = player.count(currentCount);
                if (isPlayerOut(currentCount)) {
                    currentCount = 0;
                    System.out.println("player "+player.getId() +" is removed from the game!");

                    playerIterator.remove();

                    if(isGameOver()){
                        break;
                    }
                }

            }
        }while (!isGameOver());
        System.out.println("player "+this.players.get(0).getId() +" WINS!");

    }

    public Boolean isGameOver(){
        return players.size()==1;
    }

    /**
     * Checks if the player is to be removed from the game
     * @param currentCount
     * @return
     */
    private boolean isPlayerOut(Integer currentCount){
        return currentCount==this.counterLimit;
    }

    /**
     * Creates the players and assigns an id to each one
     * @param numberOfPlayers
     */
    private void initializePlayers(Integer numberOfPlayers){
        for (int playerCount = 0; playerCount < numberOfPlayers; playerCount++) {
            Player player = new Player(playerCount+1);
            this.players.add(player);
        }
    }

    /**
     * Validates if number is greater than 0
     * @param number
     * @return true if > 0
     */
    private boolean isNumberGreaterThanZero(Integer number){
        if(number==null){
            return false;
        }
        return number>0;
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