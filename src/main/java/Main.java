import controller.CurrancyController;
import controller.DownwardSession;
import controller.GrowthSession;
import controller.StaticSession;
import model.CurrencyHistory;
import model.Rate;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Dziala");

        Scanner scanner = new Scanner(System.in);

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        CurrencyCalendar cC = new CurrencyCalendar();

        System.out.println("Provide session date range:");
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

        // format daty
        String startDateFormat = sdf.format(cC.getStartDate());
        String endDateFormat = sdf.format(cC.getEndDate());
        System.out.println(startDateFormat + " - " + endDateFormat);

        // pobieranie dat i wartości waluty z NBP
        CurrancyController currancyController = new CurrancyController("gbp", startDateFormat, endDateFormat);
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
