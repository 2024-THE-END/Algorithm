package 김근범.백트래킹.금요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기_2 {
    static int N;
    static int[] num;
    static int[] op = new int[4];
    static int[] signs;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        signs = new int[N-1];
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        fetchMinMax(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void fetchMinMax(int index) {
        if(index == N-1) {
            int result = num[0];
            for(int i=0;i<N-1;i++){
                result = calculate(result, signs[i], num[i+1]);
            }
            if(min > result) min = result;
            if(max < result) max = result;
            return;
        }

        for(int i=0;i<4;i++){
            if(op[i] > 0) {
                op[i]--;
                signs[index] = i;
                fetchMinMax(index+1);
                op[i]++;
            }
        }
    }

    private static int calculate(int result, int op, int num) {
        switch (op) {
            case 0:
                result = result + num;
                break;
            case 1:
                result = result - num;
                break;
            case 2:
                result = result * num;
                break;
            case 3:
                result = result / num;
                break;
        }
        return result;
    }
}
