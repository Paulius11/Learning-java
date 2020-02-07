public class ElementUtils {

     public static <T> T betterElement(T t1, T t2, TwoElementPredicate<T> twoElPredicate) {
        if (twoElPredicate.betterElement(t1, t2)) {
            return t1;
        } else {
            return t2;
        }
    }
}
