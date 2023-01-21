public class Tel_2 {
    public static void main(String[] args) {

    }

//    (1), (1, 2), (1, 2, 3), (1, 2, 3, 4)...
//    와 같이 나가는 수가있다. 0이상의 정수 k가 주어질때
//    k번째 수가 무엇인지를 구하시오


    public static long solution(long k) {

        int i = 1;
        while(true) {
            if(k <= i) {
                break;
            }
            k -= i;
            i++;
        }

        return k;
    }
}
