package controller;

import model.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DistributionOfChangesController {

    private Scanner scanner = new Scanner(System.in);
    private CurrencyList currencyList;

    public void countDistribution() throws Exception {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        CurrencyCalendar cC = new CurrencyCalendar();

        CurrancyController currancyController1 = new CurrancyController("gbp", "2019-01-01", "2019-01-08");
        currencyList = currancyController1.getCurrencyList();

        System.out.println("\nAvailable value codes: ");
        for (Table t : currencyList.getTableRates()) {
            System.out.print(t.getCode() + " ");
        }

        String codeFirst = readCode();
        String codeSecond = readCode();

        // format daty
        CurrencyCalendar cC1 = new CurrencyCalendar();
        cC1.setDateRange(3);
        String startDateFormat = sdf.format(cC1.getStartDate());
        String endDateFormat = sdf.format(cC1.getEndDate());

        CurrencyCalendar cC2 = new CurrencyCalendar();
        cC2.setDateRange(4);
        String startDateFormat2 = sdf.format(cC2.getStartDate());
        String endDateFormat2 = sdf.format(cC2.getEndDate());

        System.out.println("Month: " + startDateFormat + " - " + endDateFormat);
        System.out.println("Quarter:" + startDateFormat2 + " - " + endDateFormat2);


        // pobieranie dat i wartości waluty z NBP dla miesiaca dla waluty 1
        CurrancyController currancyControllerFirst = new CurrancyController(codeFirst, startDateFormat, endDateFormat);
        CurrencyHistory currencyHistoryFirst = currancyControllerFirst.getHistory();
        //  System.out.println(currencyHistoryFirst.getCurrency());


        // pobieranie dat i wartości waluty z NBP dla miesiaca dla waluty 2
        CurrancyController currancyControllerSecond = new CurrancyController(codeSecond, startDateFormat, endDateFormat);
        CurrencyHistory currencyHistorySecond = currancyControllerSecond.getHistory();
        //System.out.println(currencyHistorySecond.getCurrency());


        countSubstaction("miesięczny", currencyHistoryFirst, currencyHistorySecond);


        // pobieranie dat i wartości waluty z NBP dla kwartał dla waluty 1
        CurrancyController currancyControllerFirstQuarter = new CurrancyController(codeFirst, startDateFormat2, endDateFormat2);
        CurrencyHistory currencyHistoryFirstQuarter = currancyControllerFirstQuarter.getHistory();
        System.out.println();


        // pobieranie dat i wartości waluty z NBP dla kwartał dla waluty 2
        CurrancyController currancyControllerSecondQuarter = new CurrancyController(codeSecond, startDateFormat2, endDateFormat2);
        CurrencyHistory currencyHistorySecondQuarter = currancyControllerSecondQuarter.getHistory();
        // System.out.println(currencyHistorySecondQuarter.getCurrency());


        countSubstaction("kwartalny", currencyHistoryFirstQuarter, currencyHistorySecondQuarter);

    }

    public void countSubstaction(String option, CurrencyHistory currancyControllerFirst, CurrencyHistory currencyHistorySecond) {

        System.out.println("Rozkład " + option + ":");
        System.out.println("USD         -           EUR");

        for (int i = 1; i < currencyHistorySecond.getRates().size(); i++) {

            double first = currancyControllerFirst.getRates().get(i - 1).getMid() - currancyControllerFirst.getRates().get(i).getMid();
            double second = currencyHistorySecond.getRates().get(i - 1).getMid() - currencyHistorySecond.getRates().get(i).getMid();

            DecimalFormat df = new DecimalFormat("#.##");
            String midFirstString = df.format(first);
            midFirstString = midFirstString.replace(",", ".");

            if (midFirstString.equals("-0") || midFirstString.equals("0"))
                midFirstString = "0.00";
            if (!midFirstString.contains("-"))
                midFirstString = " " + midFirstString;

            df = new DecimalFormat("#.##");
            String midSecondString = df.format(second);
            midSecondString = midSecondString.replace(",", ".");
            if (midSecondString.equals("-0") || midSecondString.equals("0"))

                midSecondString = "0.00";
            if (!midSecondString.contains("-"))
                midSecondString = " " + midSecondString;

            System.out.println(i + ": " + midFirstString + "            " + midSecondString);
        }
    }

    private String readCode() {
        String input = null;
        System.out.print("\nEnter value code: ");
        input = scanner.next();
        System.out.println(input);


        while (!containKey(input.toUpperCase())) {
            System.out.print("Incorrect currency. Try again\nEnter value code: ");
            input = scanner.next();
        }
        return input;
    }


    private boolean containKey(String key) {
        for (Table t : currencyList.getTableRates()) {
            if (key.equals(t.getCode())) {
                return true;
            }
        }
        return false;
    }
}
