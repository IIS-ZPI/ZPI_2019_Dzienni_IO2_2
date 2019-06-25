package controller.measure;

import model.Rate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Median implements Measure {

    double median = 0;

    @Override
    public void countStatisticalMeasure(List<Rate> rate) {
        Collections.sort(rate);

        for (int i = 0; i < rate.size(); i++)
            System.out.println(rate.get(i).getMid());

        if (rate.size() % 2 == 1) {
            median = rate.get(rate.size() / 2).getMid();
        } else {
            median = (rate.get(rate.size() / 2 - 1).getMid() + rate.get(rate.size() / 2).getMid()) / 2;
        }
    }

    public double getMedian() {
        return median;
    }
}
