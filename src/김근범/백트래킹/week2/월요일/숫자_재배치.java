package 김근범.백트래킹.week2.월요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_재배치 {

    static int A, B;
    static int[] num;
    static boolean[] check;
    static int max = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(input);
        num = new int[input.length()];
        check = new boolean[input.length()];
        String[] inputList = input.split("");
        for(int i=0;i<input.length();i++) {
            num[i] = Integer.parseInt(inputList[i]);
        }
        fetchMax(0, 0);
        System.out.println(max);
    }

    private static void fetchMax(int sum, int index) {
        if(index == num.length) {
            if(sum < B && max < sum) max = sum;
            return;
        }

        for(int i=0;i<num.length;i++){
            if(!check[i]){
                if(index==0 && num[i] == 0) continue;
                check[i] = true;
                int result = sum *10 + num[i];
                fetchMax(result, index+1);
                check[i] = false;
            }
        }
    }
}
