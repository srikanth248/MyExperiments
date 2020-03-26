import java.util.ArrayList;
import java.util.List;

public class IsJavaPassByValue {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        changeListValue(intList);
        for (Integer integer : intList) {
            System.out.println(integer);
        }

        int[] intArray = new int[2];
        intArray[0] = 1;
        changeArrValue(intArray);

        for (int i : intArray) {
            System.out.println(i);
        }
    }

    private static void changeArrValue(int[] intArray) {
        intArray = new int[2];
        intArray[0] = 2;
    }

    private static void changeListValue(List<Integer> intList) {
        //intList = new ArrayList<>();
        intList.add(2);
    }


}
