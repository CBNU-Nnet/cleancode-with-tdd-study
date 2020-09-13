package Model;

import java.util.*;

public class Car {

    String  name;
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

    public static ArrayList<String> splitString(String namelist){
        ArrayList<String> list = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(namelist,",");
        while(st.hasMoreTokens()){
            String next =st.nextToken();
            validDuplicate(list,next);
            list.add(next);
        }
        return list;
    }

    static public void validDuplicate(ArrayList<String> list, String name){ //같은 이름이 있는지 확인
        if(list.contains(name))
            throw new IllegalArgumentException("동일한 이름");

    }
    public String getUsername() {
        return name;
    }


    private void valid(String username){
        validLength(username);
        spaceValid(username);
        nullValid(username);


    }
    private void validLength(String username){ //이름 길이가 5가 넘는지 확인
        if(username.length()>5){
            String message="길이가 깁니다";
            throw new IllegalArgumentException(message);
        }
    }
    private void spaceValid(String username){ //공백을 입력한 이름인지 확인
        Integer length= username.trim().length();
        if (length!=username.length() || length==0 ){
            throw new IllegalArgumentException("공백을 입력할 수 없다");
        }
    }
    private void nullValid(String username){ // 이름이 null인지 확인
        if(username.isEmpty()){
            throw new NullPointerException("null값은 입력할 수 없다");
        }
    }

    public static void moving(Car newCar, Integer value){ //하나의 자동차의 위치를 정해줌
        if(value>=4)
            newCar.setPosition(newCar.getPosition()+value);
    }

    public static void printRound(ArrayList<Car> list){ //한 라운드 결과 출력
        Iterator<Car> iter= list.iterator();
        while(iter.hasNext()){
            Car nextCar= iter.next();
            System.out.println("이름: "+nextCar.getUsername()+" 위치:"+ nextCar.getPosition());
        }


    }
    public static void printWinner(ArrayList<Car> list){ // 우승자 출력
        Iterator<Car> iter = list.iterator();
        Car winner = new Car(0,"0");

        while(iter.hasNext()){
            Car nextCar= iter.next();
            if(nextCar.getPosition()>winner.getPosition())
                winner= nextCar;
        }
        System.out.println("우승자: "+winner.getUsername());
    }
}
