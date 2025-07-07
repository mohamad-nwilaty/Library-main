import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class InputHelper {
    
    public static Scanner input = new Scanner(System.in);

    public static String getString(String propmt){
        System.out.print(propmt);
        return input.nextLine();
    }

    public static int getInt(String prompt){

        while (true) {
            System.out.print(prompt);
            try{
                return Integer.parseInt(input.nextLine());
            }    
            catch(NumberFormatException e){
                System.out.println("please enter a number!");
            }
        }
    }

    public static LocalDate getDate(String prompt){
        System.out.print(prompt + " (yyyy-mm-dd): ");
        while (true) {
            try{
                return LocalDate.parse(input.nextLine());
            }
            catch(DateTimeParseException e){
                System.out.println("please enter a valid date as (yyyy-mm-dd)");
            }
        }
    }
    public static String getProjectYear(String propmt){
        System.out.print(propmt);
        while (true) {
            String year = input.nextLine();
            year = year.toLowerCase();
            if(year.equals("third") || year.equals("fourth") || year.equals("final")){
                return year;
            }else{
                System.out.println("please enter third - fourth or final");
            }
        }
    }

    public static String getSpecialisation(String propmt){
        System.out.print(propmt);
        while (true) {
            String year = input.nextLine();
            year = year.toLowerCase();
            if(year.equals("ai") || year.equals("networks") || year.equals("basic-science")  || year.equals("programing")){
                return year;
            }else{
                System.out.println("please enter ai , networks , basic-science or programing");
            }
        }
    }

}
