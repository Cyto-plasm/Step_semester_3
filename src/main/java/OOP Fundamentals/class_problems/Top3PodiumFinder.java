import java.util.Arrays;

public class Top3PodiumFinder {
    static int[] findTopThreeScores(int[] scores) {
        int first = 0;
        int second = 0;
        int third = 0;
        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }
        return new int[]{first, second, third};
    }
    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] result = findTopThreeScores(scores);
        System.out.println(Arrays.toString(result));
    }
}