package lv0;// tistory
/**
 * 문제 설명
 * 문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다.
 * 이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때,
 * A를 밀어서 B가 될 수 있다면 몇 번 밀어야 하는지 횟수를 return하고
 * 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
 */

/**
 * 제한사항
 * 0 < A의 길이 = B의 길이 < 100
 * A, B는 알파벳 소문자로 이루어져 있습니다.
 */

public class Lv0_Push_String {
    public static void main(String[] args) {
        String A = "hello", B = "ohell";
//        String A = "apple", B = "elppa";
        System.out.println(solution(A, B));
    }

    public static int solution(String A, String B) {
        int answer = 0;

        for(int i = 0 ; i <= A.length() ; i++) {
            if(A.equals(B)) {
                return answer;
            }
            answer++;
            System.out.print(A + "   ");
            String tmp = Character.toString(A.charAt(A.length() - 1));
            A = tmp + A.substring(0, A.length()-1);
            System.out.println(A + "   " + B);
        }

        return -1;
    }
}

//class Solution {
//    public int solution(String A, String B) {
//        int answer = -1;
//        if(A.equals(B)) {
//            return 1;
//        }
//
//        for(int i = 0 ; i < A.length() ; i++) {
//            String tmp = Character.toString(A.charAt(0));
//            A = A.substring(1);
//            A += tmp;
//            if(A.equals(B)) {
//                return 1;
//            }
//        }
//
//        System.out.println(A + "   " + B);
//
//        return answer;
//    }
//}