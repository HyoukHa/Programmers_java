package practice;

// 세균 증식

/**
 * 문제 설명
 * 어떤 세균은 1시간에 두배만큼 증식한다고 합니다.
 * 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때,
 * t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 1 ≤ n ≤ 10
 * 1 ≤ t ≤ 15
 */

public class Practice_Bacterial_Growth {
    public static void main(String[] args) {
        System.out.println(solution(2, 10)); // 2048
        System.out.println(solution(7, 15)); // 229376

    }

//    public static int solution(int n, int t) {
//        return n * (int)Math.pow(2, t);
//    }

    public static int solution(int n, int t) {
        return n << t;
    }
}
