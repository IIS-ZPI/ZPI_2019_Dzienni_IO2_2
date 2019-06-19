import controller.CurrancyController;
import model.CurrencyHistory;
import org.junit.Assert;
import org.junit.Test;


public class CurrancyControllerTest {

    @Test
    public void shouldReturnCurrancyHistoryObject() throws Exception {

        //Given
        String currency = "GBP";
        String startDate = "2019-06-05";
        String finishDate = "2019-06-06";
        CurrancyController currancyController = new CurrancyController(currency,startDate,finishDate);
        CurrencyHistory currencyHistory = null;

        //When
        currencyHistory = currancyController.getHistory();

        //Then
        Assert.assertNotNull(currency);
    }
}