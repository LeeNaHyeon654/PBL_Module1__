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
       libMS.setUserDB("C:\\Temp\\UserData2025.txt");
       System.out.println("----- 이용자 목록 현황 -----");
       //시퀀스 다이어그램에 없는데 LibraryManagementSystem에서 if사용?
       libMS.printDB(libMS.userDB);
       
       libMS.setBookDB("C:\\Temp\\BookData2025.txt");
       System.out.println("----- 책 목록 현황 -----");
       //시퀀스 다이어그램에 없는데 LibraryManagementSystem에서 if사용?
       libMS.printDB(libMS.bookDB);
       
       libMS.borrowBook("2025320001", "B02");
       libMS.borrowBook("2024320002", "B03");
       libMS.borrowBook("2023320003", "B04");
       //빌린 순서대로 출력 되어야 하나요? 아니면 무작위로 출력되어도 되나요?
       //제 생각에는 hashamap의 출력은 무작위성을 가지고있는 것같은데 궁금해서 문의 드립니다
       libMS.printLoanList();
   }
}