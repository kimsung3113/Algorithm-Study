package BOJ_14888_연산자_끼워넣기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    // order는 어떤 순서대로 연산자를 배열 했는지를 기록하는 배열
    static int[] nums, operators, order;

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(){
        // TODO
        int value = nums[1];
        for(int i = 1; i <= N-1; i++){
            // value, orders[i] , nums[i+1]
            if(order[i] == 1){
                value =  value + nums[i+1]; // +
            } else if (order[i]  == 2) {
                value = value - nums[i+1]; // -
            }else if (order[i]  == 3) {
                value = value * nums[i+1]; // *
            }else{
                value = value / nums[i+1]; // /
            }
        }
        return value;
    }


    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k) {
        if (k == N) { // 모든 연산자를 순서대로 잘 나열 했다는 뜻
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            // TODO
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            // cand가 이번에 올 수 있는 연산자의 후보인데 이 연산자를 쓸 수 있냐 없냐가 어떻게 결정되나면?
            // operators에 cand가 0이상인지 확인 해야한다.
            for(int cand = 1; cand <= 4; cand++) {

                if(operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k + 1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
