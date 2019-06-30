package controller;

import controller.measure.*;
import model.*;


public class MeasureController extends Reader{


    public void countMeasure() throws Exception {

        CurrencyHistory currencyHistory = printOptionsAndRead();

        CoefficientOfVariation coefficientOfVariation = new CoefficientOfVariation();
        Dominat dominat = new Dominat();
        Median median = new Median();
        StandardDeviation standardDeviaton = new StandardDeviation();

        dominat.countStatisticalMeasure(currencyHistory.getRates());
        median.countStatisticalMeasure(currencyHistory.getRates());
        standardDeviaton.countStatisticalMeasure(currencyHistory.getRates());
        coefficientOfVariation.countStatisticalMeasure(standardDeviaton.getStandardDeviation(), standardDeviaton.getMean());

        System.out.println("CoefficientOfVariation: " + coefficientOfVariation.getCoefficientOfVariation() + "%");
        System.out.println("Dominat: " + dominat.getDominate());
        System.out.println("Median: " + median.getMedian());
        System.out.println("StandardDeviation: " + standardDeviaton.getStandardDeviation());

    }





}
