package 김근범.백트래킹.목요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원과순회_2 {
    static int N;
    static int[][] time;
    static int[] result;
    static boolean[] check;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N][N];
        result = new int[N];
        check = new boolean[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fetchDirections(0);
        System.out.println(minTime);
    }

    private static void fetchDirections(int index) {
        if(index == N) {
            if(time[result[index-1]][result[0]] != 0) {
                int length = 0;
                for(int i=0;i<N-1;i++){
                    length += time[result[i]][result[i+1]];
                }
                length += time[result[index-1]][result[0]];
                if(length < minTime) minTime = length;
            }
            return;
        }

        for(int i=0;i<N;i++){
            if(index == 0 || (!check[i] && time[result[index-1]][i]!=0)) {
                result[index] = i;
                check[i] = true;
                fetchDirections(index+1);
                check[i] = false;
            }
        }
    }
}
