public class StringUtils  {

    static String betterString(String s1, String s2, TwoStringPredicate lambda) {
        if(lambda.betterString(s1, s2))
            return s1;
        else
            return s2;

    }
}
