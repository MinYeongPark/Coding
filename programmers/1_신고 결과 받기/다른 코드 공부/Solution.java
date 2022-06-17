/*
 * @author Minyeong Park
 * @date 2022.06.17.
 * 1단계 - 신고 결과 받기 (다른 코드 공부)
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 내역의 중복을 스트림의 distinct를 이용해 제거
        List<String> list = Arrays.stream(report)                   // 스트림을 이용하기 위해, 배열 인스턴스를 이용해 생성한다.
                                    .distinct()                     // 스트림에서 중복되는 아이템을 모두 제거하고 새로운 스트림을 반환한다. (한 사람을 한 번밖에 신고하지 못하는 것 처리)
                                    .collect(Collectors.toList());  // collect는 stream의 아이템들을 원하는 자료형으로 변환해준다. 여기서는 List객체로 리턴하는 것이다.

        HashMap<String, Integer> count = new HashMap<>();    // 사람이름 : 신고당한 횟수
        for (String s : list) {
            String target = s.split(" ")[1];                 // 신고당한 사람 이름
            count.put(target, count.getOrDefault(target, 0) + 1); // 이 사람이 신고당한 횟수가 존재하면 그 값에 +1, 존재하지 않으면 0으로 세팅
        }

        return Arrays.stream(id_list).map(_user -> { // stream에서 map 메서드는 요소들을 특정 조건에 해당하는 값으로 변환해주는 것. 즉 이 람다식에서 세운 조건에 해당하도록 구현하는 것임.
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")) // filter : 요소들을 조건에 따라 걸러냄, startsWith : s문자열이 user + " "로 시작하는지를 체크함
                    .collect(Collectors.toList());                                        // 즉 user + " "로 시작하는 문자열에 대해 리스트로 만든 것.
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count(); // 이 reportList의 뒷 이름에 대한 count값을 가져오고 k보다 큰 개수를 구함..
        })
    }
}
