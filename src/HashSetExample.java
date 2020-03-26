import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        int[] intArr = new int[]{3, 4, 7, 7, 6, 6};
        Set<Integer> intSet = new HashSet<>();
        for (int i : intArr) {
            intSet.add(i);
        }
        System.out.println(Math.min((intArr.length)/2, intSet.size()));
    }
}
