package au.com.afl.exercise;


import au.com.afl.exercise.exception.GameException;
import au.com.afl.exercise.service.Game;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {


    @Test
    public void testPlayWith2Players() throws GameException {
        Integer numberOfPlayers = 2;
        Integer counterLimit = 1;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        game.play();

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals(1, game.getPlayers().size());

        Assert.assertEquals(2, game.getPlayers().get(0).getId().intValue());
    }

    @Test
    public void testPlayWith3Players() throws GameException {
        Integer numberOfPlayers = 3;
        Integer counterLimit = 2;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        game.play();

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals(1, game.getPlayers().size());
        Assert.assertEquals(3, game.getPlayers().get(0).getId().intValue());

    }

    @Test
    public void testPlayWithCounterGreaterThanPlayers() throws GameException {
        Integer numberOfPlayers = 3;
        Integer counterLimit = 5;

        Game game = new Game();
        game.init(numberOfPlayers, counterLimit);

        game.play();

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals(1, game.getPlayers().size());
        Assert.assertEquals(1, game.getPlayers().get(0).getId().intValue());

    }

}
