package practice;

// 문자열안에 문자열

/**
 * 문제 설명
 * 문자열 str1, str2가 매개변수로 주어집니다.
 * str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ str1의 길이 ≤ 100
 * 1 ≤ str2의 길이 ≤ 100
 */

public class Practice_Contain_String {
    public static void main(String[] args) {
//        String str1 = "ab6CDE443fgh22iJKlmn1o", str2 = "6CD";
        String str1 = "ppprrrogrammers", str2 = "pppp";
    }

    public static int solution(String str1, String str2) {
        if(str1.contains(str2)) {
            return 1;
        }else {
            return 2;
        }
    }
}

//class Solution {
//    public int solution(String str1, String str2) {
//        if(str1.contains(str2)) {
//            return 1;
//        }else {
//            return 2;
//        }
//    }
//}
