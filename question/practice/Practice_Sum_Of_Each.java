package practice;

// 자리수 더하기

/**
 * 문제 설명
 * 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
 */

/**
 * 제한사항
 * 0 ≤ n ≤ 1,000,000
 */
public class Practice_Sum_Of_Each {
    public static void main(String[] args) {
//        Solution solution = new Solution();

        System.out.println(solution(1234));
        System.out.println(solution(930211));
    }

    public static int solution(int n) {
        int answer = 0;

        while(true) {
            if(n < 10) {
                answer += n;
                break;
            }else {
                answer += n % 10;
                n = n / 10;
            }
        }

        return answer;
    }
}

//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//
//        while(true) {
//            if(n < 10) {
//                answer += n;
//                break;
//            }else {
//                answer += n % 10;
//                n = n / 10;
//            }
//        }
//
//        return answer;
//    }
//}
