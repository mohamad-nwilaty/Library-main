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
            String special = input.nextLine();
            special = special.toLowerCase();
            if(special.equals("ai") || special.equals("networks") || special.equals("basic-science")  || special.equals("programing")){
                return special;
            }else{
                System.out.println("please enter ai , networks , basic-science or programing");
            }
        }
    }

    public static String getBookId(String propmt){
        System.out.print(propmt);
        while (true) {
            Boolean cond = true;
            String id = input.nextLine();
            for(Book b : Library.getBookArr()){
                if(b.ID.equals(id)){
                    cond = false;
                    break;
                }
            }
            if(cond){
                return id;
            }else{
                System.out.println("enter an id that is not repeated! ");
            }
            }
        }

        public static String getProject(String propmt){
            System.out.print(propmt);
            while (true) {
                Boolean cond = true;
                String id = input.nextLine();
                for(Project p : Library.getProjectArr()){
                    if(p.ID.equals(id)){
                        cond = false;
                        break;
                    }
                }
                if(cond){
                    return id;
                }else{
                    System.out.println("enter an id that is not repeated! ");
                }
                }
            }
    

}
