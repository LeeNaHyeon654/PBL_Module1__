import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.*;

/**
 * 도서관관리시스템 내에서 수행하는 여러가지 처리 작업을 정의해 놓은 클래스
 *
 * @author (2024320009 이나현, 2024320011 김혜린)
 * @version (2025.10.13)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    HashMap<User,Book> loanDB;
    LibDB<User> userDB;

    /**
     * LibraryManagementSystem 클래스의 객체 생성자
     */
    public LibraryManagementSystem()
    {
        bookDB = new LibDB<Book>();
        loanDB = new HashMap<User,Book>();
        userDB = new LibDB<User>();
    }

    /**
     * userID와 bookID를 매개변수로 받아 대출 하는 메소드
     *
     * @param  userID : String, bookID : String
     */
    public void borrowBook(String userID, String bookID)
    {
        Book findbook = bookDB.findElement(bookID);
        User finduser = userDB.findElement(userID);

        loanDB.put(finduser,findbook);
    }

    /**
     * 전달받은 데이터베이스에 있는 모든 요소를 출력하는 제네릭한 메소드
     *
     * @param   db : LibDB<T>
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * 대출DB에 저장된 정보를 요구사항의 출력 화면과 같이 대출 현황을 출력하는 메소드
     */
    public void printLoanList(){
        System.out.println("----- 대출 현황 -----");  
        Set<User> user = loanDB.keySet();
        Iterator<User> it = user.iterator();
        while(it.hasNext()){
            User u = it.next();
            Book b = loanDB.get(u);
            System.out.println(u + " ===> " + b);
        }
        System.out.println("--------------------\n");
    }

    /**
     * 매개변수로 받은 책 정보를 이용해 객체를 만들고, 이를 DB에 저장하는 메소드
     *
     * @param   bookFile : String
     * @return  책 정보가 저장된 bookDB 리턴
     */

    public LibDB<Book> setBookDB(String bookFile)
    {
        try{
            FileReader fi = new FileReader(bookFile);
            Scanner scan = new Scanner(fi);
            Vector<Book> bookVector = new Vector<Book>();

            while(scan.hasNext()){
                String word = scan.nextLine();

                StringTokenizer st = new StringTokenizer(word,"/");

                String bookID = st.nextToken();
                String title = st.nextToken();
                String author = st.nextToken();
                String publisher = st.nextToken();
                int year = Integer.valueOf(st.nextToken());

                Book book = new Book(bookID, title, author, publisher, year);
                bookVector.add(book);
            }

            Iterator<Book> it = bookVector.iterator();
            while(it.hasNext()){
                Book b = it.next();
                bookDB.addElement(b);
            }
            fi.close();
            scan.close();
        }

        catch(FileNotFoundException e){
            System.out.println("파일을 열 수 없음");
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
        return bookDB;
    }

    /**
     * 매개변수로 받은 이용자 정보를 이용해 객체를 만들고, 이를 DB에 저장하는 메소드
     *
     * @param   userFile : String
     * @return  이용자 정보가 저장된 userDB 리턴
     */
    public LibDB<User> setUserDB(String userFile)
    {
        try{
            FileReader fi = new FileReader(userFile);
            Scanner scan = new Scanner(fi);
            Vector<User> userVector = new Vector<User>();

            while(scan.hasNext()){
                String word = scan.nextLine();
                
                StringTokenizer st = new StringTokenizer(word,"/");
  
                Integer stID = Integer.valueOf(st.nextToken());
                String name = st.nextToken();

                User user = new User(stID, name);
                userVector.add(user);
            }

            for(int i = 0; i<userVector.size(); i++){
                User u = userVector.get(i);
                userDB.addElement(u);
            }
            fi.close();
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("파일을 열 수 없음");
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
        return userDB;
    }
}