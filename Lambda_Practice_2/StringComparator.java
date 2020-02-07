import java.util.Comparator;

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        return s.length() - t1.length();
    }
}
