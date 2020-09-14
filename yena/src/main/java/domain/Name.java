package domain;

import java.util.HashSet;
import java.util.StringTokenizer;

public class Name {
    /*
     String  username;

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
        return username;
    }

    public Name(String username) {
        valid(username);
        this.username = username;
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
        System.out.println(length);
        if (length!=username.length() || length==0 ){
            throw new IllegalArgumentException("공백을 입력할 수 없다");
        }
    }
    private void null_Valid(String username){
        if(username.isEmpty()){
            throw new NullPointerException("null값은 입력할 수 없다");
        }
    }

*/
}
