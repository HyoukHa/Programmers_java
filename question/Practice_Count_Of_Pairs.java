// tistory

/**
 * 문제 설명
 * 순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다.
 * 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ n ≤ 1,000,000
 */

public class Practice_Count_Of_Pairs {
    public static void main(String[] args) {
//        Solution solution = new Solution();

//        System.out.println(solution.solution(20)); // 6
//        System.out.println(solution.solution(100)); // 9

        System.out.println(solution(20)); // 6
        System.out.println(solution(100)); // 9
    }

    public static int solution(int n) {
        int answer = 0;

        for(int i = 1 ; i <= Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                if(i * i == n) {
                    answer += 1;
                }else {
                    answer += 2;
                }
            }
        }

        return answer;
    }
}

//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//
//        for(int i = 1 ; i <= Math.sqrt(n) ; i++) {
//            if(n % i == 0) {
//                if(i * i == n) {
//                    answer += 1;
//                }else {
//                    answer += 2;
//                }
//            }
//        }
//
//        return answer;
//    }
//}
