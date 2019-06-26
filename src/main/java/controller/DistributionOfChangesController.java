package controller;

import controller.measure.CoefficientOfVariation;
import controller.measure.Dominat;
import controller.measure.Median;
import controller.measure.StandardDeviation;
import model.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DistributionOfChangesController {

    public void countDistribution() throws Exception {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        Scanner scanner = new Scanner(System.in);

        CurrencyCalendar cC = new CurrencyCalendar();

        System.out.print("\nEnter first value code: ");
        String codeFirst = scanner.next();
        System.out.print("\nEnter second value code: ");
        String codeSecond = scanner.next();

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


//
//        CoefficientOfVariation coefficientOfVariation = new CoefficientOfVariation();
//        Dominat dominat = new Dominat();
//        Median median = new Median();
//        StandardDeviation standardDeviaton = new StandardDeviation();
//
//        dominat.countStatisticalMeasure(currencyHistory.getRates());
//        median.countStatisticalMeasure(currencyHistory.getRates());
//        standardDeviaton.countStatisticalMeasure(currencyHistory.getRates());
//        coefficientOfVariation.countStatisticalMeasure(standardDeviaton.getStandardDeviation(), standardDeviaton.getMean());
//
//        System.out.println("CoefficientOfVariation: " + coefficientOfVariation.getCoefficientOfVariation() + "%");
//        System.out.println("Dominat: " + dominat.getDominate());
//        System.out.println("Median: " + median.getMedian());
//        System.out.println("StandardDeviation: " + standardDeviaton.getStandardDeviation());
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

    public void countQuarterSubstaction(CurrencyHistory currancyControllerFirst, CurrencyHistory currencyHistorySecond) {

    }
}
