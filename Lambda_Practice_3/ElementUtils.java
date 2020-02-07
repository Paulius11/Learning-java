package Lambda_Practice_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ElementUtils {

    public static <T> List<T> allMatches(List<T> array, Predicate<T> predicate) {
        List<T> arrayList = new ArrayList<>();
        for (T element : array) {
            if (predicate.test(element)) {
                arrayList.add(element);
            }
        }
        return arrayList;
    }


    public static <T, R> List<R> transformedList(List<T> array, Function<T, R> consumer) {
        List<R> list = new ArrayList<>();
        for (T element : array) {
            list.add(consumer.apply(element));
        }
        return list;
    }
}
