package practice;

// n의 배수 고르기

/**
 * 문제 설명
 * 정수 n과 정수 배열 numlist가 매개변수로 주어질 때,
 * numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ n ≤ 10,000
 * 1 ≤ numlist의 크기 ≤ 100
 * 1 ≤ numlist의 원소 ≤ 100,000
 */

import java.util.Arrays;

public class Practice_Choose_Multiple {
    public static void main(String[] args) {
//        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
//        System.out.println(solution(3, numlist));

//        int[] numlist = {1, 9 ,3, 10, 13, 5};
//        System.out.println(5, numlist);

        int[] numlist = {2, 100, 120, 600, 12, 12};
        System.out.println(solution(12, numlist));
    }

    public static int[] solution(int n, int[] numlist) {
//        return Arrays.stream(numlist).boxed().filter(i -> i % n == 0).toArray();
        return Arrays.stream(numlist).filter(i -> i % n == 0).toArray();
    }

//    public static int[] solution(int n, int[] numlist) {
//        List<Integer> list = new ArrayList<>();
//
//        for(int each : numlist) {
//            if(each % n == 0) {
//                list.add(each);
//            }
//        }
//
//        return list.stream().mapToInt(i -> i).toArray();
//    }
}
