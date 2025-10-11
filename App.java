import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.File;
/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class App
{
   public static void main(String[] args){
       LibraryManagementSystem libMS = new LibraryManagementSystem();
       File u = new File("C:\\Temp\\UserData2025.txt");
       File b= new File("C:\\Temp\\BookData2025.txt");
       
       File[] userDB = u.listFiles();
       for(int i=0; i<userDB.length;i++){
           System.out.print(userDB[i].getName());
           
       }
   }
}