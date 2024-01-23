package 김근범.백트래킹.week2.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실 {
    static int N, K;
    static int count =0;
    static int[] kit;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }
        updateCount(0, 0);
        System.out.println(count);
    }

    private static void updateCount(int weight, int level) {
        if(level == N) {
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            if(!check[i] && weight + kit[i] - K >=0) {
                check[i] = true;
                updateCount(weight + kit[i] - K, level+1);
                check[i] = false;
            }
        }
    }

}
