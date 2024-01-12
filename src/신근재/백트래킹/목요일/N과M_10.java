package 신근재.백트래킹.목요일;

import java.util.*;

public class N과M_10 {
    static int n;
    static int m;
    static int[] tempAry;
    static HashMap<Integer,Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception {
        //비내림차순
        //사전순증가
        //같은 수 여러 번 가능
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        tempAry=new int[m];

        for(int i=0;i<n;i++){
            int value = sc.nextInt();
            //hm.getOrDefault(key, 0) + 1);
            map.put(value, map.getOrDefault(value, 0)+1);
        }

        makeSequence(0);
        System.out.println(sb);
    }

    private static void makeSequence(int curDepth) {
        if(curDepth==m){
            for(int n :tempAry)
                sb.append(n+" ");
            sb.append("\n");
            return;
        }

        for(int num : map.keySet()){
            //맵에 횟수가 남아있다면?
            if(map.get(num) > 0){
                if(curDepth == 0 || tempAry[curDepth-1] <= num){
                    map.put(num, map.get(num)-1);
                    tempAry[curDepth]=num;
                    makeSequence(curDepth+1);
                    map.put(num, map.get(num)+1);
                }
            }
        }
    }
}
