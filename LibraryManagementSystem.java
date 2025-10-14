import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * 도서관관리시스템 내에서 수행하는 여러 가지 처리작업을 정의해 놓은 클래스
 *
 * @author (2024320009 이나현, 2024320011 김혜린)
 * @version (2025.10.13)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    HashMap<User,Book> loanDB;
    LibDB<User> userDB;
    Iterator<Book> it;
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
     * 이용자ID와 책ID를 매개변수로 받아 대출 정보를 등록하는 메소드
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
     * @param  db : LibDB<T>
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * 대출DB에 저장된 정보를 출력 화면에 나와있는 형태로 대출 현황 출력하는 메소드
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
        System.out.println("--------------------");
    }

    /**
     * 책의 등록정보를 매개변수로 전달 받아 데이터를 읽어서 책 객체 생성 한 후 책DB에 저장하는 메소드
     *
     * @param  bookFile : String
     * @return    책 정보가 저장된 bookDB 리턴
     */

    public LibDB<Book> setBookDB(String bookFile)
    {
        try{
            Scanner scan = new Scanner(new FileReader(bookFile));
            Book book;
            while(scan.hasNext()){
                String word = scan.nextLine();
                StringTokenizer st = new StringTokenizer(word,"/");
                String bookID = st.nextToken();
                String title = st.nextToken();
                String author = st.nextToken();
                String publisher = st.nextToken();
                int year = Integer.valueOf(st.nextToken());
                book = new Book(bookID, title, author, publisher, year);
                //bookDB.addElement(b);//이거가 아마 저장하는것 같음
            }
            System.out.println("----- 책 목록 출력 -----");
            Iterator<Book> it = bookDB.iterator();
            while(it.hasNext()){
                Book b = it.next();
                bookDB.addElement(b);//이거가 아마 저장하는것 같음
            }

            System.out.println("--------------------");
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
     * 이용자의 등록정보를 매개변수로 전달 받아 데이터를 읽어서 이용자 객체 생성 한 후 이용자DB에 저장하는 메소드
     *
     * @param  userFile : String
     * @return    이용자 정보가 저장된 userDB 리턴
     */
    public LibDB<User> setUserDB(String userFile)
    {
        try{
            Scanner scan = new Scanner(new FileReader(userFile));
            while(scan.hasNext()){
                String word = scan.nextLine();
                StringTokenizer st = new StringTokenizer(word,"/");
                Integer stID = Integer.valueOf(st.nextToken());
                String name = st.nextToken();
                User user = new User(stID, name);
                userDB.addElement(user);
            }
            System.out.println("----- 이용자 목록 출력 -----");
            for(int i = 0; i<userDB.size(); i++){//여기서 출력문 삭제하고 여기서 리턴해야하는것같음 밑에서 하는게 아니라 아마?
                return userDB.get(i);
            }
            System.out.println("--------------------");
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