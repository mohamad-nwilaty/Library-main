
import java.time.LocalDate;

public  abstract class Item {
   protected String ID;
   protected String title;
   protected LocalDate publishYear;
   protected String specialisation;
   protected Boolean Taken = false;
   protected LocalDate borrowTime ;
   protected LocalDate returnDate ;
   protected LocalDate maxReturnDate;


 
    public void String() {
        System.out.println("Item{" + "ID=" + ID + ", title=" + title + ", publishYear=" + publishYear + ", specialisation=" + specialisation + '}'); 
    }
   
   
   
    public Item(String ID, String title, LocalDate publishYear , String specialisation ) {
        this.ID = ID;
        this.title = title;
        this.publishYear = publishYear;
        this.specialisation = specialisation;
        }

    }

    

