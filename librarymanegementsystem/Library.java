
 
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

    public static ArrayList<Book> getBookArr(){
        return bookArray ;
    }

    public static ArrayList<Project> getProjectArr(){
        return projectArray ;
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

    public static Book selectBook(ArrayList<Book> originalArr , boolean taken){ // here we give the array as a parameter for reusability and we pass the boolean as a varialbe in order to use the function when selecting both taken and availible books
        System.out.println("");
        ArrayList<Book> arr = new ArrayList<Book>();
        for(Book b : originalArr){ // we make a new array with only availible books because we are using the indesies to get and display them
             if(b.Taken == taken){
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

    public static Project selectProject(ArrayList<Project> originalArr , boolean taken){ // here we give the array as a parameter for reusability and we pass the boolean as a varialbe in order to use the function when selecting both taken and availible books
        System.out.println("");
        ArrayList<Project> arr = new ArrayList<Project>();
        for(Project p : originalArr){ // we make a new array with only availible books because we are using the indesies to get and display them
             if(p.Taken == taken){
                arr.add(p);
             }
        }
        if( !arr.isEmpty()){
            System.out.println("please select the number of the wanted Project ");
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
            System.out.println("there are no availible Projects! ");
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
    
    public static void borrow(Member member , Item obj , LocalDate borrowTime){
        if(obj instanceof Book){
            if(member.getBookList().size() < 3){
                member.borrow(obj, borrowTime);
            }
            else{
                System.out.println("member cant borrow more books! ");
            }
        }else{
            if(member.getProjectList().size() < 3){
                member.borrow(obj, borrowTime);
            }
            else{
                System.out.println("member cant borrow more Projects! ");
            }
        }
           
    }

    public static void returnBook(Member member , Item obj ){
        member.giveBack(obj);
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
        Boolean cond = false;
        for(Member member : memberArray){
            for(Book book : member.getBookList()){
                if(book.specialisation.equals("ai") ){
                    cond = true ;
                    member.printInfo();
                    break;
                }
            }
        }
        if(!cond) System.out.println("no one hase borrowed any ai books ");
    }
    
    public static void lateBorrrow(){
        Boolean cond = false;
        for(Member member : memberArray){
            for(Book book : member.getBookList()){
            if(LocalDate.now().isAfter(book.maxReturnDate)){
                cond = true ;
                System.out.println(member.getName() + " is late to return " + book.title);
            }
        }
        }
        if(!cond) System.out.println("no one is late to returning any books ");
    }

    public static void printTakenBooks(){
           Boolean cond = false;
            for(Book book : bookArray){
                if(book.Taken){
                    cond = true ;
                    book.printInfo();
                }
            }
            if(!cond) System.out.println("no books are borrowed yet ");
        }

    public static void printTakenProjects(){
            Boolean cond = false;
            for(Project project : projectArray){
                if(project.Taken){
                    cond = true ;
                    project.printInfo();
                }
            }
            if(!cond) System.out.println("no ono projects are borrowed yet ");
        }

    public static void printAvailibleProjects(String specilisation){
        Boolean cond = false;
        for(Project project : projectArray){
            if( !project.Taken && project.specialisation.equals(specilisation)){
                cond = true ;
                project.printInfo();
             }
        }
        if(!cond) System.out.println("there are no avalible projects in this specialisation ");
    }
    
    public static void bookInRange(LocalDate firstDate , LocalDate secondDate){
        Boolean cond = false;
        System.out.println("");
        for(Member member : memberArray){
            for(Book book : member.getBookList()){
            if(firstDate.isBefore(book.borrowTime) && secondDate.isAfter(book.borrowTime)){
                cond = true ;
                System.out.println(member.getName() + " has borrowed "+ book.title + " in the time range");
            }
        }
        }
        if(!cond) System.out.println("no one has borrowed any books in this range ");
    }
    
}
