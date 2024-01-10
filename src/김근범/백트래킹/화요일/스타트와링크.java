package 김근범.백트래킹.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {

    static int N;
    static int [][] ability;
    static int[] team1;
    static int[] team2;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        team1 = new int[N/2];
        team2 = new int[N/2];
        check = new boolean[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fetchMinDiff(0);
        System.out.println(min);
    }

    private static void fetchMinDiff(int index) {
        if(index == team1.length) {
            int idx = 0;
            for(int i=0;i<check.length;i++){
                if(!check[i]) team2[idx++] = i;
            }
            int ability1 = getTeamAbility(team1);
            int ability2 = getTeamAbility(team2);
            int diff = Math.abs(ability1 - ability2);
            if(min > diff) min = diff;
            return;
        }

        for(int i=0;i<N;i++){
            if(index ==0 || (!check[i] && team1[index-1] < i)) {
                check[i] = true;
                team1[index] = i;
                fetchMinDiff(index+1);
                check[i] = false;
            }
        }
    }

    private static int getTeamAbility(int[] team) {
        int sum = 0;
        for(int i=0;i<team.length-1;i++){
            for(int j=i+1;j<team.length;j++) {
                sum+= ability[team[i]][team[j]] + ability[team[j]][team[i]];
            }
        }
        return sum;
    }
}
