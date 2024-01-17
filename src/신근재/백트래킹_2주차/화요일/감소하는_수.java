package 신근재.백트래킹_2주차.화요일;

/*
* X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수
* N은 100 0000
* 100만은 최대 자리 수가 7인데 그냥 1부터 100만까지 반복문에 하면 100만*7로 시간복잡도는 괜찮을 거 같은데
* 백트래킹으로 꼭 풀어야할까?
* 백트래킹으로 푼다면 어떻게 풀 수 있을까
* => 가장 큰 수를 100만까지 제한하는 게 아니라.. n번째 감소하는 수가 100만번째까지..
* => 걍 풀면 시간초과뜸
*
* => 그럼 백트래킹으로만 풀어보자
* => 숫자를 고를 때 첫자리를 1을 골랐다면 10
* => 2를 골랐다면 뒤는 무조건 1, 0이런식으로 자기보다 작은 수를 무조건 골라나가야할 것이다.
* => 그럼 1의 자리부터 자리수를 계속 늘려가면서? cnt를 증가시켜나가는게
*
* [1] while(cnt != 100만)
* [2] DFS(원하는 자릿수, curDepth)
* [3] 현재 원하는 자리수를 하는데..값의 시작과 끝을 잘 정해야
*       2자리는 2부터시작
*       3자리는 3부터
*       4자리는 4부터
*       5자리는 5부터
*
* 99 98 97 ...91 90
* 89 ...80
* 32 31 30
* 21 20
* 10
* */
import java.util.*;
import java.io.*;
public class 감소하는_수 {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n <= 10) {
            System.out.println(n);
        }
        else {
            for(int i = 0 ; i < 10 ; i++) {
                calculator((long)i);
            }

            //저장해둔 모든 감소하는 수를 정렬 시켜 원하는 곳을 고르기 위해
            Collections.sort(list);

            //구해놓은 감소하는 수들보다 더 큰 걸 원한다면 못구해
            if(list.size() <= n) {
                System.out.println(-1);
            }
            else {
                System.out.println(list.get(n));
            }
        }
    }

    public static void calculator(long num) {
        //정수의 최대까지 간 경우 종료
        if(num > Long.parseLong("9876543210")) {
            return;
        }

        list.add(num);
        for(int i = 0 ; i < 10 ; i++) {
            //num의 끝자리가 더 커야 뒤에 숫자가 올 수 있다
            if(num % 10 > i) {
                calculator((num * 10) + (long)i);
            }
        }
    }
}