public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 3, 12, 7, 2, 11, 9};
        doQuickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void doQuickSort(int[] nums) {
        sortIt(nums, 0, nums.length - 1);
        int pi = partition(nums, 0, nums.length - 1);
    }

    private static void sortIt(int[] nums, int low, int high) {
        if(low < high) {
            int pi = partition(nums, low, high);

            sortIt(nums, low, pi-1);
            sortIt(nums, pi +1 , high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;
        return i + 1;
    }
}
