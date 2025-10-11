package DataBase;
import java.util.*;
import myClass.*;
/**
 * LibDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibDB<T extends DB_Element>
{
    private ArrayList<T> db;

    /**
     * LibDB 클래스의 객체 생성자
     */
    public LibDB()
    {
        db = new ArrayList<T>();
    }

    public void addElement(T e){
        db.add(e);
    }
    
    public T findElement(String s){
        Iterator<T> it = db.iterator();
        while(it.hasNext()){
            T element = it.next();
            if((element.getID()).equals(s)){
                return element;
            }
        }
        return null;
    }
    
    public void printAllElements(){
        for(T e : db){
            System.out.println(e);
        }
    }
}