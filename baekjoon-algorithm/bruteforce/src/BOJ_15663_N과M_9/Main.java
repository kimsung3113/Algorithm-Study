package BOJ_15663_N과M_9;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        nums = new int[N + 1];
        for(int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        used = new int[N + 1];

        // 1. 사전 순이라 정렬을 한다.
        Arrays.sort(nums, 1, N + 1);
        System.out.println(Arrays.toString(nums));
    }

    static int N, M;
    static int[] selected, nums, used;

    // Recurrence Function (재귀 함수)
    // 만약 M 개를 전부 고름   => 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            System.out.println(sb.toString());
            sb.append('\n');
        } else {
            int last_cand = 0;
            for (int cand = 1; cand <= N; cand++) {

                if(used[cand] == 1) continue;
                if(last_cand == nums[cand]) continue;

                System.out.println("k : " + k + " last_cand :" + last_cand + " cand : " + cand);
                last_cand = nums[cand];
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

