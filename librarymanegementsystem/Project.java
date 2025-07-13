


import java.time.LocalDate;
import java.util.ArrayList;

public class Project extends Item{
    private String year;
    private ArrayList<String> workTeam;


    public Project(ArrayList<String> workTeam, String ID, String title  , LocalDate publishYear, String specialisation , String year) {
        super(ID, title, publishYear,specialisation);
        this.workTeam = workTeam;
        this.year = year;
    }

    public java.lang.String getYear() {
        return year;
    }

    public void setYear(java.lang.String year) {
        this.year = year;
    }

    public ArrayList<java.lang.String> getWorkTeam() {
        return workTeam;
    }

    public void setWorkTeam(ArrayList<java.lang.String> workTeam) {
        this.workTeam = workTeam;
    }
    
    
    
    public void printInfo(){
        System.out.println("");
        System.out.println("project(title: "+ title + ", specialisation: "+ specialisation + ", year: " + year + ", id : "+  ID + ", publish year: "+ publishYear + ", borrow time : "+ borrowTime + ", retrun time: "+ returnDate+", max return date: "+ maxReturnDate + " )");
        System.out.print("workTeam:( ");
        for(String person : workTeam){
            System.out.print(person + " ");
        }
        System.out.println(")");
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public LocalDate getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDate publishYear) {
        this.publishYear = publishYear;
    }

    public java.lang.String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(java.lang.String specialisation) {
        this.specialisation = specialisation;
    }

    public Boolean getTaken() {
        return Taken;
    }

    public void setTaken(Boolean Taken) {
        this.Taken = Taken;
    }

    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDate borrowTime) {
        this.borrowTime = borrowTime;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getMaxReturnDate() {
        return maxReturnDate;
    }

    public void setMaxReturnDate(LocalDate maxReturnDate) {
        this.maxReturnDate = maxReturnDate;
    }
    
    
}
