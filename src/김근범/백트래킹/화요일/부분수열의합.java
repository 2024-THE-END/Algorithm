package 김근범.백트래킹.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {

    static int N, S;
    static int[] num;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[N];
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        fetchResult(0, 0);
        System.out.println(S==0 ? result -1 : result);
    }

    private static void fetchResult(int index, int sum) {
        if(index == N) {
            if(sum == S) result ++;
            return;
        }
        fetchResult(index+1, sum);
        fetchResult(index+1, sum+num[index]);
    }
}
