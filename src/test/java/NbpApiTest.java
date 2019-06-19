import controller.CurrancyController;
import controller.DownwardSession;
import controller.GrowthSession;
import controller.StaticSession;
import endpoint.NbpEndpoint;
import model.CurrencyHistory;
import org.junit.Assert;
import org.junit.Test;


public class NbpApiTest {

    @Test
    public void shouldReturnSameJson() throws Exception {

        //Given
        String result = "";
        String currency = "gbp";
        String startDate = "2019-06-05";
        String finishDate = "2019-06-06";
        String expectedJson = "{\"table\":\"A\",\"currency\":\"funt szterling\",\"code\":\"GBP\",\"rates\":[{\"no\":\"108/A/NBP/2019\",\"effectiveDate\":\"2019-06-05\",\"mid\":4.8221},{\"no\":\"109/A/NBP/2019\",\"effectiveDate\":\"2019-06-06\",\"mid\":4.8274}]}";
        NbpEndpoint nbpEndpoint = new NbpEndpoint();

        //When
        result = nbpEndpoint.sendRequest(currency, startDate, finishDate);
        //Then
        Assert.assertEquals(expectedJson, result);
    }

    @Test
    public void shouldReturnCountOfDownwardSessions() throws Exception {
        //Given
        int result = 0;
        String currency = "gbp";
        String startDate = "2019-01-01";
        String finishDate = "2019-01-04";
        int expectedCount = 1;

        CurrancyController currancyController = new CurrancyController(currency, startDate, finishDate);
        CurrencyHistory currencyHistory = currancyController.getHistory();
        DownwardSession downwardSession = new DownwardSession();

        //When
        downwardSession.countSession(currencyHistory.getRates());
        result = downwardSession.getDownwardSessionCounter();
        //Then
        Assert.assertEquals(expectedCount, result);
    }

    @Test
    public void shouldReturnCountOfStaticSessions() throws Exception {
        //Given
        int result = 0;
        String currency = "gbp";
        String startDate = "2019-01-01";
        String finishDate = "2019-01-04";
        int expectedCount = 0;

        CurrancyController currancyController = new CurrancyController(currency, startDate, finishDate);
        CurrencyHistory currencyHistory = currancyController.getHistory();
        StaticSession staticSession = new StaticSession();

        //When
        staticSession.countSession(currencyHistory.getRates());
        result = staticSession.getStaticSessionCounter();
        //Then
        Assert.assertEquals(expectedCount, result);
    }


}
