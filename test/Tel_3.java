public class Tel_3 {
    public static void main(String[] args) {
        System.out.println(solution("2220281"));
        System.out.println(solution("44335550555666"));
    }
    // 전화 다이얼

    public static String solution(String s) {
        String answer = "";
        int index = 0;
        String[][] arr = {
                {".", "Q", "Z"},
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"},
                {"J", "K", "L"},
                {"M", "N", "O"},
                {"P", "R", "S"},
                {"T", "U", "V"},
                {"W", "X", "Y"}
        };
        String temp = "";
        for(int i = 0 ; i < s.length() ; i++) {
            temp += Character.toString(s.charAt(i));
            if(temp.equals("0")) {
                temp = "";
                continue;
            }

            if(i < s.length() - 1) {
                if(temp.length() > 2 || !Character.toString(s.charAt(i + 1)).equals(Character.toString(s.charAt(i)))) {
                    answer += arr[Integer.parseInt(Character.toString(temp.charAt(0)))-1][temp.length()-1];
                    temp = "";
                }
            }
        }
        answer += arr[Integer.parseInt(Character.toString(temp.charAt(0)))-1][temp.length()-1];

        return answer;
    }
}
