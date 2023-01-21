import java.util.ArrayList;
import java.util.Arrays;

public class Tel_1 {
    public static void main(String[] args) {
        int[][] arr = {{4, 2, 9}, {1, 3, 5}, {6, 8, 7}}; // >> 3
//        int[][] arr ={
//                {1, 19, 20, 8, 25},
//                {21, 4, 3, 17, 24},
//                {12, 5, 6, 16, 15},
//                {11, 18, 10, 9, 23},
//                {7, 13, 14, 22, 2}
//        };  // >> 2

        System.out.println(solution(arr));

    }

    public static int solution(int[][] matrix){
        int[][] clone = matrix;
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < clone.length ; i++) {
            Arrays.sort(clone[i]);
            arr.add(clone[i][(clone[i].length-1)/2]);
        }

        clone = matrix;
        for(int i = 0 ; i < clone.length ; i++) {
            int[] temp = new int[clone.length];
            for(int j = 0 ; j < clone.length ; j++) {
                System.out.println(clone[j][i]);
                temp[j] = clone[j][i];
            }
            Arrays.sort(temp);
            System.out.println(temp[(clone.length-1)/2]);
            if(arr.contains(temp[(clone.length-1)/2])) {
                answer += 1;
            }
        }

        return answer;
    }
}
