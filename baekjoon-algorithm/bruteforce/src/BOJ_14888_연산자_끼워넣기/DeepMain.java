package BOJ_14888_연산자_끼워넣기;

public class DeepMain {

    public class Main {
        static BOJ_14888_연산자_끼워넣기.Main.FastReader scan = new BOJ_14888_연산자_끼워넣기.Main.FastReader();
        static StringBuilder sb = new StringBuilder();

        static void input() {
            N = scan.nextInt();
            nums = new int[N + 1];
            operators = new int[5];
            for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
            for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }

        static int N, max, min;
        static int[] nums, operators;

        // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
        static int calculator(int operand1, int operator, int operand2) {
            // value, order[i], num[i+1]
            if (operator == 1) // +
                return operand1 + operand2;
            else if (operator == 2) // -
                return operand1 - operand2;
            else if (operator == 3) // *
                return operand1 * operand2;
            else // /
                return operand1 / operand2;
        }


        // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
        static void rec_func(int k, int value) {
            if (k == N) {
                // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
                max = Math.max(max, value);
                min = Math.min(min, value);
            } else {
                // k 번째 연산자는 무엇을 선택할 것인가?
                for (int cand = 1; cand <= 4; cand++) {
                    if (operators[cand] >= 1) {
                        operators[cand]--;
                        rec_func(k + 1, calculator(value, cand, nums[k + 1]));
                        operators[cand]++;
                    }
                }
            }
        }

        public static void main(String[] args) {
            input();
            // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
            rec_func(1, nums[1]);
            sb.append(max).append('\n').append(min);
            System.out.println(sb.toString());
        }

    }
}
