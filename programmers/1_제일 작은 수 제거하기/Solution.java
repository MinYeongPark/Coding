class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[arr.length - 1];

            int min_index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[min_index] > arr[i])
                    min_index = i;
            }

            int answer_index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != min_index) {
                    answer[answer_index] = arr[i];
                    answer_index++;
                }
            }

            return answer;
        }
    }
}