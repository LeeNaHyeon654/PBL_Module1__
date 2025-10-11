import DataBase.*;
import myClass.*;
import java.util.*;

/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryManagementSystem
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
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
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void borrowBook(String userID, String bookID)
    {

    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public static void printLoanList(HashMap<User,Book> loanDB){
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

    // /**
     // * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     // *
     // * @param  y  메소드의 샘플 파라미터
     // * @return    x 와 y의 합
     // */
    // public LibDB<Book> setBookDB(String bookFile)
    // {
        // return ;
    // }

    // /**
     // * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     // *
     // * @param  y  메소드의 샘플 파라미터
     // * @return    x 와 y의 합
     // */
    // public LibDB<User> setUserDB(String userFile)
    // {
        // return 0;
    // }
}