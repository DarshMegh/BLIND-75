// CombinationSum.java

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> result =
                new ArrayList<>();

        backtrack(
                result,
                new ArrayList<>(),
                candidates,
                target,
                0
        );

        return result;
    }

    private void backtrack(
            List<List<Integer>> result,
            List<Integer> temp,
            int[] nums,
            int remain,
            int start) {

        if (remain < 0) {
            return;
        }

        if (remain == 0) {

            result.add(
                    new ArrayList<>(temp)
            );

            return;
        }

        for (int i = start;
             i < nums.length;
             i++) {

            temp.add(nums[i]);

            backtrack(
                    result,
                    temp,
                    nums,
                    remain - nums[i],
                    i
            );

            temp.remove(
                    temp.size() - 1
            );
        }
    }

    public static void main(String[] args) {

        CombinationSum obj =
                new CombinationSum();

        System.out.println(
                obj.combinationSum(
                        new int[]{2,3,6,7},
                        7
                )
        );
    }
}