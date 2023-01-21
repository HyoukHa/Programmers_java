import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tel_4 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3};
        int[] result = solution(arr);
    }

    public static int[] solution(int[] grade) {
        int[] answer = new int[grade.length];
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0, order = 1, count = 0;
        while(true) {
            if(IntStream.of(grade).sum() == 0) {
                break;
            }

            for(int i = 0 ; i < grade.length ; i++) {
                if(max < grade[i]) {
                    max = grade[i];
                }
                System.out.println(max);
            }

            for(int i = 0 ; i < grade.length ; i++) {
                if(grade[i] == max) {
                    list.add(i);
                    grade[i] = 0;
                    count += 1;
                }
            }

            for(int i : list) {
                answer[i] = order;
            }

            list = new ArrayList<>();
            order += count;
            count = 0;
            max = 0;
        }

        return answer;
    }

    public static void printArr(int[] arr) {
        System.out.print("[");
        for(int each : arr) {
            System.out.println(" " + each + " ");
        }
        System.out.println("]");
    }
}
