package 김근범.백트래킹.목요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부등호 {

    static int k;
    static char[] signs;
    static int[] result;
    static boolean[] check;
    static String min = String.valueOf(Long.MAX_VALUE);
    static String max = String.valueOf(Long.MIN_VALUE);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new char[k];
        result = new int[k+1];
        check = new boolean[10];
        for(int i=0;i<k;i++){
            signs[i] = st.nextToken().charAt(0);
        }
        getMinMax(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void getMinMax(int index) {
        if(index == k+1) {
            StringBuilder sb = new StringBuilder();
            boolean answer = true;
            for(int i=0;i<k;i++) {
                if(signs[i]=='<' && result[i] < result[i+1]) {
                    sb.append(result[i]);
                    answer = true;
                } else if(signs[i]=='>' && result[i] > result[i+1]) {
                    sb.append(result[i]);
                    answer = true;
                } else {
                    sb.append(result[i]);
                    answer = false;
                    break;
                }
            }
            if(answer) {
                sb.append(result[k]);
                if(Long.parseLong(min) > Long.parseLong(sb.toString())) min = sb.toString();
                if(Long.parseLong(max) < Long.parseLong(sb.toString())) max = sb.toString();
            }
            return;
        }

        for(int i=0;i<10;i++){
            if(!check[i]){
                check[i] = true;
                result[index] = i;
                getMinMax(index+1);
                check[i] = false;
            }
        }

    }
}
