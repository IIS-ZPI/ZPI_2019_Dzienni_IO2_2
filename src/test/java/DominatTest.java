import controller.measure.Dominat;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class DominatTest {

    @Test
    public void shouldReturnCorrectDominatValue() {
        //Given
        Dominat dominat = new Dominat();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate(4.3));
        rates.add(new Rate(4.9));
        Double expected = 4.3;
        Double actual = 0.0;

        //When
        dominat.countStatisticalMeasure(rates);
        actual=dominat.getDominate();
        //Then
        Assert.assertEquals(expected,actual);
    }

}
