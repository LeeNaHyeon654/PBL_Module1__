package myClass;

/**
 * 책 정보를 저장하는 클래스
 *
 * @author (2024320009 이나현, 2024320011 김혜린)
 * @version (2025.10.13)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;
    /**
     * Book 클래스의 객체 생성자
     * 
     * @param  bookID : String, title : String, author : String, publisher : String, year : int
     */
    public Book(String bookID, String title, String author, String publisher, int year)
    {
        this.bookID=bookID;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.year=year;
    }

    /**
     * 책의 ID를 문자열 형태로 반환하기 위한 메소드
     *
     * @return    bookID를 리턴
     */
    public String getID(){
        return this.bookID;
    }

    /**
     * 출력 화면에 나와있는 형태로 책 목록을 출력하기 위해 오버라이딩한 메소드
     *
     * @return     책 정보 문자열
     */
    public String toString(){
        return "("+bookID+") "+title+", "+author+", "+publisher+", "+year;
    }
}