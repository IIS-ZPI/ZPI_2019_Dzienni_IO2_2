import controller.measure.Dominat;
import controller.session.DownwardSession;
import model.Rate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class DownwardSessionTest {

    @Test
    public void shouldReturnCorrectDownwardSessionValue() {
        //Given
        DownwardSession downwardSession = new DownwardSession();
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate(4.3));
        rates.add(new Rate(4.9));
        Integer expected = 1;
        Integer actual = 0;

        //When
        downwardSession.countSession(rates);
        actual=downwardSession.getDownwardSessionCounter();
        //Then
        Assert.assertEquals(expected,actual);
    }

}
