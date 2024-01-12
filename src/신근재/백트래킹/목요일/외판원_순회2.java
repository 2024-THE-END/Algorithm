package 신근재.백트래킹.목요일;

import java.util.*;

public class 외판원_순회2 {
    static int lastCity;
    static int[][] cost;
    static int[] saveCity;
    static int minCost = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String args[]) throws Exception{
        //1~N 도시
        //도시들 사이에 길이 있을 수도 없을 수도..
        //W[i][j] = i에서 j로 가는 비용
        //목표 : 최소 비용으로 모든 도시를 순회하는 여행
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
                //길이 없는 경우는 이동 비용이 0인 경우 그냥 겁나 더해버려서 최소에 포함도 안되게
                if(cost[saveCity[i]][saveCity[i+1]] == 0)
                    tempCost += 1000000;
                tempCost += cost[saveCity[i]][saveCity[i+1]];
            }
            //다시 원래로 돌아가는?..
            tempCost += cost[saveCity[lastCity-1]][saveCity[0]];
            minCost = Math.min(minCost, tempCost);
            return;
        }

        //[0][1] [1][2] [3][4]
        //0123 => 01 12 23 이니까 그냥 0123으로 저장하자 그럼
        for(int i=0;i<lastCity;i++){
            if(!visited[i]){
                visited[i]=true;
                saveCity[curDepth] = i;
                getMinCost(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
