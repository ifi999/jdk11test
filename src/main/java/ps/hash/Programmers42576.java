package ps.hash;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스
 * - 코딩테스트 연습 - 해시 - 완주하지 못한 선수 (https://school.programmers.co.kr/learn/courses/30/lessons/42576)
 *
 * 문제 설명
 * - 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * - completion의 길이는 participant의 길이보다 1 작습니다.
 * - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * - 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 * 입출력 예
 * - participant	                                    completion                                  return
 *  ["leo", "kiki", "eden"]	                            ["eden", "kiki"]                            "leo"
 *  ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]    "vinko"
 *  ["mislav", "stanko", "mislav", "ana"]	            ["stanko", "ana", "mislav"]                 "mislav"
 *
 * 풀이
 * - 2개 정렬 : O(Nlog(N))
 * - 이후 짧은 것 기준으로 탐색 : O(N)
 */
public class Programmers42576 {

    public static void main(String[] args) {
        final String[] participant1 = {"leo", "kiki", "eden"};
        final String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        final String[] participant3 = {"mislav", "stanko", "mislav", "ana"};

        final String[] completion1 = {"eden", "kiki"};
        final String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        final String[] completion3 = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant1, completion1));
        System.out.println(solution(participant2, completion2));
        System.out.println(solution(participant3, completion3));
    }

    public static String solution(final String[] participant, final String[] completion) {
        final List<String> participantList = Arrays.stream(participant)
                .sorted()
                .collect(Collectors.toList());
        final List<String> completionList = Arrays.stream(completion)
                .sorted()
                .collect(Collectors.toList());

        final int size = completionList.size();
        for (int i = 0; i < size; i++) {
            if (!participantList.get(i).equals(completionList.get(i))) {
                return participantList.get(i);
            }
        }

        return participantList.get(participantList.size() -1);
    }

}
