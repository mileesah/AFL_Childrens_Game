package au.com.afl.exercise.model;


import au.com.afl.exercise.exception.GameException;

/**
 * Player Model
 */
public class Player {


    private Integer id;

    public Player(Integer id){
        this.id = id;
    }

    /**
     * Increments the currentCount
     * @param currentCount
     * @return currentCount +1
     * @throws GameException if currentCount is null
     */
    public Integer count(Integer currentCount) throws  GameException{


        if(currentCount==null){
            throw new GameException("Invalid Count");
        }
        return  currentCount + 1;
    }

    public Integer getId() {
        return id;
    }

}
