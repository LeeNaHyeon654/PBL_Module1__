package DataBase;
import java.util.*;
import myClass.*;
/**
 * 책이나 이용자 데이터를 저장, 관리하는 제네릭한 데이터베이스 클래스
 *
 * @author (2024320009 이나현, 2024320011 김혜린)
 * @version (2025.10.13)
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

    /**
     * 데이터베이스에 요소하나를 추가하는 메소드
     * 
     * @param  element : T
     **/
    public void addElement(T element){
        db.add(element);
    }

    /**
     * 데이터베이스에서 ID와 일치하는 객체를 찾아 반환하는 메소드
     * 
     * @param  id : String
     * @return  ID와 일치하는 요소(T), 일치하는 요소가 없으면 null 반환
     **/
    public T findElement(String id){
        Iterator<T> it = db.iterator();
        while(it.hasNext()){
            T element = it.next();
            if((element.getID()).equals(id)){
                return element;
            }
        }
        return null;
    }

    /**
     * 데이터베이스에 저장된 모든 요소들을 출력하는 메소드
     **/
    public void printAllElements(){
        for(T e : db){
            System.out.println(e);
        }
        System.out.println();
    }

}