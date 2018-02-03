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
    public void testInitGameWithValidInput() throws GameException {
        Integer numberOfPlayers = 12;
        Integer counterLimit = 15;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        Assert.assertEquals(numberOfPlayers, game.getNumberOfPlayers());
        Assert.assertEquals(numberOfPlayers.intValue(), game.getPlayers().size());
        Assert.assertEquals(counterLimit, game.getCounterLimit());
    }

    @Test(expected = GameException.class)
    public void testInitGameWithNegativePlayers() throws GameException {
        Integer numberOfPlayers = -12;
        Integer counterLimit = 15;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        thrown.expect(GameException.class);

    }

    @Test(expected = GameException.class)
    public void testInitGameWithOnePlayer() throws GameException {
        Integer numberOfPlayers = 1;
        Integer counterLimit = 15;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);


    }

    @Test(expected = GameException.class)
    public void testInitGameWithNegativeCounterLimit() throws GameException {
        Integer numberOfPlayers = 12;
        Integer counterLimit = -15;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);


    }


    @Test(expected = GameException.class)
    public void testInitGameWithNullValues() throws GameException {
        Integer numberOfPlayers = null;
        Integer counterLimit = null;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        thrown.expect(GameException.class);
    }


    /*
     * Test Counter Limit Input
     */

    @Test
    public void testInitGameCounterLessThanPlayerCount() throws GameException {
        Integer numberOfPlayers = 12;
        Integer counterLimit = 7;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        Assert.assertEquals(numberOfPlayers, game.getNumberOfPlayers());
        Assert.assertEquals(numberOfPlayers.intValue(), game.getPlayers().size());
        Assert.assertEquals(counterLimit, game.getCounterLimit());
    }

    @Test
    public void testInitGameCounterGreaterThanPlayerCount() throws GameException {
        Integer numberOfPlayers = 12;
        Integer counterLimit = 16;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        Assert.assertEquals(numberOfPlayers, game.getNumberOfPlayers());
        Assert.assertEquals(numberOfPlayers.intValue(), game.getPlayers().size());
        Assert.assertEquals(counterLimit, game.getCounterLimit());
    }


    @Test(expected = GameException.class)
    public void testInitGameCounterEqualPlayerCount() throws GameException {
        Integer numberOfPlayers = 12;
        Integer counterLimit = 12;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);
    }



}
