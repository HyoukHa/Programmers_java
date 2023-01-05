package lv2;// tistory
/**
 * 문제 설명
 * 철수와 영희는 선생님으로부터 숫자가 하나씩 적힌 카드들을 절반씩 나눠서 가진 후,
 * 다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하려고 합니다.
 *
 * 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
 * 영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
 *
 * 예를 들어, 카드들에 10, 5, 20, 17이 적혀 있는 경우에 대해 생각해 봅시다.
 * 만약, 철수가 [10, 17]이 적힌 카드를 갖고, 영희가 [5, 20]이 적힌 카드를 갖는다면 두 조건 중 하나를 만족하는 양의 정수 a는 존재하지 않습니다.
 * 하지만, 철수가 [10, 20]이 적힌 카드를 갖고, 영희가 [5, 17]이 적힌 카드를 갖는다면, 철수가 가진 카드들의 숫자는 모두 10으로 나눌 수 있고,
 * 영희가 가진 카드들의 숫자는 모두 10으로 나눌 수 없습니다.
 * 따라서 철수와 영희는 각각 [10, 20]이 적힌 카드, [5, 17]이 적힌 카드로 나눠 가졌다면 조건에 해당하는 양의 정수 a는 10이 됩니다.
 *
 * 철수가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayA와 영희가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayB가 주어졌을 때,
 * 주어진 조건을 만족하는 가장 큰 양의 정수 a를 return하도록 solution 함수를 완성해 주세요.
 * 만약, 조건을 만족하는 a가 없다면, 0을 return 해 주세요.
 */

/**
 * 제한사항
 *
 * 1 ≤ arrayA의 길이 = arrayB의 길이 ≤ 500,000
 * 1 ≤ arrayA의 원소, arrayB의 원소 ≤ 100,000,000
 * arrayA와 arrayB에는 중복된 원소가 있을 수 있습니다.
 */

import java.util.*;

public class Lv2_Split_Number_Card {
    public static void main(String[] args) {
//        Solution solution = new Solution();

//        int[] arrayA = {10, 17};
//        int[] arrayB = {5, 20};

//        int[] arrayA = {10, 20};
//        int[] arrayB = {5, 17};

        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};

//        long before = System.nanoTime();
//        System.out.println(solution.solution(arrayA, arrayB));
//        long after = System.nanoTime();
//        long diff = after - before;
//        System.out.println(diff);
//        System.out.println(false ? 1 : 2);

        String a = "abcde";
        String answer = "";
        int n = 3;

        for(int i = 0 ; i < a.length() ; i++) {
            for(int j = 0 ; j < n ; j++) {
                answer += Character.toString(a.charAt(i));
            }
        }
        System.out.println(answer);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int aMin = getMin(arrayA);
        int aGcd = getArraysGcd(arrayA, aMin);

        int bMin = getMin(arrayB);
        int bGcd = getArraysGcd(arrayB, bMin);

        answer = getAnswer(aGcd, arrayB, answer);
        answer = getAnswer(bGcd, arrayA, answer);

        return answer;
    }

    private static int getAnswer(int gcd, int[] array, int answer) {
        for (int num : array) {
            if (num % gcd == 0) {
                return Math.max(answer, 0);
            }
        }
        return Math.max(answer, gcd);
    }

    private static int getMin(int[] array) {
        return Arrays.stream(array)
                .reduce(Math::min)
                .getAsInt();
    }

    private static int getArraysGcd(int[] array, int min) {
        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (isGcd(array, i)) {
                gcd = i;
            }
        }
        return gcd;
    }

    private static boolean isGcd(int[] array, int i) {
        for (int num : array) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }
}

//class Solution {
//    public int solution(int[] arrayA, int[] arrayB) {
//        for(int a : arrayA) {
//            System.out.println(a);
//        }
//
//        int[] abc = {1, 2};
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.toArray();
//
//        int answer = 0, gcdA = arrayA[0], gcdB = arrayB[0];
//
//        if(arrayA.length == 1) {
//            gcdA = arrayA[0];
//        }else {
//            for(int i = 0 ; i < arrayA.length ; i++) {
//                gcdA = getGCD(gcdA, arrayA[i]);
//            }
//        }
//
//        if(arrayB.length == 1) {
//            gcdB = arrayB[0];
//        }else {
//            for(int i = 0 ; i < arrayB.length ; i++) {
//                gcdB = getGCD(gcdB, arrayB[i]);
//            }
//        }
//
//        List<Integer> A = new ArrayList<>(), B = new ArrayList<>();
//
//        for(int i = 1 ; i < Math.sqrt(gcdA) ; i++) {
//            if(gcdA % i == 0) {
//                if(i * i == gcdA) {
//                    A.add(i);
//                }else {
//                    A.add(i);
//                    A.add(gcdA / i);
//                }
//            }
//        }
//
//        A.remove(Integer.valueOf(1));
//        Collections.sort(A, Collections.reverseOrder());
//
//        for(int step : A) {
//            boolean progress = true;
//            for(int each : arrayB) {
//                if(progress) {
//                    if(each % step == 0) {
//                        progress = false;
//                        break;
//                    }
//                }
//            }
//            if(progress) {
//                answer = step;
//                break;
//            }
//        }
//
//        for(int i = 1 ; i < Math.sqrt(gcdB) ; i++) {
//            if(gcdB % i == 0) {
//                if(i * i == gcdB) {
//                    B.add(i);
//                }else {
//                    B.add(i);
//                    B.add(gcdB / i);
//                }
//            }
//        }
//
//        B.remove(Integer.valueOf(1));
//        Collections.sort(B, Collections.reverseOrder());
//
//        for(int step : B) {
//            boolean progress = true;
//            for(int each : arrayA) {
//                if(progress) {
//                    if(each % step == 0) {
//                        progress = false;
//                        break;
//                    }
//                }
//            }
//            if(progress) {
//                if(answer < step) {
//                    answer = step;
//                }
//                break;
//            }
//        }
//        System.out.println("gcdA : " + gcdA);
//        System.out.println("gcdB : " + gcdB);
//
//
//        return answer;
//    }
//
//    public int getGCD(int num1, int num2) {
//        if(num1 % num2 == 0) {
//            return num2;
//        }
//        return getGCD(num2, num1 % num2);
//    }
//}

//class Solution {
//    public int solution(int[] arrayA, int[] arrayB) {
//        int answer = 0;
//
//        int aMin = getMin(arrayA);
//        int aGcd = getArraysGcd(arrayA, aMin);
//
//        int bMin = getMin(arrayB);
//        int bGcd = getArraysGcd(arrayB, bMin);
//
//        answer = getAnswer(aGcd, arrayB, answer);
//        answer = getAnswer(bGcd, arrayA, answer);
//
//        return answer;
//    }
//
//    private static int getAnswer(int gcd, int[] array, int answer) {
//        for (int num : array) {
//            if (num % gcd == 0) {
//                return Math.max(answer, 0);
//            }
//        }
//        return Math.max(answer, gcd);
//    }
//
//    private static int getMin(int[] array) {
//        return Arrays.stream(array)
//                .reduce(Math::min)
//                .getAsInt();
//    }
//
//    private static int getArraysGcd(int[] array, int min) {
//        int gcd = 1;
//        for (int i = 2; i <= min; i++) {
//            if (isGcd(array, i)) {
//                gcd = i;
//            }
//        }
//        return gcd;
//    }
//
//    private static boolean isGcd(int[] array, int i) {
//        for (int num : array) {
//            if (num % i != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}