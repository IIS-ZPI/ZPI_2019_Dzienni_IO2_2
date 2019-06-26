import controller.measure.CoefficientOfVariation;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CoefficientOfVariationTest {


    @Test
    public void shouldReturnCoefficientOfVariation() throws Exception
    {
        CoefficientOfVariation coefficientOfVariation = new CoefficientOfVariation();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate("118/A/NBP/2019", "2019-06-21", 2.12));
        rates.add(new Rate("119/A/NBP/2019", "2019-06-22", 2.04));
        rates.add(new Rate("120/A/NBP/2019", "2019-06-23", 2.21));
        rates.add(new Rate("121/A/NBP/2019", "2019-06-24", 2.26));
        rates.add(new Rate("122/A/NBP/2019", "2019-06-25", 2.12));

        // Given
        double expected = 3.72;
        double actual;

        // When
        coefficientOfVariation.countStatisticalMeasure(rates);
        actual = coefficientOfVariation.getCoefficientOfVariation();

        // Then
        Assert.assertEquals(expected,actual,0.001);
    }
}
