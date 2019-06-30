import controller.session.DownwardSession;
import controller.session.GrowthSession;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GrowthSessionTest {

    @Test
    public void shouldReturnCorrectGrowthSessionValue() {
        //Given
        GrowthSession growthSession = new GrowthSession();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate(4.3));
        rates.add(new Rate(4.9));
        Integer expected = 0;
        Integer actual = 0;

        //When
        growthSession.countSession(rates);
        actual=growthSession.getGrowthSessionCounter();
        //Then
        Assert.assertEquals(expected,actual);
    }

}
