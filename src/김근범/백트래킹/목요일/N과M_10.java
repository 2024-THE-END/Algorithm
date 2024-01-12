package 김근범.백트래킹.목요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_10 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        fetchSequences(0);
        System.out.print(sb);
    }

    private static void fetchSequences(int index) {
        if(index == M) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;

        for(int i=0;i<N;i++){
            if((index == 0 || (!check[i] && result[index-1] <= arr[i])) && prev != arr[i]) {
                result[index] = arr[i];
                prev = arr[i];
                check[i] = true;
                fetchSequences(index+1);
                check[i] = false;
            }
        }
    }
}
