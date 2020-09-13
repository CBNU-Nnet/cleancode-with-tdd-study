package controller;

import Model.Car;

import java.util.ArrayList;
import java.util.Iterator;

public class UserController {
    public static ArrayList<Car> initialize(String names){

        ArrayList<String> nameList= Car.splitString(names); //문자열로 받을 이름 리스트
        ArrayList<Car> carList = new ArrayList<>(); //자동차 객체를 담은 리스트

        Iterator iterName = nameList.iterator();
        //자동차 객체 생성
        while(iterName.hasNext()){
            String next= iterName.next().toString();
            Car newCar = new Car(0,next);
            carList.add(newCar);
            System.out.println(newCar.getUsername());
        }

        return carList;
    }


}
