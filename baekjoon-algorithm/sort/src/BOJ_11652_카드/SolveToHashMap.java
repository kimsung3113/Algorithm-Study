package src.BOJ_11652_카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SolveToHashMap {

    static HashMap<Long, Integer> map = new HashMap<>();

    static void input(){
        CustomReader scan = new CustomReader();
        N = scan.nextInt();
        long cardNum = 0;
        for(int i = 0; i < N; i++){
            cardNum = scan.nextLong();
            map.put(cardNum, map.getOrDefault(cardNum, 0) + 1);
        }

    }

    static int N;

    public static void main(String[] args) {
        input();

        // 람다로 바꾼 식
        // Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o1.getValue().compareTo(o2.getValue());
        Comparator<Map.Entry<Long, Integer>> comparator = new Comparator<Map.Entry<Long, Integer>>() {

            // value 값이 같으면 key 값이 작은 것을 return
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {

                if(o1.getValue().equals(o2.getValue())){
                    return Long.compare(o2.getKey(), o1.getKey()); // 음수일때 2번째 파라미터 return, 양수일때 첫번째
                }

                return o1.getValue().compareTo(o2.getValue());
            }
        };

        Map.Entry<Long, Integer> ans = Collections.max(map.entrySet(), comparator);
        System.out.println(ans.getKey());
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

        long nextLong(){
            return Long.parseLong(next());
        }

    }

}
