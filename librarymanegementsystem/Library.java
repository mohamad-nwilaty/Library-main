
 
import java.time.LocalDate;
import java.util.ArrayList;

class Library {
    static private ArrayList<Book> bookArray;
    static private ArrayList<Project> projectArray;
    static private ArrayList<Member> memberArray;
    
    public static void initLibrary(ArrayList<Book> bookarray , ArrayList<Project> projectarray, ArrayList<Member> memberarray ){
        bookArray = bookarray;
        memberArray = memberarray;
        projectArray = projectarray;
    }
    
    public static Member selectMember(){
        System.out.println("");
        System.out.println("please select the number of the wanted member ");
        for(int i=0 ; i< memberArray.size() ; i++){
            System.out.println((i+1) + " " + memberArray.get(i).getName() + " ");
        }
        while (true) {
            int num = InputHelper.getInt("enter the number: ");
            if(num <= memberArray.size() && num > 0){
                return memberArray.get(num - 1);
            }else{
                System.out.println("enter a number from 1 to " + memberArray.size() );
            }
        }
    }

    public static Book selectBook(){
        System.out.println("");
        ArrayList<Book> arr = new ArrayList<Book>();
        for(Book b : bookArray){
             if( ! b.Taken){
                arr.add(b);
             }
        }
        if( !arr.isEmpty()){
            System.out.println("please select the number of the wanted Book ");
            for(int i=0 ; i< arr.size() ; i++){
                System.out.println((i+1) + " " + arr.get(i).title + " "  );
            }
            while (true) {
                int num = InputHelper.getInt("enter the number: ");
                if(num <= arr.size()  && num > 0){
                    return arr.get(num - 1);
                }else{
                    System.out.println("enter a number from 1 to " + (arr.size()) );
                }
            }
        }else{
            System.out.println("there are no availible books! ");
            return null;
        }
        
    }

    public static void addBookToLibrary(Book b){
        if(b instanceof Book){
            bookArray.add(b);
        }else{
            System.out.println("please eneter a book!! ");
        }
        
    }
    public static void addMemberToLibrary(Member m){
        if(m instanceof Member){
            memberArray.add(m);
        }else{
            System.out.println("please eneter a Member!! ");
        }
        
    }
    public static void addProjectToLibrary(Project p){
        if(p instanceof Project){
            projectArray.add(p);
        }else{
            System.out.println("please eneter a Project!! ");
        }
        
    }
    
    public static void borrowBook(Member member , Book book , LocalDate borrowTime){

        if(member.BookList.size() < 3){
            member.borrow(book, borrowTime);
        }
        else{
            System.out.println("member cant borrow more books! ");
        }
        
         
    }
    public static void returnBook(Member member , Book book , LocalDate returnTime){
        member.giveBack(book, returnTime);
    }
    
    public static void displayBooks(){
        for (Book b :bookArray)
            b.printInfo();
    }
    
    public static void printMembersAndBooks(){
        for(Member member : memberArray){
            member.printInfo();

        }
    }
    
    
    public static void findBook(String s){
        Boolean cas = false;
        ArrayList<Book> arr = new ArrayList<>();
        s = s.toLowerCase();
        for(Book book : bookArray){
            if(book.ID.toLowerCase().equals(s) || book.title.toLowerCase().equals(s) || book.specialisation.toLowerCase().equals(s) ){
                arr.add(book);
                cas = true;
            }
        }
        if(cas) {
            for(Book b : arr){
                b.printInfo();
            }
        }else{
            System.out.println("book not found :(");
        }
    }
 
    public static void thirdYearProjects(){
        for(Project p : projectArray){
            if(p.getYear().equals("third") ){
                p.printInfo();
            }
        }
    }
    public static void aiBorrowed(){
        for(Member member : memberArray){
            for(Book book : member.BookList){
                if(book.specialisation.equals("ai") ){
                    member.printInfo();
                    break;
                }
            }
        }
    }
    
    public static void lateBorrrow(){
        for(Member member : memberArray){
            for(Book book : member.BookList){
            if(LocalDate.now().isAfter(book.maxReturnDate)){
                System.out.println(member.getName() + "is late to return " + book.title);
            }
        }
        }
    }
    public static void printTakenBooks(){
            for(Book book : bookArray){
                if(book.Taken){
                    book.printInfo();
                }
            }
        }
    public static void printTakenProjects(){
            for(Project project : projectArray){
                if(!project.Taken){
                    project.printInfo();
                }
            }
        }
    
    public static void bookInRange(LocalDate firstDate , LocalDate secondDate){
        for(Member member : memberArray){
            for(Book book : member.BookList){
            if(firstDate.isBefore(book.borrowTime) && secondDate.isAfter(book.borrowTime)){
                System.out.println(member.getName() + "has borrowed "+ book.title + " in the time range");
            }
        }
        }
    }
    
}
