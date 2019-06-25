package controller.measure;

import model.Rate;

import java.util.*;
import java.util.function.BinaryOperator;

public class Dominat implements Measure {

    int dominat = 0;
    double dominate;

    @Override
    public void countStatisticalMeasure(List<Rate> rate) {

        List<Double> theList = new ArrayList<>();
        for (int i = 0; i < rate.size(); i++)
            theList.add(rate.get(i).getMid());

        dominate = theList.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(o -> Collections.frequency(theList, o)))).orElse(null);
    }

    public double getDominate() {
        return dominate;
    }
}
