package practice;

// k의 개수

/**
 * 문제 설명
 * 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
 * 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.stream.IntStream;

/**
 * 제한사항
 * 1 ≤ i < j ≤ 100,000
 * 0 ≤ k ≤ 9
 */

public class Practice_Count_Of_K {
    public static void main(String[] args) {
        System.out.println(solution(1, 13,1));
    }

    public static int solution(int i, int j, int k) {
        int answer = 0;

        IntStream.rangeClosed(i, j).map(String[]::)

        return answer;
    }
}
