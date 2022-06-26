// 내 풀이
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}


// 다른 사람 풀이
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = arr1;   // 어차피 arr1에 arr2 원소들을 더하는 방식이니까 arr1으로 먼저 초기화해도 됨!
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] += arr2[i][j];      // arr2의 원소들을 더하는 방식으로 진행
            }
        }
        return answer;
    }
}