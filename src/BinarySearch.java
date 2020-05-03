import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        System.out.println(binarySearch(arr, 0, arr.length -1, 30));
        binarySearch(arr, 10);
    }

    private static int binarySearch(int[] nums, int left, int right, int elementToFind) {
        int middle = -1;
        if(left <= right) {
            middle = (left + right)/2;
            if(nums[middle] == elementToFind) {
                return middle;
            }
            if(nums[middle] < elementToFind) {
                return binarySearch(nums, middle+1, right, elementToFind);
            } else {
                return binarySearch(nums, left, middle -1, elementToFind);
            }
        }
        return -1;
    }
}
