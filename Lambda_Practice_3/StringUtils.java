package Lambda_Practice_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringUtils {

    public static List<String> allMatches(List<String> strList, Predicate<String> predicate) {
        List<String> arrayList = new ArrayList<>();
        for (String element : strList) {
            if (predicate.test(element)) {
                arrayList.add(element);
            }
        }
        return arrayList;
    }

    public static <R, T> List<String> transformedList(List<String> words, Function<String, String> function) {
        List<String> alteredArrayList = new ArrayList<>();
        for (String word: words){
            String changedString = function.apply(word);
            alteredArrayList.add(changedString);
        }

        return alteredArrayList;
    }


}
