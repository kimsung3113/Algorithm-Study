package src.BOJ_11652_카드;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static void input(){
        CustomReader scan = new CustomReader();
        N = scan.nextInt();
        nums = new long[N];
        for(int i = 0; i < N; i++) nums[i] = scan.nextLong();
    }

    static int N;
    static long[] nums;

    static void pro(){

        Arrays.sort(nums);

        // mode : 최빈값, modeCnt : 최빈값 등장 횟수, curCnt : 현재는 (nums[0])이 나온 횟수
        long mode = nums[0];
        int modeCnt = 1, curCnt = 1;

        for(int i = 1; i < N; i++){

            if(nums[i] == nums[i-1]){
                curCnt++;

                if(modeCnt < curCnt){
                    modeCnt++;
                    mode = nums[i];
                }
            }else{
                curCnt = 1;
            }

        }
        System.out.println(mode);

    }

    public static void main(String[] args){
        input();
        pro();
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
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

    }

}
