import endpoint.NbpEndpoint;
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
}
