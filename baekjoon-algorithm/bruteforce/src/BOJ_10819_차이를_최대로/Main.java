package BOJ_10819_차이를_최대로;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        M = scan.nextInt();
        max = Integer.MIN_VALUE;
        nums = new int[M + 1];
        String [] tokens = scan.nextLine().split(" ");
        for(int i = 1; i <= M; i++) {
            nums[i] = Integer.parseInt(tokens[i-1]);
        }
        selected = new int[M + 1];
        used = new int[M + 1];
    }

    static int M , max;
    static int[] selected, nums, used;

    // Recurrence Function (재귀 함수)
    static void rec_func(int k) {
        if (k == M + 1) { // 절대값의 최대값 구하기!
            int sum = 0;
            for (int i = 1; i < M; i++) sum += Math.abs(selected[i] - selected[i+1]);

            max = Math.max(max, sum);
        } else {
            for (int cand = 1; cand <= M; cand++) {

                if(used[cand] == 1) continue;

                selected[k] = nums[cand]; used[cand] = 1;
                rec_func(k + 1);
                selected[k] = 0; used[cand] = 0;
            }
        }
    }


    public static void main(String[] args) {
        input();

        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        rec_func(1);
        System.out.println(max);
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
