package lv2;// tistory

/**
 * 문제 설명
 * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
 * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
 *
 * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 *
 * word의 길이는 1 이상 5 이하입니다.
 * word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
 */

import java.util.ArrayList;

public class Lv2_Dictionary {
    public static void main(String[] args) {
//        Solution solution = new Solution();

        String word = "AAAAE"; // 6
//        String word = "AAAE"; // 10
//        String word = "I"; // 1563
//        String word = "EIO";
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = 0;
        ArrayList<String> spell = new ArrayList<>();
        int[] digit = {781, 156, 31, 6, 1};

        spell.add("A");
        spell.add("E");
        spell.add("I");
        spell.add("O");
        spell.add("U");

        for(int i = 0 ; i < word.length() ; i++) {
            answer += digit[i] * spell.indexOf(Character.toString(word.charAt(i))) + 1;
        }

        return answer;
    }
}

// 시도 1(성공)
// 장장 1시간의 고민끝에 패턴을 찾아 해결하였다.....
//class Solution {
//    public int solution(String word) {
//        int answer = 0;
//        ArrayList<String> spell = new ArrayList<>();
//        int[] digit = {781, 156, 31, 6, 1};
//
//        spell.add("A");
//        spell.add("E");
//        spell.add("I");
//        spell.add("O");
//        spell.add("U");
//
//        for(int i = 0 ; i < word.length() ; i++) {
//            answer += digit[i] * spell.indexOf(Character.toString(word.charAt(i))) + 1;
//        }
//
//        return answer;
//    }
//}
