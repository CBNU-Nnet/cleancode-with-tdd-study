package View;

import Model.Car;
import Model.RandomMake;

import java.util.ArrayList;
import java.util.Iterator;

import static Model.Car.*;

public class OutputView {

    //매 라운드 결과 출력
    public static void result(Integer num, ArrayList<Car> carList){
        for(int i=1;i<=num;i++){
            System.out.println(i+"라운드 결과");
            Iterator<Car> iterCar = carList.iterator();
            while(iterCar.hasNext()){
                Car nextCar= iterCar.next();
                moving(nextCar, RandomMake.makeRand());
            }
            printRound(carList);
        }
        printWinner(carList);
    }


}
