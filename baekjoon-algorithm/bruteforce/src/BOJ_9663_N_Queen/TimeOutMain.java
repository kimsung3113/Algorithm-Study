package BOJ_9663_N_Queen;

import java.io.*;
import java.util.*;

public class TimeOutMain {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        // TODO
        if(c1 == c2) return true;
        else if(r1 + c1 == r2 + c2) return true;  // 왼쪽 대각선으로 만나는 상황
        else if(r1 - c1 == r2 - c2) return true;  // 오른쪽 대각선으로 만나는 상황
        return false;
    }

    // 공격할 수 있는 Queen이 있으면 false, 모두 공격할 수 없으면 true return 하게
    static boolean validateCheck(){
        for(int i = 1; i <= N; i++){
            // (i, col[i]) i행, col[row]열 이라는 것을 알 수 있다.
            for(int j = 1; j < i; j++){
                // j번째보다 높이 있는 행들에 공격가능한 Queen이 있는지 확인
                // (j, col[j])
                if(attackable(i, col[i], j, col[j])){
                    return false;
                }
            }
        }
        return true;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            // TODO
            if(validateCheck()){
                ans++;
            }

        } else {
            // TODO
            for(int cand = 1; cand <= N; cand++) {
                col[row] = cand;
                rec_func(row + 1);
                col[row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
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
