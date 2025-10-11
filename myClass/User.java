package myClass;

/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class User extends DB_Element
{
    private Integer stID;
    private String name;
   
    public User(Integer stID,String name)
    {
        this.stID = stID;
        this.name = name;
    }

    public String getID(){
        return String.valueOf(this.stID);
    }
    public String toString(){
        return "["+stID+"] "+name;
    }

}