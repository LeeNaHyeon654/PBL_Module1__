import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.File;
/**
 * 도서관관리시스템의 주요 기능을 순차적으로 실행하는 메인 클래스
 *
 * @author (2024320009 이나현, 2024320011 김혜린)
 * @version (2025.10.13)
 */
public class App
{
    public static void main(String[] args){
        LibraryManagementSystem libMS = new LibraryManagementSystem();

        LibDB<User> userDB = libMS.setUserDB("C:\\Temp\\UserData2025.txt");
        libMS.printDB(userDB);

        LibDB<Book> bookDB = libMS.setBookDB("C:\\Temp\\BookData2025.txt");
        libMS.printDB(bookDB);

        libMS.borrowBook("2025320001", "B02");
        libMS.borrowBook("2024320002", "B03");
        libMS.borrowBook("2023320003", "B04");

        libMS.printLoanList();
    }
}