package lv0;// tistory
/**
 * 문제 설명
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
 * 최빈값이 여러 개면 -1을 return 합니다.
 */

/**
 * 제한사항
 * 0 < array의 길이 < 100
 * 0 ≤ array의 원소 < 1000
 */

import java.util.*;
import java.util.stream.Collectors;

public class Lv0_Frequency_Value {
    public static void main(String[] args) {
//        Solution solution = new Solution();

        int[] arr = {1, 2, 3, 3, 3, 4};
//        int[] arr = {1, 1, 2, 2};
//        int[] arr = {1};

        System.out.println(solution(arr));
    }

    public static int solution(int[] array) {
        int answer = 0;
        int Feq = 0;
        boolean dup = false;

        for(int each : array) {
            if(answer == each) {
                continue;
            }
            int freq = Collections.frequency(Arrays.stream(array).boxed().collect(Collectors.toList()), each);

            if(Feq == freq) {
                dup = true;
            }else if(Feq < freq) {
                answer = each;
                Feq = freq;
                dup = false;
            }
        }

        if(dup) {
            return -1;
        }else {
            return answer;
        }
    }
}

//class Solution {
//    public int solution(int[] array) {
//        int answer = 0;
//        int Feq = 0;
//        boolean dup = false;
//
//        for(int each : array) {
//            if(answer == each) {
//                continue;
//            }
//            int freq = Collections.frequency(Arrays.stream(array).boxed().collect(Collectors.toList()), each);
//
//            if(Feq == freq) {
//                dup = true;
//            }else if(Feq < freq) {
//                answer = each;
//                Feq = freq;
//                dup = false;
//            }
//        }
//
//        if(dup) {
//            return -1;
//        }else {
//            return answer;
//        }
//    }
//}
