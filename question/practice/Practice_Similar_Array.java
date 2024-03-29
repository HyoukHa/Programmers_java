package practice;// tistory

/**
 * 문제 설명
 * 두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ s1, s2의 길이 ≤ 100
 * 1 ≤ s1, s2의 원소의 길이 ≤ 10
 * s1과 s2의 원소는 알파벳 소문자로만 이루어져 있습니다
 * s1과 s2는 각각 중복된 원소를 갖지 않습니다.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice_Similar_Array {
    public static void main(String[] args) {

        String[] s1 = {"a", "b", "c"}, s2 = {"com", "b", "d", "p", "c"};

        System.out.println(solution(s1, s2));
    }

    public static int solution(String[] s1, String[] s2) {
        int answer = 0;
        List<String> list = Arrays.stream(s2).collect(Collectors.toList());

        for(String each : s1) {
            if(list.contains(each)) {
                answer++;
            }
        }

        return answer;
    }
}