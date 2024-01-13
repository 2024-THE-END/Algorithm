package 김근범.백트래킹.week1.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {

    static int k;
    static int[] S;
    static boolean[] check;
    static int[] arr = new int[6];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;
            S = new int[k];
            check = new boolean[k];
            for(int i=0;i<k;i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            fetchLottoSequence(0);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void fetchLottoSequence(int index) {
        if(index==6) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<S.length;i++){
            if(index == 0 || (!check[i] && arr[index-1] < S[i])) {
                check[i] = true;
                arr[index] = S[i];
                fetchLottoSequence(index+1);
                check[i] = false;
            }
        }
    }
}
