import java.util.*;

public class FatorialDesajeitado {
    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).nextLine());
        int res;
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n);
            n--;
        }
        List<Integer> stepExpression = nums;
        for (int i = 4; i > 1; i--) {
            stepExpression = expression(stepExpression, i);
        }
        res = sum(stepExpression);
        System.out.println(res);
    }

    private static List<Integer> expression(List<Integer> list, int step) {
        int count = step;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (step == 2) count = negatives(list, step, result, count, i);
            else {
                boolean nextExpression = list.size() != (i + 1);
                if ((count == step) && (nextExpression)) {
                    if (step == 4) {
                        result.add(list.get(i) * list.get(i + 1));
                    } else if (step == 3) {
                        result.add(list.get(i) / list.get(i + 1));
                    }
                    count = count - 2;
                    i++;
                } else {
                    result.add(list.get(i));
                    if (count > 1) count--;
                    else count = step;
                }
            }
        }
        return result;
    }

    private static int negatives(List<Integer> list, int step, List<Integer> result, int count, int i) {
        if ((count == step) && (i > 1)) {
            result.add(-1 * list.get(i));
            count--;
        } else {
            result.add(list.get(i));
            if (count > 1) count--;
            else count = step;
        }
        return count;
    }

    private static int sum(List<Integer> list) {
        int result = 0;
        for (Integer element : list) {
            result += element;
        }
        return result;
    }
}