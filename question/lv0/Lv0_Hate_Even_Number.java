package lv0;// tistory
/**
 * 문제 설명
 * 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ n ≤ 100
 */

import java.util.stream.IntStream;

public class Lv0_Hate_Even_Number {
    public static void main(String[] args) {
//        Solution solution = new Solution();

        System.out.println(solution(50));
    }

    public static int[] solution(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).filter(i -> i < n).toArray();
    }
}

//class Solution {
//    public int[] solution(int n) {
//        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).filter(i -> i < n).toArray();
//    }
//}
