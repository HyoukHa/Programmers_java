package practice;

// 직각삼각형 출력하기

/**
 * 문제 설명
 * "*"의 높이와 너비를 1이라고 했을 때, "*"을 이용해 직각 이등변 삼각형을 그리려고합니다.
 * 정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.
 */

/**
 * 제한사항
 * 1 ≤ n ≤ 10
 */

import java.util.Scanner;

public class Practice_Right_Triangle {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        for(int i = 0 ; i < n ; i++) {
//            for(int j = 0 ; j <= i ; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 코드 간략화는 가능하나 실제 수행시간의 차이는 크게 느껴지지않음.
        for(int i = 1 ; i <= n ; i++) {
            System.out.println("*".repeat(i));
        }
    }
}
