package practice;

// A로 B 만들기

/**
 * 문제 설명
 * 문자열 before와 after가 매개변수로 주어질 때,
 * before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
 */

import java.util.Arrays;

/**
 * 제한사항
 * 0 < before의 길이 == after의 길이 < 1,000
 * before와 after는 모두 소문자로 이루어져 있습니다.
 */

public class Practice_Is_Covertable {
    public static void main(String[] args) {
        System.out.println(solution("hello", "olleh"));
    }

    public static int solution(String before, String after) {
        int[] beforeArr = new int[26], afterArr = new int[26];

        for(int i = 0 ; i < before.length() ; i++) {
            beforeArr[before.charAt(i) - 97]++;
            afterArr[after.charAt(i) - 97]++;
        }

        if(Arrays.equals(beforeArr, afterArr)) {
            return 1;
        }

        return 0;
    }
}
