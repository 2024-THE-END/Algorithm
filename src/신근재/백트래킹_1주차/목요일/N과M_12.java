package 신근재.백트래킹_1주차.목요일;

import java.util.*;

public class N과M_12 {
    static int n;
    static int m;
    static int[] saveAry;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception{
        //같은 수 여러 번 가능
        //비내림차순
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        saveAry=new int[m];

        for(int i=0;i<n;i++){
            set.add(sc.nextInt());
        }

        makeSequence(0);
        System.out.println(sb);
    }

    private static void makeSequence(int curDepth) {
        if(curDepth==m){
            for(int n : saveAry)
                sb.append(n + " ");
            sb.append("\n");
            return;
        }

        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int value = it.next();
            if(curDepth == 0 || saveAry[curDepth-1] <= value){
                saveAry[curDepth] = value;
                makeSequence(curDepth+1);
            }
        }
    }
}