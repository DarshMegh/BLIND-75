public class HouseRobber {

    public int rob(int[] nums) {

        int rob = 0;
        int skip = 0;

        for (int num : nums) {

            int newRob = skip + num;

            skip = Math.max(skip, rob);

            rob = newRob;
        }

        return Math.max(rob, skip);
    }
}