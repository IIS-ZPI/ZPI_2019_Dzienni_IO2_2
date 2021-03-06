package controller.measure;

import model.Rate;

import java.text.DecimalFormat;
import java.util.List;

public class StandardDeviation implements Measure {

    double standardDeviation = 0;
    double mean = 0.0;

    @Override
    public void countStatisticalMeasure(List<Rate> rate) {

        getMean(rate);
        double temp = 0;
        for (Rate a : rate)
            temp += (a.getMid() - mean) * (a.getMid() - mean);
        standardDeviation = Math.sqrt(temp / rate.size());

        DecimalFormat df = new DecimalFormat("#.####");
        String midString = df.format(standardDeviation);
        midString = midString.replace(",", ".");
        standardDeviation = Double.parseDouble(midString);
    }

    void getMean(List<Rate> rate) {
        for (Rate a : rate)
            mean += a.getMid();
        mean = mean / rate.size();
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public double getMean() {
        return mean;
    }
}
