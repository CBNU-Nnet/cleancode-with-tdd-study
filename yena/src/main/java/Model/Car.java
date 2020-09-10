package Model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

public class Car {

    String  name;

    /*public Car(Integer position) {
        Position = position;
    }*/

    Integer Position;

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }

    public Car(Integer position, String username) {
        valid(username);
        this.name = username;
        Position = position;
    }

    public static HashSet<String> Split_String(String namelist){
        HashSet<String> set = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(namelist,",");
        while(st.hasMoreTokens()){
            String next =st.nextToken();
            Valid_Duplicate(set,next);
            set.add(next);
        }
        return set;
    }

    static public void Valid_Duplicate(HashSet<String> set, String name){
        if(set.contains(name))
            throw new IllegalArgumentException("동일한 이름");

    }
    public String getUsername() {
        return name;
    }


    private void valid(String username){
        valid_Length(username);
        space_Valid(username);
        null_Valid(username);


    }
    private void valid_Length(String username){
        if(username.length()>5){
            String message="길이가 깁니다";
            throw new IllegalArgumentException(message);
        }
    }
    private void space_Valid(String username){
        Integer length= username.trim().length();
       // System.out.println(length);
        if (length!=username.length() || length==0 ){
            throw new IllegalArgumentException("공백을 입력할 수 없다");
        }
    }
    private void null_Valid(String username){
        if(username.isEmpty()){
            throw new NullPointerException("null값은 입력할 수 없다");
        }
    }
    public static Integer RandMove(){

        Random rand = new Random();

        return rand.nextInt(9)+1;

    }

    public static void Moving(Car newCar,Integer value){
       // System.out.println(value);
        if(value>=4)
            newCar.setPosition(newCar.getPosition()+value);
    }

    public static void PrintRound(HashSet<Car> set){
        Iterator<Car> iter= set.iterator();
        while(iter.hasNext()){
            Car nextCar= iter.next();
            System.out.println("이름: "+nextCar.getUsername()+" 위치:"+ nextCar.getPosition());
        }

    }
    public static void PrintWinner(HashSet<Car> set){
        Iterator<Car> iter = set.iterator();
        Car winner = new Car(0,"0");

        while(iter.hasNext()){
            Car nextCar= iter.next();
            if(nextCar.getPosition()>winner.getPosition())
                winner= nextCar;
        }
        System.out.println("우승자: "+winner.getUsername());
    }
}
