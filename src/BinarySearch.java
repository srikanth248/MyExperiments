public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40 };
        System.out.println(binarySearch(arr, 0, arr.length -1, 10));
    }

    private static int binarySearch(int[] nums, int left, int right, int elementToFind) {
        if(left < right) {
            int middle = left + (right -left)/2;
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
