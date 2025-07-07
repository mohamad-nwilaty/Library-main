
import java.util.Collection;
import java.util.Collections;
import java.time.LocalDate;
import java.util.ArrayList;



public class LibraryManegementSystem {

    public static void main(String[] args) {
        
        // declaring books
        Book B1 = new Book("Kaizal", 400, "Damascus Library", "ai", "090", "Ai neards", LocalDate.now());
        Book B2 = new Book("Potter", 500, "Damascus Library", "netWorks", "080","netNeards", LocalDate.now());
        Book B3 = new Book("Naruto", 700, "Damascus Library ", "programming", "070", "c++&c#", LocalDate.now());
        Book B4 = new Book("Zoro", 900, " Damascus Library", "ai", "060", "Ai things", LocalDate.now());
        Book B5 = new Book("mikasa", 550, " Damascus Library", "ai", "160", "Advanced Ai", LocalDate.now());
        Book B6 = new Book("undyne", 250, " Damascus Library", "netWorks", "330", "net hacks", LocalDate.now());
        Book B7 = new Book("tengen", 440, " Damascus Library", "Basics Science", "011", "the Basics of sciences", LocalDate.now());
        Book B8 = new Book("Levi", 120, " Damascus Library", "Programming", "061", "oop in java", LocalDate.now());


        ArrayList <Book> bookArr1 = new ArrayList<>();
        ArrayList <Book> bookArr2 = new ArrayList<>();
        ArrayList <Book> bookArr3 = new ArrayList<>();
        ArrayList <Book> bookArr4 = new ArrayList<>();
           
        bookArr1.add(B1);  bookArr1.add(B5);
        bookArr2.add(B2); bookArr2.add(B6);
        bookArr3.add(B3); bookArr3.add(B7);
        bookArr4.add(B4); 

        
        // declaring work teams
        ArrayList <String> w1 = new ArrayList<>();
        ArrayList <String> w2 = new ArrayList<>();
        ArrayList <String> w3 = new ArrayList<>();
        w1.add("sara"); w1.add("monther"); w1.add("rahul");
        w2.add("saray"); w2.add("timie"); w2.add("sans");
        w3.add("makima"); w3.add("gojo"); w3.add("nezuko");
        
        
        
        Project p1 = new Project(w1, "001", "project1", LocalDate.now(), "Ai", "third");
        Project p2 = new Project(w2, "011", "project2", LocalDate.now(), "programming", "fourth");
        Project p3 = new Project(w3, "111", "project3", LocalDate.now(), "Ai", "graduate");
        Project p4 = new Project(w3, "002", "project4", LocalDate.now(), "Ai", "third");
        Project p5 = new Project(w1, "022", "project5", LocalDate.now(), "programming", "fourth");
        Project p6 = new Project(w1, "222", "project6", LocalDate.now(), "Ai", "graduate");
        
          
        ArrayList <Project> projectArr1 = new ArrayList<>();
        ArrayList <Project> projectArr2 = new ArrayList<>();
        ArrayList <Project> projectArr3 = new ArrayList<>();
        ArrayList <Project> projectArr4 = new ArrayList<>();
        
        projectArr1.add(p1); projectArr1.add(p2);
        projectArr2.add(p3); projectArr2.add(p4);
        projectArr3.add(p5); projectArr3.add(p6);  

        Member m1 = new Member("Laith", bookArr1, projectArr1);
        Member m2 = new Member("Mohammed", bookArr2, projectArr2);
        Member m3 = new Member("Ilya", bookArr3, projectArr3);
        Member m4 = new Member("morhaf", bookArr4, projectArr4);


        // initializing the library
        ArrayList<Book> allBooks = new ArrayList<>();
        ArrayList<Project> allProjects = new ArrayList<>();
        ArrayList<Member> allMembers = new ArrayList<>();

        Collections.addAll(allBooks, B1, B2, B3, B4, B5, B6, B7, B8);
        Collections.addAll(allProjects, p1, p2, p3, p4, p5, p6);
        Collections.addAll(allMembers, m1, m2, m3, m4);

        Library.initLibrary(allBooks, allProjects, allMembers);
        
       

        

        boolean run = true;
        while (run) {
            System.out.println("");
            System.out.println("*** welcome to the Library please select one of the following ***");
            System.out.println("[1] : to print all the books in the library");
            System.out.println("[2] : to display all members and the books they have borrowed");
            System.out.println("[3] : to add a book or a project to the library");
            System.out.println("[4] : to search for a book by id , title or specialisation");
            System.out.println("[5] : to borrow a book or project"); // *
            System.out.println("[6] : to return a book or project"); // *
            System.out.println("[7] : to display all the third year projects");
            System.out.println("[8] : to display all the members who borrowed an ai book");
            System.out.println("[9] : to display all members who are late to return a book"); // fix borrow time issue is null
            System.out.println("[10] : to display all the borrowed books");
            System.out.println("[11] : to display all the availible projects (unborrowed) within a specific specilisation");
            System.out.println("[12] : to display members who borrowed a book within a time period");
            System.out.println("[13] : to exit ");
            System.out.println("");
            int c = InputHelper.getInt("enter the number of the operation ");

            switch(c){

                case 1 : 
                    Library.displayBooks();
                    break;

                case 2 :
                    Library.printMembersAndBooks();
                    break;

                case 3:
                    String enter = InputHelper.getString("enter b for book , p for project ");
                    String id = InputHelper.getString("enter the id ");
                    String title = InputHelper.getString("enter the title ");
                    String specialisation = InputHelper.getSpecialisation("enter the specialisation (ai , networks , basic-science or programing)");
                    LocalDate publishYear = InputHelper.getDate("enter the publish year ");
                    switch (enter.toLowerCase()) {
                        case "b":
                            String author = InputHelper.getString("enter the name of the author ");
                            String publishHouse = InputHelper.getString("enter the name of the publishing house ");
                            int pageNum = InputHelper.getInt("enter the number of pages ");
                            Book newBook = new Book(author, pageNum, publishHouse, specialisation, id, title, publishYear);
                            Library.addBookToLibrary(newBook);
                            System.out.println("book added successfully");
                            break;
                        
                        case "p":{
                            String year = InputHelper.getProjectYear("enter the year of the project (third-fourth-finale) ");
                            ArrayList<String> workTeam = new ArrayList<>();
                            int count = InputHelper.getInt("enter the number of people on the work team ");
                            for(int i=0 ; i<count ; i++ ){
                                String name = InputHelper.getString("enter the name of person number " + i+1 + " ");
                                workTeam.add(name);
                            }
                            Project newProject = new Project(workTeam, id, title, publishYear, specialisation, year);
                            Library.addProjectToLibrary(newProject);
                            break;
                        }

                        default:
                        System.out.println("please enter b or p !!");
                            break;
                    }
                    
                    break;

                case 4:
                    String serchId = InputHelper.getString("type the id , specialisation or title of the book ");
                    System.out.println("");
                    Library.findBook(serchId);
                    break;

                case 5:
                    Member m = Library.selectMember();
                    System.out.println(m.getName());
                    break;

                case 7:
                    Library.thirdYearProjects();
                    break;

                    case 8:
                        Library.aiBorrowed();
                        break ;

                    case 9:
                        Library.lateBorrrow();
                        break;

                case 13:
                System.out.println("GoodBye ^w^");
                    run = false;
                    break;    

                default:
                    System.out.println("enter a valid operation");
            }

        }
        
        

        
    }
}
