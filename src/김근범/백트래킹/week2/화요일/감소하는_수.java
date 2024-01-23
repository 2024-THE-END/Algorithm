package 김근범.백트래킹.week2.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 감소하는_수 {
    static int N;
    static boolean[] check = new boolean[10];
    static int count = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=1;i<=10;i++){
            updateCount(0, 0, i);
            if(count >= N) return;
        }
        System.out.println(-1);
    }

    private static void updateCount(long num, int level, int depth) {
        if(level == depth) {
            count++;
            if(count == N) System.out.println(num);
            return;
        }

        for(int i=0;i<10;i++){
            if(!check[i] && (level==0 || num%10 > i) && !(depth >= 2 && level ==0 && i==0)) {
                check[i] = true;
                updateCount(num*10+i, level+1, depth);
                check[i] = false;
            }
        }
    }
}
