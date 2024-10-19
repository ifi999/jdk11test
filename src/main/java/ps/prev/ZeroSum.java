package ps.prev;

public class ZeroSum {

    public static void main(String[] args) {
//        int[] numbers = {1, 1, 1, 1};
        int[] numbers = {8, 3, 5, 7, 3, 4};

        int res = solution(numbers);
        System.out.println("res = " + res);
    }

    public static int solution(int[] numbers) {
        return countZeroSum(numbers, 0, 0 ,0);
    }

    public static int countZeroSum(int[] numbers, int idx, int currentSum, int targetSum){
        if (idx == numbers.length) return currentSum == targetSum ? 1 : 0;

        int positive = countZeroSum(numbers, idx +1, currentSum +numbers[idx], targetSum);
        int negative = countZeroSum(numbers, idx +1, currentSum -numbers[idx], targetSum);

        return (positive + negative) % 100000;
    }

}
