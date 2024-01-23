package 김근범.백트래킹.week1.금요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 도영이가_만든_맛있는_음식 {

    static int N;
    static int[][] arr;
    static ArrayList<Integer> list = new ArrayList<>();
    static BigInteger minDiff = new BigInteger("1" + "000000000".repeat(10));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        fetchMinDiff(0);
        System.out.println(minDiff);
    }

    private static void fetchMinDiff(int index) {
        if(index == N) {
            if(!list.isEmpty()) {
                BigInteger sourSum = BigInteger.valueOf(1);
                long bitSum = 0;
                for (int num : list) {
                    sourSum = sourSum.multiply(BigInteger.valueOf(arr[num][0]));
                    bitSum += arr[num][1];
                }
                minDiff = sourSum.subtract(BigInteger.valueOf(bitSum)).abs().min(minDiff);
            }
            return;
        }

        fetchMinDiff(index+1);
        Integer n = index;
        list.add(n);
        fetchMinDiff(index+1);
        list.remove(n);
    }
}
