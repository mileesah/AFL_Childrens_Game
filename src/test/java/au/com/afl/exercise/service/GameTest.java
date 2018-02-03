package au.com.afl.exercise.service;


import au.com.afl.exercise.exception.GameException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameTest  {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInitGameWithValidInput(){
        Integer numberOfPlayers = 12;
        Integer counterLimit = 15;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        Assert.assertEquals(numberOfPlayers, game.getNumberOfPlayers());
        Assert.assertEquals(numberOfPlayers.intValue(), game.getPlayers().size());
        Assert.assertEquals(counterLimit, game.getCounterLimit());
    }

    @Test
    public void testInitGameWithNegativePlayers(){
        Integer numberOfPlayers = -12;
        Integer counterLimit = 15;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        thrown.expect(GameException.class);

    }

    @Test
    public void testInitGameWithNegativeCounterLimit(){
        Integer numberOfPlayers = 12;
        Integer counterLimit = -15;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        thrown.expect(GameException.class);

    }


    @Test
    public void testInitGameWithNullValues(){
        Integer numberOfPlayers = null;
        Integer counterLimit = null;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        thrown.expect(GameException.class);
    }


    @Test
    public void testInitGameCounterLessThanPlayerCount(){
        Integer numberOfPlayers = 12;
        Integer counterLimit = 7;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        Assert.assertEquals(numberOfPlayers, game.getNumberOfPlayers());
        Assert.assertEquals(numberOfPlayers.intValue(), game.getPlayers().size());
        Assert.assertEquals(counterLimit, game.getCounterLimit());
    }

    @Test
    public void testInitGameCounterGreaterThanPlayerCount(){
        Integer numberOfPlayers = 12;
        Integer counterLimit = 16;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        Assert.assertEquals(numberOfPlayers, game.getNumberOfPlayers());
        Assert.assertEquals(numberOfPlayers.intValue(), game.getPlayers().size());
        Assert.assertEquals(counterLimit, game.getCounterLimit());
    }


    @Test
    public void testInitGameCounterEqualPlayerCount() {
        Integer numberOfPlayers = 12;
        Integer counterLimit = 12;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        thrown.expect(GameException.class);
    }


}
