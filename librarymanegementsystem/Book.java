


import java.time.LocalDate;

public class Book extends Item{
    private String author ;
    private int numberOfPages;
    private String publishingHouse;
    
   
    public Book(String author, int numberOfPages, String publishingHouse,String specialisation  , String ID, String title, LocalDate publishYear) {
        super(ID, title, publishYear , specialisation);
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
    }

 

   

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
   
    public void printInfo() {
        System.out.println("Book( author :" + author + ", title: "+ title + ", publish house : "+ publishingHouse + ", specialisation: "+ specialisation+", id : " + ID + ", publish year: "+ publishYear + ", borrow time : "+ borrowTime + ", retrun time: "+ returnDate+", max return date: "+ maxReturnDate + " )");
    }
    
    
}
