package 김창우.FirstWeek.friday;

import java.util.Scanner;

public class BJ1189 {
    static int R,C,K;
    static char[][] map;
    static int[][] visited;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int count=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();
        K=sc.nextInt();
        map=new char[R][C];
        visited=new int[R][C];
        for (int i=0;i<R;i++){
            String s=sc.next();
            for(int j=0;j<C;j++){
                map[i][j]=s.charAt(j);
            }
        }
        visited[R-1][0]=1;
        dfs(R-1,0,1);
        System.out.println(count);
    }
    private static void dfs(int x, int y, int depth){
        if(x==0&&y==C-1){
            if (depth==K)count++;
            return;
        }
        for(int i=0; i<4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(next_x<0 || next_x>=R || next_y<0 ||next_y>=C)
                continue;
            if(visited[next_x][next_y] == 1 || map[next_x][next_y] == 'T')
                continue;
            visited[next_x][next_y] = 1;
            dfs(next_x, next_y, depth+1);
            visited[next_x][next_y] = 0;

        }

    }
}
