package Model;

public class Round {

    String num;

    public Round(String num) {
        Valid(num);
        this.num = num;
    }

    public String getNum() {
        return num;
    }
    public void Valid(String num){
        Valid_String(num);
        Valid_size(num);
        Valid_Positive(num);


    }

    private void Valid_String(String num) {

        for (int i=0;i<num.length();i++) {
            char tmp = num.charAt(i);
            System.out.println(tmp);
            if (!Character.isDigit(tmp) && (tmp!='-')) {
                throw new NumberFormatException("숫자를 입력하시오") ;
            }
        }
    }

    private void Valid_size(String num) {
        if(Integer.parseInt(num)>30){
            throw new IllegalArgumentException("정해진 범위내에 입력하세요");
        }
    }

    private void Valid_Positive(String num) {
        if(Integer.parseInt(num)<1)
            throw new IllegalArgumentException("양수를 입력하세요");
    }
}
