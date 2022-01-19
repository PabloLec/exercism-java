import java.util.*;

public class BinarySearch {
    List<Integer> list;
    int value;
    int min = 0;
    int max;

    BinarySearch(List<Integer> list) {
        this.list = list;
        this.max = list.size() - 1;
    }

    public int split() throws ValueNotFoundException {
        int middle = (int) (max / 2 + min / 2);
        if (max - min == 1) {
            if (list.get(min) == value) {
                return min;
            } else if (list.get(max) == value) {
                return max;
            }
            throw new ValueNotFoundException("Value not in array");
        }
        if (list.get(middle) == value) {
            return middle;
        } else if (list.get(middle) > value) {
            max = middle;
            return split();
        } else {
            min = middle;
            return split();
        }
    }

    public int indexOf(Integer value) throws ValueNotFoundException {
        if (list.size() == 0) {
            throw new ValueNotFoundException("Value not in array");
        }
        this.value = value;
        return split();
    }
}
