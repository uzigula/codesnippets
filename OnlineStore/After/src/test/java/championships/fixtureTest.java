package championships;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class
fixtureTest {

    @Test
    public void CreateAFixture(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        Assert.assertNotNull(fixture);
        Assert.assertEquals("Copa Arboleda",fixture.getName());
    }

    @Test
    public void ShouldCreateaSingleFixture(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        fixture.generate(getListFrom("Nano,Fonsi"));
        assertBracket(fixture.Key(0),"Nano", "Fonsi");
        Assert.assertEquals(true, fixture.getIsEven());
    }

    @Test
    public void ShouldCreateaSingleFixtureWithTwoKeys(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        fixture.generate(getListFrom("Nano,Fonsi,Marco,Lupo"));

        assertBracket(fixture.Key(0),"Nano", "Fonsi");
        assertBracket(fixture.Key(1),"Marco", "Lupo");
        Assert.assertEquals(true, fixture.getIsEven());

    }
    @Test
    public void ShouldCreateaFixtureWithTwoKeysWithOneBye(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        fixture.generate(getListFrom("Nano*,Fonsi,Lupo"));

        assertBracket(fixture.Key(0),"Nano", "Bye");
        assertBracket(fixture.Key(1),"Fonsi", "Lupo");
        Assert.assertEquals(false, fixture.getIsEven());
        Assert.assertEquals(1, fixture.getByes());
    }

    @Test
    public void ShouldCreateaFixtureWithFourKeysWithTwoByes(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        fixture.generate(getListFrom("Nano*,Pepe*,Fonsi,Lupo,Marco,Jorge"));
        assertBracket(fixture.Key(0),"Nano", "Bye");
        assertBracket(fixture.Key(1),"Pepe", "Bye");
        assertBracket(fixture.Key(2),"Fonsi", "Lupo");
        assertBracket(fixture.Key(3),"Marco", "Jorge");

        Assert.assertEquals(false, fixture.getIsEven());
        Assert.assertEquals(2, fixture.getByes());
    }


    @Test
    public void ShouldCreateaFixtureWithFourKeysWithOneByeFixingErrorOfByes(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        fixture.generate(getListFrom("Nano*,Pepe*,Beto,Fonsi,Lupo,Marco,Jorge"));
        assertBracket(fixture.Key(0),"Nano", "Bye");
        assertBracket(fixture.Key(1),"Pepe", "Beto");
        assertBracket(fixture.Key(2),"Fonsi", "Lupo");
        assertBracket(fixture.Key(3),"Marco", "Jorge");

        Assert.assertEquals(false, fixture.getIsEven());
        Assert.assertEquals(1, fixture.getByes());
    }


    @Test
    public void ShouldCreateaFixtureWithFourKeysWithNoByeFixingErrorOfByes(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        fixture.generate(getListFrom("Nano*,Jechu*,Pepe*,Beto,Fonsi,Lupo,Marco,Jorge"));
        assertBracket(fixture.Key(0),"Nano", "Jechu");
        assertBracket(fixture.Key(1),"Pepe", "Beto");
        assertBracket(fixture.Key(2),"Fonsi", "Lupo");
        assertBracket(fixture.Key(3),"Marco", "Jorge");

        Assert.assertEquals(true, fixture.getIsEven());
        Assert.assertEquals(0, fixture.getByes());
    }


    @Test
    public void ShouldCreateaFixtureWithEightKeysWithSixByesFixingErrorOfByes(){
        Fixture fixture = Fixture.called("Copa Arboleda");
        fixture.generate(getListFrom("Nano*,Jechu*,Pepe*,Beto,Fonsi,Lupo,Marco,Jorge,Feña,Cachanov"));
        assertBracket(fixture.Key(0),"Nano", "Bye");
        assertBracket(fixture.Key(1),"Jechu", "Bye");
        assertBracket(fixture.Key(2),"Pepe", "Bye");
        assertBracket(fixture.Key(3),"Beto", "Bye");
        assertBracket(fixture.Key(4),"Fonsi", "Bye");
        assertBracket(fixture.Key(5),"Lupo", "Bye");
        assertBracket(fixture.Key(6),"Marco", "Jorge");
        assertBracket(fixture.Key(7),"Feña", "Cachanov");
        Assert.assertEquals(false, fixture.getIsEven());
        Assert.assertEquals(6, fixture.getByes());
    }





    private List<String> getListFrom(String players){

        String[] valor2 = players.split(",");
        ArrayList<String> value = new ArrayList<String>();

        for(int i=0; i< valor2.length; i++){ value.add(valor2[i]); }
        return value;
    }


    private void assertBracket(Bracket bracket, String expectedPlayer1, String expectedPlayer){
        Assert.assertEquals(expectedPlayer1,bracket.getPlayer1());
        Assert.assertEquals(expectedPlayer,bracket.getPlayer2());
    }
}
