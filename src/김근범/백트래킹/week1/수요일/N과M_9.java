package 김근범.백트래킹.week1.수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M_9 {
    static int N, M;
    static LinkedHashSet<Integer> set = new LinkedHashSet<>();
    static int[] arr;
    static int[] result;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            set.add(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        fetchSequences(0);
        System.out.print(sb);
    }

    private static void fetchSequences(int index) {
        if(index == M) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int num : set) {
            if (map.getOrDefault(num, 0) > 0) {
                map.put(num, map.get(num) - 1);
                result[index] = num;
                fetchSequences(index + 1);
                map.put(num, map.get(num) + 1);
            }
        }
    }
}
