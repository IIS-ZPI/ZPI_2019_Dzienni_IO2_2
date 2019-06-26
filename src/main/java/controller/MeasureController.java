package controller;

import controller.measure.*;
import model.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MeasureController {

    private Scanner scanner = new Scanner(System.in);
    private CurrencyList currencyList;

    public void countMeasure() throws Exception {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

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
        currencyList = currancyController1.getCurrencyList();

        System.out.println("\nAvailable value codes: ");
        for (Table t : currencyList.getTableRates()) {
            System.out.print(t.getCode() + " ");
        }

        String code = readCode();

        // format daty
        String startDateFormat = sdf.format(cC.getStartDate());
        String endDateFormat = sdf.format(cC.getEndDate());
        System.out.println(startDateFormat + " - " + endDateFormat);

        // pobieranie dat i wartości waluty z NBP
        CurrancyController currancyController = new CurrancyController(code, startDateFormat, endDateFormat);
        CurrencyHistory currencyHistory = currancyController.getHistory();
        System.out.println(currencyHistory.getCurrency());

        for (Rate r : currencyHistory.getRates()) {
            System.out.println(r.getEffectiveDate() + "\t" + r.getMid());
        }

        CoefficientOfVariation coefficientOfVariation = new CoefficientOfVariation();
        Dominat dominat = new Dominat();
        Median median = new Median();
        StandardDeviation standardDeviaton = new StandardDeviation();

        dominat.countStatisticalMeasure(currencyHistory.getRates());
        median.countStatisticalMeasure(currencyHistory.getRates());
        standardDeviaton.countStatisticalMeasure(currencyHistory.getRates());
        coefficientOfVariation.countStatisticalMeasure(standardDeviaton.getStandardDeviation(), standardDeviaton.getMean());

        System.out.println("CoefficientOfVariation: " + coefficientOfVariation.getCoefficientOfVariation() + "%");
        System.out.println("Dominat: " + dominat.getDominate());
        System.out.println("Median: " + median.getMedian());
        System.out.println("StandardDeviation: " + standardDeviaton.getStandardDeviation());

//        GrowthSession growthSession = new GrowthSession();
//        StaticSession staticSession = new StaticSession();
//        DownwardSession downwardSession = new DownwardSession();
//
//        growthSession.countSession(currencyHistory.getRates());
//        staticSession.countSession(currencyHistory.getRates());
//        downwardSession.countSession(currencyHistory.getRates());

//        System.out.println("Liczba sesji wzrostowych: " + growthSession.getGrowthSessionCounter());
//        System.out.println("Liczba sesji stałych: " + staticSession.getStaticSessionCounter());
//        System.out.println("Liczba sesji spadkowych: " + downwardSession.getDownwardSessionCounter());
    }


    private String readCode(){
        String input = null;
        System.out.print("\nEnter value code: ");
        input = scanner.next();
        System.out.println(input);


        while(!containKey(input.toUpperCase())){
            System.out.print("Incorrect currency. Try again\nEnter value code: ");
            input = scanner.next();
        }
        return input;
    }


    private boolean containKey(String key){
        for(Table t : currencyList.getTableRates()){
            if(key.equals(t.getCode())){
                return true;
            }
        }
        return false;
    }


}
