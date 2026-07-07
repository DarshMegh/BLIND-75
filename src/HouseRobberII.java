public class HouseRobberII {

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        return Math.max(
                rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1)
        );
    }

    private int rob(int[] nums, int left, int right) {

        int rob = 0;
        int skip = 0;

        for (int i = left; i <= right; i++) {

            int newRob = skip + nums[i];

            skip = Math.max(skip, rob);

            rob = newRob;
        }

        return Math.max(rob, skip);
    }
}