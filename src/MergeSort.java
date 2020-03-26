import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 3, 12, 7, 2, 11, 9};
        doMergeSort(nums);
    }

    private static void doMergeSort(int[] nums) {
        divide(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void divide(int[] nums, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            divide(nums, left, middle);
            divide(nums, middle + 1, right);

            merge(nums, left, middle, right);
        }
    }

    private static void merge(int[] nums, int left, int middle, int right) {
        int firstArraySize = middle - left + 1;
        int secondArraySize = right - middle;
        int[] firstArray = new int[firstArraySize];
        int[] secondArray = new int[secondArraySize];
        for (int i = 0; i < firstArraySize; i++) {
            firstArray[i] = nums[left + i];
        }
        for (int j = 0; j < secondArraySize; j++) {
            secondArray[j] = nums[middle + 1 + j];
        }

        int p = 0;
        int q = 0;
        int k = left;
        while (p < firstArraySize && q < secondArraySize) {
            if (firstArray[p] < secondArray[q]) {
                nums[k] = firstArray[p];
                p++;
            } else {
                nums[k] = secondArray[q];
                q++;
            }
            k++;
        }

        while (p < firstArraySize) {
            nums[k] = firstArray[p];
            p++;
            k++;
        }
        while (q < secondArraySize) {
            nums[k] = secondArray[q];
            q++;
            k++;
        }
    }
}
