import controller.measure.StandardDeviation;
import org.junit.Assert;
import org.junit.Test;

public class StandardDeviationTest {


    @Test
    public void shouldReturnStandardDeviation() throws Exception
    {
        StandardDeviation standardDeviation = new StandardDeviation();
        //Given
        int option = 1;
        int expected = 7;
        int actual = 0;

        //When


        //Then
        Assert.assertEquals(expected,actual);
    }
}
