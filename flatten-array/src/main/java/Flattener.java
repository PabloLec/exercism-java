import java.util.*;

public class Flattener {

    public static List<Object> flatten(List<Object> originalList) {
        List<Object> result = new ArrayList<Object>();

        for (Object o : originalList) {
            if (o == null)
                continue;
            if (o instanceof List<?>) {
                List<Object> nested = flatten((List<Object>) o);
                for (Object o2 : nested) {
                    result.add(o2);
                }
            } else {
                result.add(o);
            }
        }

        return result;

    }
}
