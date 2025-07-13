
import java.time.LocalDate;
import java.util.ArrayList;

public class Member {
    private  static int memberCount = 1;
    private int membershipNumber;
    private String name;
    private ArrayList <Book> BookList = new ArrayList<Book>();
    private ArrayList <Project> ProjectList = new ArrayList<Project>();
    

    public Member(String name) {
        this.name = name;
        this.membershipNumber = memberCount;
        memberCount++;
    }
    
    public void borrow(Item obj , LocalDate borrowTime ){
        obj.borrowTime = borrowTime ;
        obj.maxReturnDate = obj.borrowTime.plusDays(7);
        obj.Taken = true ;
        if(obj instanceof Book){ 
            BookList.add((Book)obj);
                    
        }else{
            ProjectList.add((Project) obj);
        }
        

        
    }
    
    public void giveBack(Item obj ){
        obj.Taken = false ;
        obj.returnDate = LocalDate.now() ;
        if(obj instanceof Book){
            BookList.remove((Book)obj);
        }else{
            ProjectList.remove((Project) obj);
        }
        
}

    
    public void printInfo() {
        System.out.println("name: "+ this.name + " , membership num : " + this.membershipNumber);
        if(! BookList.isEmpty()){
            for(Book book : BookList){
                book.printInfo();
            }
        }else{
            System.out.println("has not borrowed any books ");
        }
        
        System.out.println("");
    }

    public static int getMemberCount() {
        return memberCount;
    }

    public static void setMemberCount(int memberCount) {
        Member.memberCount = memberCount;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBookList() {
        return BookList;
    }

    public void setBookList(ArrayList<Book> BookList) {
        this.BookList = BookList;
    }

    public ArrayList<Project> getProjectList() {
        return ProjectList;
    }

    public void setProjectList(ArrayList<Project> ProjectList) {
        this.ProjectList = ProjectList;
    }
    
    
    
    
    
}
