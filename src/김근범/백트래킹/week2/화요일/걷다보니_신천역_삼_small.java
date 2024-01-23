package 김근범.백트래킹.week2.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 걷다보니_신천역_삼_small {
    static int N;
    static int[] num = {0, 1, 2};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        updateCount(0, 0);
        System.out.println(count);
    }

    private static void updateCount(int sum, int level) {
        if(level == N) {
            if(sum % 3 == 0) count++;
            return;
        }

        for(int i=0;i<3;i++) {
            int temp = sum * 10 + i;
            if(temp==0) continue;
            updateCount(temp, level+1);
        }
    }
}
