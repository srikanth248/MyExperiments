public class FindFirstOne {

    public static void main(String[] args) {
        int[][] nums = {{1, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 1}};
        System.out.println(findFirstOne(nums));
    }

    private static int findFirstOne(int[][] nums) {
        for (int i = 0; i < nums[0].length; i++) {
            int j = i;
            int result = 0;
            while(result == 0 && j < nums.length) {
                result += nums[j][i];
                j++;
            }
            if(result > 0) {
                return i;
            }
        }
        return -1;
    }
}
