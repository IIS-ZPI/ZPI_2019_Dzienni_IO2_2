
import controller.measure.Median;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MedianTest {

    @Test
    public void shouldReturnCorrectMedianValue() {
        //Given
        Median median = new Median();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate(4.3));
        rates.add(new Rate(4.9));
        Double expected = 4.6;
        Double actual = 0.0;

        //When
        median.countStatisticalMeasure(rates);
        actual=median.getMedian();

        //Then
        Assert.assertEquals(expected,actual);
    }

}
