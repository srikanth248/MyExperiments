public class KadanesAlgorithm {

    public static void main(String[] args) {
        //int [] a = {-2,1,-3,4,-1,2,1,-5,4};
        int[] a = {-1};
        //findMaxSumSubArray(a);
        System.out.println(maxSubArray(a));
    }

    private static void findMaxSumSubArray(int[] a) {
        int maxSubArraySum = 0;
        int currentSum = 0;
        int startI = -1;
        int dist = 0;
        for(int i=0; i<a.length; i++) {
            currentSum = currentSum + a[i];
            if(currentSum < 0) {
                currentSum = 0;
                startI = -1;
                dist = 0;
            } else if(currentSum > maxSubArraySum) {
                maxSubArraySum = currentSum;
                if(startI == -1) {
                    startI = i;
                } else {
                    dist = i - startI;
                }
            }
        }
        System.out.println("Max Sum: "+maxSubArraySum);
        System.out.println("Sub Array: ");
        for (int i = startI; i <= startI+dist; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int maxSubArray(int[] nums) {
        int currentMax = 0;
        int totalMax = Integer.MIN_VALUE;
        int biggestNumber = Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i++) {
            biggestNumber = Math.max(biggestNumber, nums[i]);
            currentMax = Math.max(0, currentMax + nums[i]);
            totalMax = Math.max(currentMax, totalMax);
        }
        if(totalMax == 0) {
            totalMax = Math.max(biggestNumber, Integer.MIN_VALUE);
        }
        return totalMax;
    }
}
