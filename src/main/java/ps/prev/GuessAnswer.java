package ps.prev;

import java.util.*;

// 찍신 찾기 (문제 잘 찍은 사람)
public class GuessAnswer {



    public static void main(String[] args) {

        // 정답 번호와 점수 목록

        List<Question> list = Arrays.asList(

                new Question(1, 5),

                new Question(3, 3),

                new Question(2, 4)

        );

        System.out.println(solution(list));

    }

    // 정답 번호와 점수

    static class Question {

        int answer;

        int score;

        public Question(int answer, int score) {

            this.answer = answer;

            this.score = score;

        }

    }

    // 응시자 이름과 점수

    static class Score {

        String name;

        int score;

        public Score(String name) {

            this.name = name;

            this.score = 0;

        }

        void addScore(int score) {

            this.score += score;

        }

        @Override

        public String toString() {

            return this.name + " : " + this.score;

        }

    }

    private static String solution(List<Question> list) {

        Score a = new Score("a");

        Score b = new Score("b");

        Score c = new Score("c");

        for (Question q : list) {

            if (q.answer == 1) a.addScore(q.score);

            if (q.answer == 3) b.addScore(q.score);

            if (q.answer == 5) c.addScore(q.score);

        }

        List<Score> scores = Arrays.asList(a, b, c);

        scores.sort((s1, s2) -> Integer.compare(s2.score, s1.score));

        // 가장 높은 응시자 출력

        StringBuilder sb = new StringBuilder(scores.get(0).toString());

        int size = scores.size();

        for (int i = 1; i < size; i++) {

            if (scores.get(i).score == scores.get(0).score) {

                sb.append(", ").append(scores.get(i).toString());

            }

        }



        return sb.toString();

    }

}