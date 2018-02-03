package au.com.afl.exercise.model;



import au.com.afl.exercise.exception.GameException;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {


    @Test
    public void testInitializePlayer(){
        Player player = new Player(1);

        Assert.assertEquals(1, player.getId().intValue());
    }

    @Test
    public void testPlayerCounts() throws GameException{
        Player player = new Player(1);
        Integer currentConunt = 5;
        currentConunt  = player.count(currentConunt).intValue();
        Assert.assertEquals(6,currentConunt.intValue() );
        currentConunt  = player.count(currentConunt).intValue();
        Assert.assertEquals(7, currentConunt.intValue());
        currentConunt  = player.count(currentConunt).intValue();
        Assert.assertEquals(8, currentConunt.intValue());
    }

    @Test(expected = GameException.class)
    public void testNullCounts() throws GameException{
        Player player = new Player(1);
        Integer currentConunt = null;
        player.count(currentConunt);
    }
}
