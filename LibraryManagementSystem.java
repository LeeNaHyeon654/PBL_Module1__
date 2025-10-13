import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.*;
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
        Book findbook = bookDB.findElement(bookID);
        User finduser = userDB.findElement(userID);

        loanDB.put(finduser,findbook);
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        try{
            Scanner scan = new Scanner(new FileReader(bookFile)); //495p 참고
            while(scan.hasNext()){ //토큰분리작업
                String word = scan.nextLine();
                StringTokenizer st = new StringTokenizer(word,"/");
                String bookID = st.nextToken();
                String title = st.nextToken();
                String author = st.nextToken();
                String publisher = st.nextToken();
                Integer year = Integer.valueOf(st.nextToken());
                Book book = new Book(bookID, title, author, publisher, year);
                bookDB.addElement(book);
            }
        }
        catch(FileNotFoundException e){//이거 없어도 됨 왜냐 밑에 있는게 다 잡을 수 있음.
            System.out.println("파일을 열 수 없음");
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
        return bookDB;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<User> setUserDB(String userFile)
    {
        try{
        Scanner scan = new Scanner(new FileReader(userFile));
        while(scan.hasNext()){//토큰분리작업
            String word = scan.nextLine();
            StringTokenizer st = new StringTokenizer(word,"/");
            Integer stID = Integer.valueOf(st.nextToken());
            String name = st.nextToken();
            User user = new User(stID, name);
            userDB.addElement(user);
        }

        }
        catch(FileNotFoundException e){//이거 없어도 됨 왜냐 밑에 있는게 다 잡을 수 있음.
            System.out.println("파일을 열 수 없음");
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
        return userDB;
    }
}