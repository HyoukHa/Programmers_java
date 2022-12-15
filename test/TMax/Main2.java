/**
 * TestCase

 [30, 30, 30, 30] /
 [
 [1, 2, 10],
 [2, 3, 20],
 [3, 4, 5],
 [3, 4, 30]
 ] / [1] >>> [0, 20, 15, 55]

 [30, 30, 30, 30] /
 [
 [1, 2, 10],
 [2, 3, 20],
 [3, 4, 5],
 [3, 4, 30]
 ] / [2, 3] >>> [20, 0, 0, 40]

 [40, 30, 50] /
 [
 [1, 3, 20],
 [2, 1, 10],
 [3, 1, 45],
 [2, 3, 10],
 [1, 3, 35],
 [2, 1, 5],
 [3, 1, 10],
 [3, 2, 5]
 ] / [2] >>> [40, 5, 45]

 [100, 1, 1, 1, 1] /
 [
 [1, 2, 100],
 [2, 3, 101],
 [3, 4, 102],
 [4, 5, 103],
 [5, 1, 104]
 ] / [1] >>> [4, 0, 0, 0, 0]
 */
public class Main2 {
    public static void main(String[] args) {
        int[] A = {30, 30, 30, 30};
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {3, 4, 5}, {3, 4, 30}};
        int[] C = {1};
        System.out.println(solution(A, B, C));
        System.out.println("기대 결과 : {0, 20, 15, 55}");
    }
    // [0, 20, 15, 55]

    public static int[] solution (int balance[], int[][] transaction, int[] abnormal) {
        int[] answer = new int[balance.length];

        for(int i = 0 ; i < balance.length ; i++) {
            answer[i] = balance[i];
            System.out.println("balance[" + i + "] : " + answer[i]);
        }

        for(int i = 0 ; i < transaction.length ; i++) {
            balance[transaction[i][0] - 1] -= transaction[i][2];
            balance[transaction[i][1] - 1] += transaction[i][2];
        }

        for(int i = 0 ; i < abnormal.length ; i++) {
            System.out.println("roof" + (i+1));
            int[] min = new int[balance.length];
            min[abnormal[i] - 1] = answer[i];

            for(int j = 0 ; j < transaction.length ; j++) {
                min[transaction[j][0]-1] -= transaction[j][2];
                min[transaction[j][1]-1] += transaction[j][2];

                if(min[transaction[j][0] - 1] - transaction[j][2] < 0) {
                    min[transaction[j][0] - 1] = 0;
                }

//                if(transaction[j][0] == abnormal[i]) {
//                    min[transaction[j][0]-1] -= transaction[j][2];
//                    min[transaction[j][1]-1] += transaction[j][2];
//                }
//
//                if(transaction[j][1] == abnormal[i]) {
//                    min[transaction[j][0]-1] += transaction[j][2];
//                    min[transaction[j][1]-1] -= transaction[j][2];
//                }
            }

            for(int j = 0 ; j < min.length ; j++) {
                System.out.println(min[j]);
                balance[j] -= min[j];
            }
        }

        for(int i = 0 ; i < balance.length ; i++) {
            answer[i] = balance[i];
            System.out.println("balance[" + i + "] : " + answer[i]);
        }

        return answer;
    }
}
