package 김근범.백트래킹.금요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 카드놓기 {
    static int n, k;
    static int[] cards;
    static int[] result;
    static boolean[] check;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new int[n];
        result = new int[k];
        check = new boolean[n];
        for(int i=0;i<n;i++){
            cards[i] = Integer.parseInt(br.readLine());
        }
        fetchNumSet(0);
        System.out.println(set.size());
    }

    private static void fetchNumSet(int index) {
        if(index == k) {
            StringBuilder num = new StringBuilder();
            for(int i : result) {
                num.append(i);
            }
            set.add(num.toString());
            return;
        }

        for(int i=0;i<n;i++) {
            if(!check[i]){
                check[i] = true;
                result[index] = cards[i];
                fetchNumSet(index+1);
                check[i] = false;
            }
        }
    }
}
