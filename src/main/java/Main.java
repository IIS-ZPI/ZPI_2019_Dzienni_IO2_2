import controller.*;
import model.CurrencyHistory;
import model.CurrencyList;
import model.Rate;
import model.Table;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int selectedOption;
        boolean program = true;

        selectedOption = getOption();

        while (program) {
            switch (selectedOption) {
                case 1:
                    SessionController sessionController = new SessionController();
                    sessionController.countSession();
                    System.out.println("----------------------------------------");
                    selectedOption = getOption();
                    break;
                case 2:
                    MeasureController measureController = new MeasureController();
                    measureController.countMeasure();
                    //....
                    System.out.println("----------------------------------------");
                    selectedOption = getOption();
                    break;
                case 3:
                    //...
                    System.out.println("----------------------------------------");
                    selectedOption = getOption();
                    break;
                case 4:
                    System.out.println("Close program...");
                    System.out.println("Program closed. Thanks for using and see again in future.");
                    program = false;
                    break;
                default:
                    System.out.println("Cannot get any information for this choice");
                    System.out.println("----------------------------------------");
                    selectedOption = getOption();
                    break;
            }
        }
    }

    public static int getOption() {

        boolean correctChoose = false;
        int selectedOption = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select which information do you want get.");
        System.out.println("1 - Count sessions for period of time which you can choose.");
        System.out.println("2 - Statistical measures for period of time which you can choose.");
        System.out.println("3 - Distribution of monthly and quarterly changes for selected currency pairs.");
        System.out.println("4 - Close program");

        while (!correctChoose) {
            try {
                selectedOption = scanner.nextInt();
                correctChoose = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value! Please choose correct option");
                scanner.next();
            }
        }

        return selectedOption;
    }

}
