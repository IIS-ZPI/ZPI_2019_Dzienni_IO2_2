package controller;

import controller.session.DownwardSession;
import controller.session.GrowthSession;
import controller.session.StaticSession;
import model.CurrencyCalendar;
import model.CurrencyHistory;
import model.CurrencyList;
import model.Rate;
import model.Table;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SessionController {

    public void countSession() throws Exception {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        Scanner scanner = new Scanner(System.in);

        CurrencyCalendar cC = new CurrencyCalendar();

        System.out.println("Enter session date range:");
        System.out.println("1 - week");
        System.out.println("2 - 2 weeks");
        System.out.println("3 - month");
        System.out.println("4 - 4 months");
        System.out.println("5 - 6 months");
        System.out.println("6 - year");
        System.out.print("> ");

        // wczytywanie opcji
        int rangeSelected = scanner.nextInt();
        cC.setDateRange(rangeSelected);

        // pobieranie walut z NBP
        CurrancyController currancyController1 = new CurrancyController("gbp", "2019-01-01", "2019-01-08");
        CurrencyList currencyList = currancyController1.getCurrencyList();

        System.out.println("\nAvailable value codes: ");
        for(Table t: currencyList.getTableRates()){
            System.out.print(t.getCode() + " ");
        }

        System.out.print("\nEnter value code: ");
        String code = scanner.next();

        // format daty
        String startDateFormat = sdf.format(cC.getStartDate());
        String endDateFormat = sdf.format(cC.getEndDate());
        System.out.println(startDateFormat + " - " + endDateFormat);

        // pobieranie dat i wartości waluty z NBP
        CurrancyController currancyController = new CurrancyController(code, startDateFormat, endDateFormat);
        CurrencyHistory currencyHistory = currancyController.getHistory();
        System.out.println(currencyHistory.getCurrency());

        for(Rate r: currencyHistory.getRates()){
            System.out.println(r.getEffectiveDate() + "\t" + r.getMid());
        }

        GrowthSession growthSession = new GrowthSession();
        StaticSession staticSession = new StaticSession();
        DownwardSession downwardSession = new DownwardSession();

        growthSession.countSession(currencyHistory.getRates());
        staticSession.countSession(currencyHistory.getRates());
        downwardSession.countSession(currencyHistory.getRates());

        System.out.println("Liczba sesji wzrostowych: " + growthSession.getGrowthSessionCounter());
        System.out.println("Liczba sesji stałych: " + staticSession.getStaticSessionCounter());
        System.out.println("Liczba sesji spadkowych: " + downwardSession.getDownwardSessionCounter());
    }
}
