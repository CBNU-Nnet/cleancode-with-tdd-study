package controller;
import Model.*;
import View.InsertView;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;

import static Model.Car.*;

public class userController {

    public static void main(String[] args){

       // Car car = new Car();
        InsertView view = new InsertView();
        String names = view.InsertName();

        HashSet<String> NameList= Car.Split_String(names);
        HashSet<Car>Car_list = new HashSet<Car>();

        Iterator iter_name = NameList.iterator();
        //자동차 객체 생성
        while(iter_name.hasNext()){
            String next= iter_name.next().toString();
            Car newCar = new Car(0,next);
            Car_list.add(newCar);
            System.out.println(newCar.getUsername());
        }


        Integer num = view.InsertNum();
        //라운드 별결과출력
        for(int i=1;i<=num;i++){
            System.out.println(i+"라운드 결과");
            Iterator<Car> iter_car = Car_list.iterator();
            while(iter_car.hasNext()){
                Car nextCar= iter_car.next();
                Moving(nextCar,RandMove());
            }
            PrintRound(Car_list);
        }
        //우승자 출력
        PrintWinner(Car_list);
    }
}
