package practice;

// 합성수 찾기

/**
 * 문제 설명
 * 약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
 * 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ n ≤ 100
 */

public class Practice_Find_Synthetic_Number {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        int answer = 0;

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= Math.sqrt(i) ; j++) {
                if(i % j == 0) {
                    if(j != 1) {
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
