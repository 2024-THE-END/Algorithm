package 김창우.SecondWeek.tuesday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 0~9 10개
 * 10 1개 20 2개 30 3개 ... 90 9개
 * 200 -> 10 1개
 * 300 -> 10 1개 20 2개-> 3개
 * 3000-> 200 1개 -> 1개
 * 4000-> 200 1개 300 3개 -> 4개
 * .
 * .
 * .
 * 9876543210-이게 최대->1022번째..
 */
public class BJ1038_감소하는수 {
    static ArrayList<Long> list; //범위가 크다 Long..
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        list = new ArrayList<>();
        if (N <= 10) System.out.println(N);
        else if (N > 1022) System.out.println(-1);
        else{
            for (int i=0;i<10;i++){
                dps(i,1);
            }
            Collections.sort(list);//순서대로 정렬해줘야 순서대로 나옴
            System.out.println(list.get(N));
        }
    }
    private static void dps(long num,int idx){
        if(idx>10)return;
        list.add(num);
        for (int i=0;i<num%10;i++){
            dps((num*10)+i,idx+i);
        }
    }
}

