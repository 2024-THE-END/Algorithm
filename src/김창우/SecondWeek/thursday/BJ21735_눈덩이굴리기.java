package 김창우.SecondWeek.thursday;

import java.util.Scanner;

public class BJ21735_눈덩이굴리기 {
    static int[] num=new int[100];
    static int N, M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
        }

        dfs(0, 1, 0);
        System.out.println(max);
    }

    private static void dfs(int t, int size, int pos) {
        if (t == M || pos >= N) {
            max = Math.max(size, max);
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                dfs(t + 1, size + num[pos + i], pos + i);
            } else {
                dfs(t + 1, (size / 2) + num[pos + i], pos + i);
            }
        }
    }
}
