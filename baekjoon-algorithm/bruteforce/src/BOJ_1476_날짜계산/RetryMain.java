package BOJ_1476_날짜계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RetryMain {

    static int E, S, M;

    static void input(){
        CustomReader scan = new CustomReader();

        E = scan.nextInt();
        S = scan.nextInt();
        M = scan.nextInt();

    }

    static void pro(){

        int e, s, m;
        int year = 1;

        while(true){

            e = year % 15 == 0 ? 15 : year % 15;
            s = year % 28 == 0 ? 28 : year % 28;
            m = year % 19 == 0 ? 19 : year % 19;

            if(e == E && s == S && m == M){
                System.out.println(year);
                break;
            }
            year++;
        }
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
