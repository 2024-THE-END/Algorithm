package 김창우.SecondWeek.monday;

import java.util.*;

public class BJ16922_로마숫자만들기 {
    static int N;
    static int[] number={1,5,10,50};
    static List<Integer> combination ;
    static Set<Integer> answer;//중복체크를 위해 필요했다.
    //10번의 경우 그냥하면 286이 나온다..
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        combination  = new ArrayList<>();
        answer = new HashSet<>();
        combi(0,0,0);
        System.out.println(answer.size());
    }

    private static void combi(int start, int depth,int sum) {
        if(depth==N){
            answer.add(sum);
            return;
        }
        for (int i=start;i<4;i++){
            combination.add(number[i]);
            combi(i,depth+1,sum+number[i]);
            combination.remove(combination.size()-1);
        }
    }
}
