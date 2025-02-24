package BOJ_15649_N과M_1;

public class DeepMain {

    static StringBuilder sb = new StringBuilder();

    static void input() {
        Main.FastReader scan = new Main.FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        used = new int[N + 1];
    }

    static int N, M;
    static int[] selected, used;

    // Recurrence Function (재귀 함수)
    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {

                if(used[cand] == 1) continue;

                selected[k] = cand; used[cand] = 1;
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

}
