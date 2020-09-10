package domain;

import Model.Round;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayTest {


    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource( strings = {"1","2","6","30","31"} )
    @DisplayName("숫자가 30이 넘을 때 테스트")
    void longTest(String num){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,
                () -> new Round(num));
        String message = e.getMessage();
        assertEquals(message,"정해진 범위내에 입력하세요");
    }

    @ParameterizedTest(name ="{index} {displayName} message={0}")
    @ValueSource( strings ={ "-1","0","-5","-2"})
    @DisplayName("1보다 작은 수 테스트")
    void PositiveTest(String num){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,
                () -> new Round(num));
        String message = e.getMessage();
        assertEquals("양수를 입력하세요",message);

    }
    @ParameterizedTest(name ="{index} {displayName} message={0}")
    @ValueSource( strings ={ "sfsr","qwert","a"})
    @DisplayName("문자열 처리 테스트")
    void StringTest(String num){
        IllegalArgumentException e=assertThrows(NumberFormatException.class,
                () -> new Round(num));
        String message = e.getMessage();
        //assertThat(message).contains("Fon input string");
        assertEquals("숫자를 입력하시오",message);
    }


}
