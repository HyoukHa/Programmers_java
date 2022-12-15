import java.util.ArrayList;

/**
 * 문제 설명
 * 햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다.
 * 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
 * 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다.
 * 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
 * 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며,
 * 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
 *
 * 예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때,
 * 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고,
 * 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다.
 * 즉, 2개의 햄버거를 포장하게 됩니다.
 *
 * 상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때,
 * 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
 */

/**
 * 제한사항
 *
 * 1 ≤ ingredient의 길이 ≤ 1,000,000
 * ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
 */

public class Lv1_Hamburger {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(solution(ingredient));
    }

// 시도 1(실패) 아이디어 :
// 주어진 배열을 문자열로 저장한 후, "1231"이라는 문자열을 공백으로 치환,
// 이후 최초 길이에서 최종 길이를 뺀 값을 4로나누어 해당 문자열이 몇번 제거되었는지 확인하는 방법

// 실패 사유 : 시간 초과 - 이유 : 최대길이가 1,000,000인 배열을 for문을 돌리는 것도, 그 안에서 while 문을 돌리는 것도 너무나 큰 시간이 소요됨
//    public static int solution(int[] ingredient) {
//        int answer = 0;
//
//        String str = "";
//        String result = "";
//
//        for(int i : ingredient) {
//            str += i;
//        }
//
//        while(str != result) {
//            result = str;
//            str = str.replace("1231", "");
//            System.out.println("result : " + result);
//            System.out.println("string : " + str);
//        }
//
//        answer = (ingredient.length - str.length())/4;
//
//        return answer;
//    }

// 시도 2(성공) 아이디어 :
// 배열의 첫번째 값부터 순차적으로 다른 배열(original)에 집어넣는다.
// 이때 비교할 배열(comp)을 만들어 준 후, 뒤의 4자리를 새로운 배열(temp)에 넣고 equals()를 통해 비교한다.
// true 가 출력될 시 제어문을 통해 맨뒤 4자리의 값을 제거해주고, answer 의 값을 1 증가시켜준다.

//    public static int solution(int[] ingredient) {
//        int answer = 0;
//        ArrayList<Integer> original = new ArrayList<>();
//        ArrayList<Integer> comp = new ArrayList<>();
//
//        comp.add(1);
//        comp.add(2);
//        comp.add(3);
//        comp.add(1);
//
//        for(int num : ingredient) {
//            original.add(num);
//
//            if(original.size() >= 4) {
//                ArrayList<Integer> temp = new ArrayList<>();
//
//                temp.add(original.get(original.size()-4));
//                temp.add(original.get(original.size()-3));
//                temp.add(original.get(original.size()-2));
//                temp.add(original.get(original.size()-1));
//
//                if(comp.equals(temp)) {
//                    for(int i = 0 ; i < 4 ; i++) {
//                        original.remove(original.size()-1);
//                    }
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
//    }

    // 시도 3(성공-개선) 아이디어 :
    // 시도 2의 방법에서 반복문에서 사용하던 임시 배열(temp)를 없애 수행시간을 감소시켰다.
    // 이 방법을 통해 temp 라는 배열의 초기화, 할당이 줄어 메모리 성능적인 개선을 기대할 수 있다.
    public static int solution(int[] ingredient) {
        int answer = 0;

        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> comp = new ArrayList<>();

        comp.add(1);
        comp.add(2);
        comp.add(3);
        comp.add(1);

        for(int num : ingredient) {
            original.add(num);

            if(original.size() >= 4 && 
            original.get(original.size()-4) == 1 &&
            original.get(original.size()-3) == 2 &&
            original.get(original.size()-2) == 3 &&
            original.get(original.size()-1) == 1) {
                for(int i = 0 ; i < 4 ; i++) {
                    original.remove(original.size()-1);
                }
                answer++;
            }
        }

        return answer;
    }
}
