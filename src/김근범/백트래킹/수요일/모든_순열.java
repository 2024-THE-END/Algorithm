package 김근범.백트래킹.수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든_순열 {

    static int N;
    static int[] arr;
    static int[] result;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        check = new boolean[N];
        for(int i=1;i<=N;i++){
            arr[i-1] = i;
        }
        fetchSequences(0);
        System.out.print(sb);
    }

    private static void fetchSequences(int index) {
        if(index == N) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<N;i++){
            if(!check[i]) {
                check[i] = true;
                result[index] = arr[i];
                fetchSequences(index+1);
                check[i] = false;
            }
        }
    }
}
