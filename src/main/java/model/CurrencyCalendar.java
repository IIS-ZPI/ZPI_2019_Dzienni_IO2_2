package model;

import java.util.Calendar;
import java.util.Date;

public class CurrencyCalendar
{
    private Date startDate;
    private Date endDate;

    public CurrencyCalendar()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        endDate = calendar.getTime();
    }

    // 1 - tydzień, 2 - 2 tygodnie, 3 - miesiąc, 4 - kwartał, 5 - pół roku, 6 - rok
    public void setDateRange(int option)
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        endDate = calendar.getTime();

        switch (option)
        {
            case 1:
                calendar.add(Calendar.DATE,  -7);
                startDate = calendar.getTime();
                break;
            case 2:
                calendar.add(Calendar.DATE,  -14);
                startDate = calendar.getTime();
                break;
            case 3:
                calendar.add(Calendar.MONTH,  -1);
                startDate = calendar.getTime();
                break;
            case 4:
                calendar.add(Calendar.MONTH,  -3);
                startDate = calendar.getTime();
                break;
            case 5:
                calendar.add(Calendar.MONTH,  -6);
                startDate = calendar.getTime();
                break;
            case 6:
                calendar.add(Calendar.YEAR,  -1);
                startDate = calendar.getTime();
                break;
            default:
                throw new IllegalArgumentException("Wrong date range option provided");
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}