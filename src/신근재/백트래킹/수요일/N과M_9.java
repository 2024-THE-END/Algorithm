package 신근재.백트래킹.수요일;

import java.util.*;

public class N과M_9 {
    static int n;
    static int m;
    static int[] saveAry;

    static StringBuilder stb = new StringBuilder();
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String args[]) throws Exception {
        //🕐 14:57~
        //중복되는 수열 X
        //사전 순 증가하는 -> 정렬
        //차이점은 같은 수가 여러 번 등장할 수 있다.(-> 연산자 처리랑 비슷한..?)
        // 1 1 7 9
        //썻으면 사용했다고 표시를 하긴 해야하는데..
        //[1] 10001 배열을 이용해서 저장한다 -> 찾을 때 시간복잡도 너무 증가..->이건 아님
        //[2] ary에는 그냥 숫자 중복 없이 저장하고..countAry에는 따로 ary가 몇 개씩 있는지?..
        //-> 뻘짓하다가 시간 다 날림 그냥 ArrayList를 사용하기로 결정..
        //-> 결국 리스트를 쓴다해도 결정적으로 이 값이 몇 번 나왔는지도 생각해야함
        //-> 그런 거 까지 다 생각하면 딕셔너리나 해시를 사용하는 게..

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        saveAry = new int[m];

        for(int i=0;i<n;i++) {
            int tempValue = sc.nextInt();
            //기존 확인 + 있다면 더해주기까지
            map.put(tempValue, map.getOrDefault(tempValue,0) + 1);
        }

        backTracking(0);
        System.out.println(stb);
    }

    private static void backTracking(int curDepth) {
        if(curDepth == m){
            for(int n : saveAry){
                stb.append(n + " ");
            }
            stb.append("\n");
            return;
        }

        for(int key : map.keySet()){
            if(map.get(key) != 0){
                saveAry[curDepth] = key;
                map.put(key, map.get(key)-1);
                backTracking(curDepth+1);
                map.put(key, map.get(key)+1);
            }
        }
    }
}
