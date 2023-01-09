package practice;

// 인덱스 바꾸기

/**
 * 문제 설명
 * 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때,
 * my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
 */

/**
 * 제한사항
 * 1 < my_string의 길이 < 100
 * 0 ≤ num1, num2 < my_string의 길이
 * my_string은 소문자로 이루어져 있습니다.
 * num1 ≠ num2
 */

import java.util.*;
import java.util.stream.Collectors;

public class Practice_Change_Index {
    public static void main(String[] args) {

    }

//    public static String solution(String my_string, int num1, int num2) {
//        String answer = "";
//
//        for(int i = 0 ; i < my_string.length() ; i++) {
//            if(i == num1) {
//                answer += Character.toString(my_string.charAt(num2));
//            }else if(i == num2) {
//                answer += Character.toString(my_string.charAt(num1));
//            }else {
//                answer += Character.toString(my_string.charAt(i));
//            }
//        }
//
//        return answer;
//    }

        public static String solution(String my_string, int num1, int num2) {
            List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());

            Collections.swap(list, num1, num2);
            return String.join("", list);
        }
}
