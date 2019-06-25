package controller.measure;

import model.Rate;

import java.util.List;

public interface Measure {

    void countStatisticalMeasure(List<Rate> rate);
}
