package controller.session;

import model.Rate;

import java.util.List;

public class StaticSession implements Session {

    int staticSessionCounter = 0;

    @Override
    public void countSession(List<Rate> rate) {

        for (int i = 0; i < rate.size() - 2; i++) {
            if (rate.get(i).getMid() == rate.get(i + 1).getMid())
                staticSessionCounter++;
        }
    }

    public int getStaticSessionCounter() {
        return staticSessionCounter;
    }
}
