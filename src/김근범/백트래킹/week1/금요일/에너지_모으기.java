package 김근범.백트래킹.week1.금요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 에너지_모으기 {
    static int N;
    static ArrayList<Integer> weight = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            weight.add(Integer.parseInt(st.nextToken()));
        }
        fetchMax(0, 0);
        System.out.println(max);
    }

    private static void fetchMax(int index, int sum) {
        if(index == N-2) {
            if(max < sum) max = sum;
            return;
        }

        for(int i=1;i<weight.size()-1;i++){
            Integer num = weight.remove(i);
            int plus = weight.get(i-1) * weight.get(i);
            fetchMax(index +1, sum + plus);
            weight.add(i, num);
        }
    }
}
