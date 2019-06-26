import controller.measure.Median;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MedianTest {


    @Test
    public void shouldReturnMedian() throws Exception
    {
        Median median = new Median();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate("118/A/NBP/2019", "2019-06-21", 2.1));
        rates.add(new Rate("119/A/NBP/2019", "2019-06-22", 4.0));
        rates.add(new Rate("120/A/NBP/2019", "2019-06-23", 3.0));
        rates.add(new Rate("121/A/NBP/2019", "2019-06-24", 1.0));
        rates.add(new Rate("122/A/NBP/2019", "2019-06-25", 1.5));

        // Given
        double expected = 2.1;
        double actual;

        // When
        median.countStatisticalMeasure(rates);
        actual = median.getMedian();

        // Then
        Assert.assertEquals(expected,actual,0.001);
    }
}
