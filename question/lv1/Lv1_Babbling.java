package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 설명
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고
 * 연속해서 같은 발음을 하는 것을 어려워합니다.
 *
 * 문자열 배열 babbling이 매개변수로 주어질 때,
 * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ babbling의 길이 ≤ 100
 * 1 ≤ babbling[i]의 길이 ≤ 30
 * 문자열은 알파벳 소문자로만 이루어져 있습니다.
 */

public class Lv1_Babbling {
    public static void main(String[] args) {
        String[] arr = {"ayaye", "uuu","yeye", "yemawoo", "ayaayaa"};

        System.out.println(solution(arr));

    }

    // 시도 1(성공) 아이디어 :
    // 발음 가능한 문자열을 리스트 basic 으로 먼저 저장해준다.
    // 이후 들어오는 배열 babbling 을 for 문을 통해 하나씩 검사해준다.
    // 연속으로 같은 발음을 할 수 없기 때문에 recent 라는 String 변수를 선언하고, 최근의 발음을 넣어준다.
    // String 의 .substring() 메서드를 이용해 앞의 2글자 혹은 3글자가 basic 안에 있는지 확인한 후,
    // 최근의 단어와 일치하는지를 확인한다. 일치시 발음 불가능
    // 일치하지 않는다면 최근 발음을 저장해주고 발음한 음절을 단어에서 빼준다.
    public static int solution(String[] babbling) {
        int answer = 0;

        // 발음 가능한 문자열을 배열로 저장
        String[] basic = {"aya", "ye", "woo", "ma"};

        List<String> strList = new ArrayList<>(Arrays.asList(basic));

        for(String step : babbling) {
            // 연솓된 발음을 할 수 없기 때문에 필요한 최근의 발음을 저장할 String 타입 변수 선언
            String recent = "";

            while(true) {
                if(step.length() == 0) {
                    answer++;
                    break;
                }
                else if(step.length() >= 2 && strList.contains(step.substring(0, 2))){
                    if(recent.equals(step.substring(0, 2))) {
                        break;
                    }else {
                        recent = step.substring(0, 2);
                        step = step.substring(2, step.length());
                    }
                }else if(step.length() >= 3 &&strList.contains(step.substring(0, 3))) {
                    if(recent.equals(step.substring(0, 3))) {
                        break;
                    }else {
                        recent = step.substring(0, 3);
                        step = step.substring(3, step.length());
                    }
                }else {
                    break;
                }
            }
        }
        return answer;
    }
}
