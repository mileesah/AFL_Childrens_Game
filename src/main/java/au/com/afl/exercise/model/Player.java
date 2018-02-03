package au.com.afl.exercise.model;


import au.com.afl.exercise.exception.GameException;

public class Player {


    private Integer id;

    public Player(Integer id){
        this.id = id;
    }

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
