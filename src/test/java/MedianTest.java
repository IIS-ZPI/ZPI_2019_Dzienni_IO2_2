import controller.measure.Median;
import org.junit.Assert;
import org.junit.Test;

public class MedianTest {


    @Test
    public void shouldReturnMedian() throws Exception
    {
        Median median = new Median();
        //Given
        int option = 1;
        int expected = 7;
        int actual = 0;

        //When


        //Then
        Assert.assertEquals(expected,actual);
    }
}
