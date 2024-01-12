package 김창우.FirstWeek.thursday;

import java.util.*;

public class BJ2529 {
    static int k;
    static char[] sign;
    static boolean[] visited = new boolean[10];
    static List<String> answer = new ArrayList<>();//0으로 시작하는거 때문에 String으로 해야함..

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        sign = new char[k];
        for (int i = 0; i < k; i++) {
            sign[i] = sc.next().charAt(0);
        }
        dfs("", 0);
        Collections.sort(answer);
        //System.out.println(answer);//확인을 위한 코드
        System.out.println(answer.get(answer.size() - 1));//최대
        System.out.println(answer.get(0));//최소
    }

    private static void dfs(String num, int idx) {
        if (idx == k + 1) {
            answer.add(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (idx == 0 || (compare(num.charAt(num.length() - 1) - '0', i, sign[idx - 1]))) {
                visited[i] = true;
                dfs(num + i, idx + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean compare(int a, int b, char c) {//부등호 비교
        if (c == '<') return a < b;
        else return a > b;
    }
}
