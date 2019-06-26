package controller.measure;

import model.Rate;

import java.text.DecimalFormat;
import java.util.List;

public class CoefficientOfVariation implements Measure {

    double coefficientOfVariation = 0;

    @Override
    public void countStatisticalMeasure(List<Rate> rate) {
        StandardDeviation standardDeviation = new StandardDeviation();
        standardDeviation.countStatisticalMeasure(rate);
        double stdev = standardDeviation.getStandardDeviation();
        double mean = standardDeviation.getMean();
        coefficientOfVariation = stdev/mean*100;

        DecimalFormat df = new DecimalFormat("#.##");
        String midString = df.format(coefficientOfVariation);
        midString  = midString.replace(",", ".");
        coefficientOfVariation = Double.parseDouble(midString);
    }

    public void countStatisticalMeasure(double standardDeviation, double mean) {

        coefficientOfVariation = standardDeviation/mean*100;
        DecimalFormat df = new DecimalFormat("#.##");
        String midString = df.format(coefficientOfVariation);
        midString  = midString.replace(",", ".");
        coefficientOfVariation = Double.parseDouble(midString);
    }


    public double getCoefficientOfVariation() {
        return coefficientOfVariation;
    }



}
