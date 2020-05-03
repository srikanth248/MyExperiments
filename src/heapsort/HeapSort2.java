public class HeapSort2
{
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i= n/2 -1; i >=0; i--) {   // What's happening here? You want to start at the middle of the Binary Tree.
            heapify(arr, n, i);            // That usually one level above the base level.
                                            // Then swap
        }
        for(int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int total, int current) {
        int largest = current;
        int left = 2 * current + 1;
        int right = 2 * current + 2;

        if(left < total && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < total && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != current) {
            int temp = arr[current];
            arr[current] = arr[largest];
            arr[largest] = temp;
            heapify(arr, total, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}