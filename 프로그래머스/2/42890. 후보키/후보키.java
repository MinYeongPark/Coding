import java.util.*;

class Solution {
    // 비트를 담는 list
    List<Integer> answer = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int n = relation.length; // 튜플 개수
        int m = relation[0].length; // 컬럼 개수
        
        // 조합 만들기
        for (int i = 1; i < 1 << m; i++) { // m개 컬럼에 대한 경우의 수(0001, 0010...)
            Set<String> set = new HashSet<>(); // 
            
            // 튜플들을 다 확인
            for (int j = 0; j < n; j++) {
                String temp = "";
                // 튜플에서 컬럼들을 돌면서 확인
                for (int k = 0; k < m; k++) {
                    if ((i & 1 << k) > 0) { // i의 k번째 비트가 켜져있는지(1) 확인
                        temp += (relation[j][k]);
                    }
                }
                set.add(temp);
            }
            
            // 유일성을 만족하고 최소성을 만족한다면
            if (set.size() == n && check(i)) {
                answer.add(i);
            }
        }
        
        return answer.size();
    }
    
    // 최소성 확인
    boolean check(int i) {
        for (int j : answer) {
            if ((i & j) == j) // i & j == j 의 의미 : i가 j의 부분집합인지 여부
                // ex : i = 111, j = 011 -> i & j = 011 -> j가 i의 부분집합이 되므로 false
                return false;
        }
        return true;
    }
}