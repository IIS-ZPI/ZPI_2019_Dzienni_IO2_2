import controller.measure.Dominat;
import controller.measure.StandardDeviation;
import model.Rate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;




public class StandardDeviationTest {

    StandardDeviation standardDeviation;
    List<Rate> rates;


    @Before
    public void setUp() {
        standardDeviation=new StandardDeviation();
        rates=new ArrayList<>();
        rates.add(new Rate(4.3));
        rates.add(new Rate(4.9));

    }


    @Test
    public void shouldReturnCorrectStandardDeviationValue() {
        //Given
        Double expected = 0.3;
        Double actual = 0.0;

        //When
        standardDeviation.countStatisticalMeasure(rates);
        actual = standardDeviation.getStandardDeviation();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectMeanValue() {
        //Given
        Double expected = 4.6;
        Double actual = 0.0;

        //When
        standardDeviation.countStatisticalMeasure(rates);
        actual = standardDeviation.getMean();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
