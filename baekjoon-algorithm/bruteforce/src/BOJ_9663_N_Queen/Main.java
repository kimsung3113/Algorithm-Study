package BOJ_9663_N_Queen;

public class Main {

    static TimeOutMain.FastReader scan = new TimeOutMain.FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true; // 왼쪽 대각선
        if (r1 + c1 == r2 + c2) return true; // 오른쪽 대각선
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                // valid check (row, c)
                for (int i=1;i<=row-1;i++){ // 현재보다 위의 행들 안에 공격되는 Queen이 있는지 확인!!
                    // (i, col[i])
                    if (attackable(row, c, i, col[i])){
                        System.out.println("row = " + row + " c : " + c + " i : " + i + " col[i] : " + col[i]);

                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
    }


}
