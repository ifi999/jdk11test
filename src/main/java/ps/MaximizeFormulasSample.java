package ps;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://school.programmers.co.kr/learn/courses/30/lessons/67257
public class MaximizeFormulasSample {

    /**
     * 연산자는 무조건 실행 순위가 달라야한다.
     * 기존 사칙연산 같은 동일한 경우는 없어야한다. ( *,/ > +,- )
     *
     * expression은 길이가 3 이상 100 이하인 문자열이고, 오로지 숫자와 3가지 연산자( +, -, * )만으로 이루어진 연산식이다.
     * 피연산자(operand)는 0 이상 999 이하의 숫자이고, 적어도 1개 이상의 연산자를 포함한다.
     * 연산자 우선 순위를 어떻게 적용하더라도, expression의 중간 계산값과 최종 결괏갑은 절댓값이 2^63 -1 이하가 되어야 한다.
     * 같은 연산자끼리는 앞에 있는 것의 우선 순위가 더 높다.
     *
     * 풀이
     * 연산자가 최대 3개 밖에 없으므로, 재귀로 구현 가능 하지만 경우의 수가 적으므로 굳이 재귀를 이용하지 않아도 가능하다.
     *
     */

    private static final String[][] precedences = {
      "+-*".split(""),
      "+*-".split(""),
      "-*+".split(""),
      "-+*".split(""),
      "*+-".split(""),
      "*-+".split("")
    };

    private long calculate(long lhs, long rhs, String op) {
        long result = 0l;
        switch (op) {
            case "+" : result = lhs + rhs; break;
            case "-" : result = lhs - rhs; break;
            case "*" : result = lhs * rhs; break;
            default : result = 0; break;
        };

        return result;
    }

    private long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i -1));
                    long rhs = Long.parseLong(tokens.get(i +1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i -1);
                    tokens.remove(i -1);
                    tokens.remove(i -1);
                    tokens.add(i -1, String.valueOf(result));
                    i -= 2;
                }
            }
        }

        return Long.parseLong(tokens.get(0));
    }

    public static void main(String[] args) {
        MaximizeFormulasSample mfs = new MaximizeFormulasSample();
//        long result = mfs.solution("100-200*300-500+20");
        long result = mfs.solution("50*6-3*2");
        System.out.println("result = " + result);
    }

    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for (String[] precedence: precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if (value > max) max = value;
        }
        return max;
    }

}
