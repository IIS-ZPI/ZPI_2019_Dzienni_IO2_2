package controller.measure;

import model.Rate;

import java.util.ArrayList;
import java.util.List;

public class Dominat implements Measure {

    int dominat = 0;
    List <Double> dominateList;

    @Override
    public void countStatisticalMeasure(List<Rate> rate) {

        dominateList = new ArrayList<Double>();

        int maxCount = 0;

        for (int i = 0; i < rate.size(); ++i)
        {
            int count = 0;
            for (int j = 0; j < rate.size(); ++j)
            {
                if (rate.get(j).getMid() == rate.get(i).getMid())
                    ++count;
            }
            if (count >= maxCount)
            {
                maxCount = count;
                dominateList.add(rate.get(i).getMid());
            }
        }

    }

    public List<Double> getDominate() {
        return dominateList;
    }
}
