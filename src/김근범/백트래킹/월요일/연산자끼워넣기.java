package 김근범.백트래킹.월요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int N;
    static int[] num;
    static int[] result;
    static int[] op = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        result = new int[N];
        for(int i=0;i<num.length;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        result[0] = num[0];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        calculateMinMax(1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void calculateMinMax(int index) {
        if(index == result.length) {
            int calculateResult = result[result.length-1];
            if(min > calculateResult) min = calculateResult;
            if(max < calculateResult) max = calculateResult;
            return;
        }
        for(int i=0;i<4;i++){
            if(op[i]>0) {
                op[i]--;
                result[index] = i==0 ? result[index-1] + num[index] : i==1 ? result[index-1] - num[index] : i==2 ? result[index-1] * num[index] : result[index-1] / num[index];
                calculateMinMax(index+1);
                op[i]++;
            }
        }
    }
}
