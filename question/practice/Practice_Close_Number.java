package practice;

// 가까운 수

/**
 * 문제 설명
 * 정수 배열 array와 정수 n이 매개변수로 주어질 때,
 * array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.Arrays;

/**
 * 제한사항
 * 1 ≤ array의 길이 ≤ 100
 * 1 ≤ array의 원소 ≤ 100
 * 1 ≤ n ≤ 100
 * 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
 */

public class Practice_Close_Number {
    public static void main(String[] args) {
        int[] arr = {3, 10, 28};
        System.out.println(solution(arr, 20));
    }

    public static int solution(int[] array, int n) {
        int answer = 0, gap = 100;

        for(int each : array) {
            int tmp = Math.abs(n - each);
            if(tmp < gap) {
                gap = Math.abs(n-each);
                answer = each;
            }else if(tmp == gap){
                if(answer > each) {
                    answer = each;
                }
            }
        }

        return answer;
    }
}
