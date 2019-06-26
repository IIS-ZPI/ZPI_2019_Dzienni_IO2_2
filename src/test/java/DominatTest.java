import controller.measure.Dominat;
import org.junit.Assert;
import org.junit.Test;

public class DominatTest {



    @Test
    public void shouldReturnDominat() throws Exception
    {
        Dominat dominat = new Dominat();
        //Given
        int option = 1;
        int expected = 7;
        int actual = 0;

        //When


        //Then
        Assert.assertEquals(expected,actual);
    }
}
