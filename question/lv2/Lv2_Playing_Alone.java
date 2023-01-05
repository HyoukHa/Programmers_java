package lv2;// tistory

/**
 * 문제 설명
 * 혼자서도 잘 노는 범희는 어느 날 방구석에 있는 숫자 카드 더미를 보더니 혼자 할 수 있는 재미있는 게임을 생각해냈습니다.
 *
 * 숫자 카드 더미에는 카드가 총 100장 있으며, 각 카드에는 1부터 100까지 숫자가 하나씩 적혀있습니다.
 * 2 이상 100 이하의 자연수를 하나 정해 그 수보다 작거나 같은 숫자 카드들을 준비하고,
 * 준비한 카드의 수만큼 작은 상자를 준비하면 게임을 시작할 수 있으며 게임 방법은 다음과 같습니다.
 *
 * 준비된 상자에 카드를 한 장씩 넣고, 상자를 무작위로 섞어 일렬로 나열합니다.
 * 상자가 일렬로 나열되면 상자가 나열된 순서에 따라 1번부터 순차적으로 증가하는 번호를 붙입니다.
 *
 * 그 다음 임의의 상자를 하나 선택하여 선택한 상자 안의 숫자 카드를 확인합니다.
 * 다음으로 확인한 카드에 적힌 번호에 해당하는 상자를 열어 안에 담긴 카드에 적힌 숫자를 확인합니다.
 * 마찬가지로 숫자에 해당하는 번호를 가진 상자를 계속해서 열어가며, 열어야 하는 상자가 이미 열려있을 때까지 반복합니다.
 *
 * 이렇게 연 상자들은 1번 상자 그룹입니다. 이제 1번 상자 그룹을 다른 상자들과 섞이지 않도록 따로 둡니다.
 * 만약 1번 상자 그룹을 제외하고 남는 상자가 없으면 그대로 게임이 종료되며, 이때 획득하는 점수는 0점입니다.
 *
 * 그렇지 않다면 남은 상자 중 다시 임의의 상자 하나를 골라 같은 방식으로 이미 열려있는 상자를 만날 때까지 상자를 엽니다.
 * 이렇게 연 상자들은 2번 상자 그룹입니다.
 *
 * 1번 상자 그룹에 속한 상자의 수와 2번 상자 그룹에 속한 상자의 수를 곱한 값이 게임의 점수입니다.
 *
 * 상자 안에 들어있는 카드 번호가 순서대로 담긴 배열 cards가 매개변수로 주어질 때,
 * 범희가 이 게임에서 얻을 수 있는 최고 점수를 구해서 return 하도록 solution 함수를 완성해주세요.
 */

/**
 * 제한사항
 * 2 ≤ cards의 길이 ≤ 100
 * cards의 원소는 cards의 길이 이하인 임의의 자연수입니다.
 * cards에는 중복되는 원소가 존재하지 않습니다.
 * cards[i]는 i + 1번 상자에 담긴 카드에 적힌 숫자를 의미합니다.
 */

import java.util.*;

public class Lv2_Playing_Alone {
    public static void main(String[] args) {
//        Solution solution = new Solution();

        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};

        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        int answer = 0;

        int n = cards.length;
        boolean[] isOpened = new boolean[n];
        List<Integer> groups = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            int now = i;
            int cnt = 0;
            while(!isOpened[now]) {
                isOpened[now] = true;
                cnt++;
                now = cards[now] - 1;
            }

            groups.add(cnt);
        }

        Collections.sort(groups, Collections.reverseOrder());

        if(groups.size() != 1) {
            answer = groups.get(0) * groups.get(1);
        }

        return answer;
    }
}

//class Solution {
//    public int solution(int[] cards) {
//        int answer = 0;
//
////        List<Integer> origin = Arrays.stream(cards).boxed().toList();
//        List<Integer> origin = Arrays.stream(cards).boxed().collect(Collectors.toList());
//
//        // 1번 상자그룹을 담을 리스트 arr1
//        List<Integer> arr1 = new ArrayList<>();
//        // 2번 상자그룹을 담을 리스트 arr2
//        List<Integer> arr2 = new ArrayList<>();
//
//        // 각 상자를 열었을 때의 상황들을 수행
//        for(int i = 0 ; i < origin.size() ; i++) {
//            System.out.println("시도" + (i + 1));
//            // 처음 선택한 상자에 담겨있는 번호를 1번 상자그룹에 담음
//            arr1.add(origin.get(i));
//
//            // 루프를 돌며 1번 상자그룹에 담겨있지 않으면 담음
//            while(!arr1.contains(origin.get(arr1.get(arr1.size()-1) - 1))) {
//                arr1.add(origin.get(arr1.get(arr1.size()-1) - 1));
//            }
//
//            List<Integer> temp = new ArrayList<>();
//
//            // 2번 상자의 최대 크기를 구하는 루프
//            for(int j = 0 ; j < origin.size() ; j++) {
//                if(!arr1.contains(origin.get(j))) {
//                    temp.add(origin.get(j));
//                    while(!arr1.contains(origin.get(temp.get(temp.size() - 1) - 1)) && !temp.contains(origin.get(temp.get(temp.size() - 1) - 1))) {
//                        temp.add(origin.get(temp.get(temp.size() - 1) - 1));
//                    }
//
//                    if(arr2.size() <= temp.size()) {
//                        arr2 = temp;
//                    }
//                    temp = new ArrayList<>();
//                }
//            }
//
//            if(answer < arr1.size() * arr2.size()) {
//                answer = arr1.size() * arr2.size();
//            }
//
//            arr1 = new ArrayList<>();
//            arr2 = new ArrayList<>();
//        }
//
//        return answer;
//    }
//}


// 다른사람의 풀이(코드분석)
// 문제를 잘 읽어보면 결국 이미 열려있는 상자가 나올 때 까지 반복하므로, 하나의 그룹으로 묶이면 어떤 상자를 먼저 골라도 같은 결과가 나온다.
// 이러한 관점에 초점을 맞춰보게되면, 한번 열린 상자는 다시 확인 할 필요가 없다.
// 그러므로 boolean 배열을 통해 열렸는지 확인하고, 각 그룹을 배열에 담아 정렬 한 후, 가장 큰 2개의 값을 추출하면 된다.

//class Solution {
//    public int solution(int[] cards) {
//        int answer = 0;
//
//        int n = cards.length;
//        boolean[] isOpened = new boolean[n];
//        List<Integer> groups = new ArrayList<>();
//
//        for(int i = 0 ; i < n ; i++) {
//            int now = i;
//            int cnt = 0;
//            while(!isOpened[now]) {
//                isOpened[now] = true;
//                cnt++;
//                now = cards[now] - 1;
//            }
//
//            groups.add(cnt);
//        }
//
//        Collections.sort(groups, Collections.reverseOrder());
//
//        if(groups.size() != 1) {
//            answer = groups.get(0) * groups.get(1);
//        }
//
//        return answer;
//    }
//}