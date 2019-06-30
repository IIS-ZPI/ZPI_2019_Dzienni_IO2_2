import controller.session.DownwardSession;
import controller.session.GrowthSession;
import controller.session.StaticSession;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class StaticSessionTest {

    @Test
    public void shouldReturnCorrectGrowthSessionValue() {
        //Given
        StaticSession staticSession = new StaticSession();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate(4.3));
        rates.add(new Rate(4.9));
        Integer expected = 0;
        Integer actual = 0;

        //When
        staticSession.countSession(rates);
        actual=staticSession.getStaticSessionCounter();
        //        //Then
        Assert.assertEquals(expected,actual);
    }

}
