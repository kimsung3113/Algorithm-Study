package BOJ_1182_부분_수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RetryMain {

    static void input(){
        CustomReader scan = new CustomReader();
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N+1];
        for(int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    }

    static int N, S, ans;
    static int[] nums;

    static void rec_func(int param, int value){

        if(param == N + 1){
            if(value == S){
                ans++;
            }
        }else{
            rec_func(param + 1, value + nums[param]);
            rec_func(param + 1, value);
        }

    }


    public static void main(String[] args){
        input();
        rec_func(1, nums[0]);

        if(S == 0){
            ans--;
        }

        System.out.println(ans);
    }

    static class CustomReader{
        BufferedReader br;
        StringTokenizer st;

        public CustomReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
