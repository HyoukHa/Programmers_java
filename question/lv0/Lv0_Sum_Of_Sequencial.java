package lv0;// tistory
/**
 * 문제 설명
 * 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다.
 * 두 정수 num과 total이 주어집니다.
 * 연속된 수 num개를 더한 값이 total이 될 때,
 * 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
 */

/**
 * 제한사항
 * 1 ≤ num ≤ 100
 * 0 ≤ total ≤ 1000
 * num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
 */

import java.util.ArrayList;
import java.util.List;

public class Lv0_Sum_Of_Sequencial {
    public static void main(String[] args) {
//        int num = 3, total = 12;
        int num = 5, total = 15;
//        int num = 4, total = 14;
//        int num = 5, total = 5;

        System.out.println(solution(num, total));
    }

    public static int[] solution(int num, int total) {
        List<Integer> test = new ArrayList<>();
        int start = (total - (num * (num - 1) / 2))/num;

        for(int i = 0 ; i < num ; i++) {
            test.add(start + i);
        }

        return test.stream().mapToInt(i -> i).toArray();
    }
}

//class Solution {
//    public int[] solution(int num, int total) {
//        ArrayList<Integer> test = new ArrayList<>();
//        int start = (total - (num * (num - 1) / 2))/num;
//
//        for(int i = 0 ; i < num ; i++) {
//            test.add(start + i);
//        }
//
//        int[] answer = test.stream().mapToInt(i -> i).toArray();
//
//        return answer;
//    }
//}