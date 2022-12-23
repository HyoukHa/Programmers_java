// 20221220 HHdev - hyoukhadev@gmail.com
/**
 * 문제 설명
 * XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다.
 * XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다.
 * 할인하는 제품은 하루에 하나씩만 구매할 수 있습니다.
 * 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
 *
 * 예를 들어, 정현이가 원하는 제품이 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개이며,
 * XYZ 마트에서 15일간 회원을 대상으로 할인하는 제품이 날짜 순서대로
 * 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나인 경우에 대해 알아봅시다.
 * 첫째 날부터 열흘 간에는 냄비가 할인하지 않기 때문에 첫째 날에는 회원가입을 하지 않습니다.
 * 둘째 날부터 열흘 간에는 바나나를 원하는 만큼 할인구매할 수 없기 때문에 둘째 날에도 회원가입을 하지 않습니다.
 * 셋째 날, 넷째 날, 다섯째 날부터 각각 열흘은 원하는 제품과 수량이 일치하기 때문에 셋 중 하루에 회원가입을 하려 합니다.
 *
 * 정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number,
 * XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때,
 * 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return 하는 solution 함수를 완성하시오.
 *
 * 가능한 날이 없으면 0을 return 합니다.
 */

/**
 * 제한사항
 * 1 ≤ want의 길이 = number의 길이 ≤ 10
 *      1 ≤ number의 원소 ≤ 10
 *      number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
 * 10 ≤ discount의 길이 ≤ 100,000
 * want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
 *      1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12
 */

public class Lv2_Discount_Event {
    public static void main(String[] args) {
        // Create Instance
        Solution solution = new Solution();

        // Test Case 1
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        // Test Case 2
//        String[] want = {"apple"};
//        int[] number = {10};
//        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        // Result
        System.out.println(solution.solution(want, number, discount));
    }
}

// 시도 1(성공) 아이디어 :
// 원하는 할인을 받을 수 있는 날짜를 return 해주어야 하므로,
// want 와 같은 길이의 배열 arr 생성
// 총 10일 이므로 할인날짜 안에서 시작날짜를 정해줄 for 문 작성
// 10일 안에서 원하는 할인상품이 있는지 체크하기위해 시작일 + 9번째 날까지 변화를 감지할 for 문 작성
// want 에 있는 목록이 있는지 확인하여 arr 에 want 와 같은 인덱스 자리에 1추가
// 각 항목이 number 보다 큰지 비교하여 클 경우 answer 에 1추가
// 그리고 새로운 가입일에 대한 체크를 위해 arr 을 초기화해준다

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 10일간의 할인 목록을 담을 배열 arr 생성 - 이때 길이는 want 와 같음
        int[] arr = new int[want.length];

        for(int i = 0 ; i < discount.length - 9 ; i++) {
            for(int j = i ; j < i+10 ; j++) {
                for(int k = 0 ; k < want.length ; k++) {
                    if(want[k].equals(discount[j])) {
                        arr[k]++;
                    }
                }
            }
            for(int j = 0 ; j < arr.length ; j++) {
                if(j == arr.length-1 && number[j] <= arr[j]) {
                    answer++;
                }else if(number[j] > arr[j]) {
                    break;
                }
            }
            arr = new int[want.length];
        }

        return answer;
    }
}
