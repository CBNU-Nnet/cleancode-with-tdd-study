package Model;

public class Round {

    String num;

    public Round(String num) {
        valid(num);
        this.num = num;
    }

    public String getNum() {
        return num;
    }
    public void valid(String num){
        validString(num);
        validSize(num);
        validPositive(num);


    }

    private void validString(String num) { //입력한 횟수가 문자인지 확인

        for (int i=0;i<num.length();i++) {
            char tmp = num.charAt(i);
            System.out.println(tmp);
            if (!Character.isDigit(tmp) && (tmp!='-')) {
                throw new NumberFormatException("숫자를 입력하시오") ;
            }
        }
    }

    private void validSize(String num) { //입력한 횟수가 30이 넘는지 확인
        if(Integer.parseInt(num)>30){
            throw new IllegalArgumentException("정해진 범위내에 입력하세요");
        }
    }

    private void validPositive(String num) { //입력한 횟수가 양수인지 확인
        if(Integer.parseInt(num)<1)
            throw new IllegalArgumentException("양수를 입력하세요");
    }
}
