package myClass;

/**
 * Book 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;
    public Book(String bookID,String title,String author,String publisher,int year)
    {
        this.bookID=bookID;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.year=year;
    }

    public String getID(){
        return this.bookID;
    }

    public String toString(){
        return "("+bookID+") "+title+", "+author+", "+publisher+", "+year;
    }
}