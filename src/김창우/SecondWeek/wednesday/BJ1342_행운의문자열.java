package 김창우.SecondWeek.wednesday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1342_행운의문자열 {
    static String str;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        visited = new boolean[str.length()];
        count = 0;
        combi(0, "");
        System.out.println(count);
    }

    private static void combi(int depth, String current) {
        if (depth == str.length()) {
            if (check(current)) {
                count++;
            }
            return;
        } else {
            HashMap<Character, Boolean> used = new HashMap<>();
            //중복 검사해야한다..
            for (int i = 0; i < str.length(); i++) {
                if (!visited[i] && !used.containsKey(str.charAt(i))) {
                    visited[i] = true;
                    used.put(str.charAt(i), true);
                    combi(depth + 1, current + str.charAt(i));
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean check(String current) {
        for (int i = 0; i < current.length() - 1; i++) {
            if (current.charAt(i) == current.charAt(i + 1)) {
                return false; // 연속된 두 문자가 같으면 false
            }
        }
        return true;
    }
}
