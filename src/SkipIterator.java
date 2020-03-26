import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SkipIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer peekedValue;
    private Map<Integer, Integer> skippedValues;

    public SkipIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        skippedValues = new HashMap<>();
    }

    @Override
    public boolean hasNext() {
        if(peekedValue == null) {
            while(iterator.hasNext()) {
                int possibleNextValue = iterator.next();
                if(skippedValues.containsKey(possibleNextValue)) {
                    skippedValues.put(possibleNextValue, skippedValues.get(possibleNextValue)-1);
                    if(skippedValues.get(possibleNextValue) == 0) {
                        skippedValues.remove(possibleNextValue);
                    }
                } else {
                    peekedValue = possibleNextValue;
                    return true;
                }
            }
            //Reached the end of iterator. Set a false peekedValue
            peekedValue = Integer.MIN_VALUE;
            return false;
        } else return peekedValue != Integer.MIN_VALUE;
    }

    @Override
    public Integer next() {
        if(hasNext()) {
            int tmp = peekedValue;
            peekedValue = null;
            return tmp;
        }
        return null;
    }

    public void skip(Integer skip) {
        skippedValues.put(skip, skippedValues.getOrDefault(skip, 0)+1);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 5, 6, 5, 7, 5, -1, 5, 10};
        SkipIterator itr = new SkipIterator(Arrays.asList(arr).iterator());
        System.out.println(itr.hasNext()); // true
        System.out.println(itr.next()); // returns 2
        itr.skip(5);
        System.out.println(itr.next()); // returns 3
        System.out.println(itr.next()); // returns 6 because 5 should be skipped
        System.out.println(itr.next()); // returns 5
        itr.skip(5);
        itr.skip(5);
        System.out.println(itr.next()); // returns 7
        System.out.println(itr.next()); // returns -1
        System.out.println(itr.next()); // returns 10
        System.out.println(itr.hasNext()); // false
        System.out.println(itr.next()); // error

        Integer[] arr1 = new Integer[]{2, 3, 5, 6, 5, 7, 5, -1, 5, 10};
        SkipIterator itr1 = new SkipIterator(Arrays.asList(arr).iterator());
        System.out.println(itr1.hasNext()); // true
        System.out.println(itr1.next()); // returns 2
        System.out.println(itr1.next()); // returns 3
        itr1.skip(5);
        itr1.skip(6);
        itr1.skip(5);
        itr1.skip(7);
        itr1.skip(5);
        itr1.skip(-1);
        itr1.skip(5);
        itr1.skip(10);

        System.out.println(itr1.hasNext()); // false
        System.out.println(itr1.next()); // error
    }
}
