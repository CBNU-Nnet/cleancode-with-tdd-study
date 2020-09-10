package View;

import java.util.Scanner;

public class InsertView {

    private Scanner in=null;

    public InsertView(){
        in = new Scanner(System.in);
    }
    public int InsertNum(){
        System.out.println("게임 횟수를 입력하시오");
        return in.nextInt();
    }
    public String InsertName(){
        System.out.println("이름을 입력하시오");
        return  in.nextLine();
    }
}
