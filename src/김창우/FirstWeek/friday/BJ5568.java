package 김창우.FirstWeek.friday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BJ5568 {
    static int n;
    static int k;
    static int numbers[];
    static int arr[];
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        numbers = new int[n];
        visited = new boolean[n];
        arr=new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        dfs(0);
        System.out.println(set.size());
    }

    private static void dfs(int depth) {
        if ( depth== k) {
            String str="";
            for (int i=0;i<n;i++){
                str+=arr[i];
            }
            set.add(str);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                arr[depth]=numbers[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
