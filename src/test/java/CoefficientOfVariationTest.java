import controller.measure.CoefficientOfVariation;
import controller.measure.Dominat;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CoefficientOfVariationTest {

    @Test
    public void shouldReturnCoefficientOfVariationValue() {
        //Given
        CoefficientOfVariation coefficientOfVariation = new CoefficientOfVariation();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate(4.3));
        rates.add(new Rate(4.9));
        Double expected = 0.0;
        Double actual = 0.0;

        //When
        coefficientOfVariation.countStatisticalMeasure(rates);
        actual = coefficientOfVariation.getCoefficientOfVariation();
        //Then
        Assert.assertEquals(expected, actual);
    }

}
