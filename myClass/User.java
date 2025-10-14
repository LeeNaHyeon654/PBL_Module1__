package myClass;

/**
 * 도서관 이용자 정보를 저장하는 클래스
 *
 * @author (2024320009 이나현, 2024320011 김혜린)
 * @version (2025.10.13)
 */
public class User extends DB_Element
{
    private Integer stID;
    private String name;
    /**
     * User 클래스의 객체 생성자
     * 
     * @param  stID : Integer, name : String
     */
    public User(Integer stID,String name)
    {
        this.stID = stID;
        this.name = name;
    }

    /**
     * 이용자의 ID를 문자열 형태로 반환하기 위한 메소드
     *
     * @return    stID를 String형으로 변환하여 리턴
     */
    public String getID(){
        return String.valueOf(this.stID);
    }

    /**
     * 출력 화면에 나와있는 형태로 이용자 목록을 출력하기 위해 오버라이딩한 메소드
     *
     * @return     이용자 정보 문자열
     */
    public String toString(){
        return "["+stID+"] "+name;
    }

}