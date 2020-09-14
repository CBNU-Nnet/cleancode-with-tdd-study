package Model;

import java.util.Random;

public class RandomMake { //랜덤한 값을 생성하는 함수(1~9)

    public static Integer makeRand(){

        Integer randomValue;
        Random ran = new Random();
        randomValue=ran.nextInt(9)+1;
        return  randomValue;
    }


}
