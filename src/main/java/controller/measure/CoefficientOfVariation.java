package controller.measure;

import model.Rate;

import java.text.DecimalFormat;
import java.util.List;

public class CoefficientOfVariation implements Measure {

    double coefficientOfVariation = 0;

    @Override
    public void countStatisticalMeasure(List<Rate> rate) {
    }

    public void countStatisticalMeasure(double standardDeviation, double mean) {

        coefficientOfVariation = standardDeviation/mean*100;
        DecimalFormat df = new DecimalFormat("#.####");
        String midString = df.format(coefficientOfVariation);
        midString  = midString.replace(",", ".");
        coefficientOfVariation = Double.parseDouble(midString);
    }


    public double getCoefficientOfVariation() {
        return coefficientOfVariation;
    }



}
