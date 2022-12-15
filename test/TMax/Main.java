import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = {10};
        int[] B = {2};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] preferences, int[] coffees) {
        int answer = 0;

        Arrays.sort(preferences);
        Arrays.sort(coffees);

        for(int i = 0 ; i < preferences.length ; i++) {
            int result = coffees[i] - preferences[i];
            System.out.print(coffees[i] + " - " + preferences[i] + " = ");
            System.out.println(result);
            if(result <= 0) {
                continue;
            }
            answer += coffees[i] - preferences[i];
        }

        return answer;
    }
}
