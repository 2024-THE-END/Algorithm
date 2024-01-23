package 김근범.백트래킹.week2.월요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 로마_숫자_만들기 {

    static int N;
    static int currentCount;
    static int[] rome = {1, 5, 10, 50};
    static int[] result;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        currentCount = N;
        result = new int[4];
        fetchRomeNum(0);
        System.out.println(set.size());
    }

    private static void fetchRomeNum(int index) {
        if(index == 3) {
            result[3] = currentCount;
            int sum = 0;
            for(int i=0;i<4;i++){
                sum += rome[i] * result[i];
            }
            set.add(sum);
            return;
        }

        for(int i=0;i<=currentCount;i++){
            result[index] = i;
            currentCount -= i;
            fetchRomeNum(index+1);
            currentCount += i;
        }
    }
}
