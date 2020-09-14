package domain;

import Model.Car;
import Model.RandomMake;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static Model.Car.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    @DisplayName("잘 나눠지는지 테스트")
    void splitTest(){
        String str="abc,drg,gfdh,sdfa";
        ArrayList set1 =Car.splitString(str);
        ArrayList<String> set=new ArrayList<String>();
        set.add("abc");
        set.add("drg");
        set.add("gfdh");
        set.add("sdfa");
        assertEquals(set1,set);
    }
    @Test
    @DisplayName("중복테스트")
    void DuplicateTest(){
        String value="abc";
        ArrayList<String>  list =new ArrayList<String>();
        list.add("abc");
        list.add("bcd");
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() ->
                validDuplicate(list,value));
        String message =e.getMessage();
        assertEquals(message,"동일한 이름");
    }
    @Test
    @DisplayName("null값 확인")
    void nullTest(){
        NullPointerException e = assertThrows(NullPointerException.class,() ->
                new Car(0,null));
        String message =e.getMessage();
        assertEquals(e.getMessage(),null);

    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"dgffs","fgdf","fdgfg","fdgfdgfg"})
    @DisplayName("5글자가 넘는지 테스트")
     void lengthTest(String Username){

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() -> new Car(0,Username));
        String message =e.getMessage();
        assertEquals(message,"길이가 깁니다");
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {""," ","  dd", "   ","    "})
    @DisplayName("공백이 있는지 확인하는 테스트")
    public void EmptyTest(String name){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() -> new Car(0,name));
        String message =e.getMessage();
        assertEquals(message,"공백을 입력할 수 없다");
    }

    @Test
    @DisplayName("랜덤 값으로 움직이는 테스트")
    void MovingTest(){
        Car firstCar = new Car(0,"qwer");
        Car secondCar = new Car(1,"asd");
        moving(firstCar, RandomMake.makeRand());
        moving(secondCar, RandomMake.makeRand());
        System.out.println(firstCar.getPosition());
        System.out.println(secondCar.getPosition());

    }
    @Test
    void PrintRoundTest(){
        ArrayList<Car> Carlist = new ArrayList<Car>();

        Carlist.add(new Car(0,"qwe"));
        Carlist.add(new Car(1,"dsf"));
        Carlist.add(new Car(2,"sdf"));
        Carlist.add(new Car(3,"fdgfg"));
        Carlist.add(new Car(4,"qdfs"));
        printRound(Carlist);

    }
    @Test
    void TestWinner(){
        ArrayList<Car> Carlist = new ArrayList<Car>();

        Carlist.add(new Car(0,"qwe"));
        Carlist.add(new Car(1,"dsf"));
        Carlist.add(new Car(2,"sdf"));
        Carlist.add(new Car(3,"fdgfg"));
        Carlist.add(new Car(4,"qdfs"));
        printWinner(Carlist);
    }

}