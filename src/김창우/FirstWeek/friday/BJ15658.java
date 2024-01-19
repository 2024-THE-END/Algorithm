package 김창우.FirstWeek.friday;

import java.util.Scanner;

public class BJ15658 {
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int numbers[];
    public static int operators[];
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

       operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if(i==0) dfs(num + numbers[idx], idx + 1);
                else if (i==1) dfs(num - numbers[idx], idx + 1);
                else if (i==2) dfs(num * numbers[idx], idx + 1);
                else dfs(num / numbers[idx], idx + 1);
                operators[i]++;
            }
        }
    }
}
