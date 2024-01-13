package 김근범.백트래킹.week1.수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_7 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
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

        for(int i=0;i<N;i++){
            result[index] = arr[i];
            fetchSequences(index+1);
        }
    }
}
