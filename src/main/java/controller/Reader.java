package controller;

import model.*;

import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    Scanner scanner = new Scanner(System.in);
    boolean correctOption =  false;
    int rangeSelected = 0;
    private CurrencyList currencyList;

    protected CurrencyHistory printOptionsAndRead() throws Exception {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        CurrencyCalendar cC = new CurrencyCalendar();

        System.out.println("Enter session date range:");
        System.out.println("1 - week");
        System.out.println("2 - 2 weeks");
        System.out.println("3 - month");
        System.out.println("4 - 3 months (quarter)");
        System.out.println("5 - 6 months");
        System.out.println("6 - year");
        System.out.print("> ");

        // wczytywanie opcji
        while(!correctOption){
            try {
                rangeSelected = scanner.nextInt();
            }catch (InputMismatchException e){
                //System.out.println("Wrong choice. Try again!");
                scanner.next();
            }
            if(rangeSelected >0 && rangeSelected < 7)
                correctOption = true;
            else
                System.out.println("Wrong choice. Try again!");
        }
        cC.setDateRange(rangeSelected);

        // pobieranie walut z NBP
        CurrancyController currancyController1 = new CurrancyController("gbp", "2019-01-01", "2019-01-08");
        currencyList = currancyController1.getCurrencyList();

        System.out.println("\nAvailable value codes: ");
        for(Table t: currencyList.getTableRates()){
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

        for(Rate r: currencyHistory.getRates()){
            System.out.println(r.getEffectiveDate() + "\t" + r.getMid());
        }
        return currencyHistory;
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
