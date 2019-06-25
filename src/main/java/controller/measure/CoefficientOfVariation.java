package controller.measure;

import model.Rate;

import java.util.List;

public class CoefficientOfVariation implements Measure {

    double coefficientOfVariation = 0;

    @Override
    public void countStatisticalMeasure(List<Rate> rate) {
    }

    public void countStatisticalMeasure(double standardDeviation, double mean) {

        coefficientOfVariation = standardDeviation/mean*100;
    }


    public double getCoefficientOfVariation() {
        return coefficientOfVariation;
    }



}
