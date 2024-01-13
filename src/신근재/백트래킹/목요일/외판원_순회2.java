package 신근재.백트래킹.목요일;

import java.util.*;
public class 외판원_순회2 {
    static int lastCity;
    static int[][] cost;
    static int[] saveCity;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        lastCity = sc.nextInt();
        visited = new boolean[lastCity];
        saveCity = new int[lastCity];
        cost=new int[lastCity][lastCity];

        for(int i = 0; i< lastCity; i++){
            for(int j = 0; j< lastCity; j++){
                cost[i][j] = sc.nextInt();
            }
        }

        getMinCost(0);
        System.out.println(minCost);
    }

    private static void getMinCost(int curDepth) {
        if(curDepth == lastCity){
            int tempCost = 0;
            for(int i = 0; i < lastCity-1; i++){
                tempCost += cost[saveCity[i]][saveCity[i+1]];
            }

            //다시 원래로 돌아가는
            tempCost += cost[saveCity[lastCity-1]][saveCity[0]];
            minCost = Math.min(minCost, tempCost);
            return;
        }

        for(int i=0;i<lastCity;i++){
            if(!visited[i]){
                visited[i]=true;
                //saveCity
                saveCity[curDepth] = i;
                getMinCost(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
