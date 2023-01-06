package practice;

// 약수 구하기

/**
 * 문제 설명
 * 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 제한사항
 * 1 ≤ n ≤ 10,000
 */

public class Practice_Divisor {
    public static void main(String[] args) {
        int index = 1;
        while(true) {
            long before1 = System.nanoTime();
            int[] arr1 = solution1(index);
            long after1 = System.nanoTime();

            long before2 = System.nanoTime();
            int[] arr2 = solution2(index);
            long after2 = System.nanoTime();

            if((after1 - before1) < 10 * (after2 - before2)) {
                System.out.println(index);
                break;
            }
            index++;
        }
//        long before1 = System.nanoTime();
//        int[] arr1 = solution1(7);
//        long after1 = System.nanoTime();
//
//        long before2 = System.nanoTime();
//        int[] arr2 = solution2(7);
//        long after2 = System.nanoTime();
//
//        System.out.println(after1 - before1);
//        System.out.println(after2 - before2);

    }

    public static int[] solution1(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i <= Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                if(i * i == n) {
                    list.add(i);
                }else {
                    list.add(i);
                    list.add(n/i);

                }
            }
        }

        list.sort(Comparator.naturalOrder());

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
    }
}
