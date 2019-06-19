import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CurrancyCalendarTest {

    CurrencyCalendar currencyCalendar = new CurrencyCalendar();


    @Test
    public void shouldReturnSevenDayDifferance() throws Exception
    {
        //Given
        int option = 1;
        int expected = 7;
        int actual = 0;

        //When
        currencyCalendar.setDateRange(option);
        actual = (int)( (currencyCalendar.getEndDate().getTime() - currencyCalendar.getStartDate().getTime()) / (1000 * 60 * 60 * 24));

        //Then
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void shouldReturnFourteenDayDifferance() throws Exception
    {
        //Given
        int option = 2;
        int expected = 14;
        int actual = 0;

        //When
        currencyCalendar.setDateRange(option);
        actual = (int)( (currencyCalendar.getEndDate().getTime() - currencyCalendar.getStartDate().getTime()) / (1000 * 60 * 60 * 24));

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnOneMonthDifferance() throws Exception
    {
        //Given
        int sevenDayOption = 3;
        int expected = 31;
        int actual = 0;

        //When
        currencyCalendar.setDateRange(sevenDayOption);
        actual = (int)( (currencyCalendar.getEndDate().getTime() - currencyCalendar.getStartDate().getTime()) / (1000 * 60 * 60 * 24));

        //Then
        Assert.assertEquals(expected,actual);
    }


}
