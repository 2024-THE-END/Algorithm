package 김근범.백트래킹.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_8 {

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
        fetchSequence(0);
        System.out.println(sb);
    }

    private static void fetchSequence(int index) {
        if(index == M) {
            for(int i: result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }


        for(int i=0;i<N;i++) {
            if(index ==0 || result[index-1] <= arr[i]) {
                result[index] = arr[i];
                fetchSequence(index+1);
            }
        }
    }
}
