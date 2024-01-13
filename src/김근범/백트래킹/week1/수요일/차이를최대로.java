package 김근범.백트래킹.week1.수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로 {

    static int N;
    static int[] arr;
    static int[] result;
    static boolean[] check;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        check = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        calculateMaxDiff(0);
        System.out.println(max);
    }

    private static void calculateMaxDiff(int index) {
        if(index == N) {
            int sum = 0;
            for(int i=0; i<N-1;i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }
            if(max < sum) max = sum;
            return;
        }

        for(int i = 0;i<N;i++){
            if(!check[i]) {
                check[i] = true;
                result[index] = arr[i];
                calculateMaxDiff(index+1);
                check[i] = false;
            }
        }
    }
}
