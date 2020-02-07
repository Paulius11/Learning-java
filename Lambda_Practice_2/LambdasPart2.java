import testClasses.Employee;

import java.util.Arrays;
import java.util.Comparator;

public class LambdasPart2 {

    public static void main(String[] args) {
        // 1. Basic lambdas. Make an array containing a few Strings. Sort it by
        String[] arrayOfStr = new String[]{"c#", "node", "erlang", "e#", "javascript", "java", "python", "Cobol"};

        // length (i.e., shortest to longest)

        Arrays.sort(arrayOfStr, (a, b) -> Integer.compare(a.length(), b.length()));

        // or
        Arrays.sort(arrayOfStr, (a, b) -> a.length() - b.length());

        // or
        Arrays.sort(arrayOfStr, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });

        // or
        Arrays.sort(arrayOfStr, new StringComparator());
        print(arrayOfStr, "Sorted length");

        // reverse length (i.e., longest to shortest)
        Arrays.sort(arrayOfStr, ((s, t1) -> t1.length() - s.length()));
        print(arrayOfStr, "Reverse sorted");
        // or
        Arrays.sort(arrayOfStr, Comparator.reverseOrder());


        // alphabetically by the first character only
        Arrays.sort(arrayOfStr, (a, b) -> a.charAt(0) - b.charAt(0));
        print(arrayOfStr, "Sorted alphabetically");

        // Strings that contain “e” first, everything else second. For now, put the code directly in the lambda.
        Arrays.sort(arrayOfStr, (a, b) -> {
            if (a.charAt(0) == 'c' || b.charAt(0) == 'c')
                return -1;
            else
                return 1;
        });
        print(arrayOfStr, "'e' letter first");

/*
         Redo the previous problem, but use a static helper method so that your lambda looks like this:
         Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
*/

        Arrays.sort(arrayOfStr, ((s, t1) -> sortByjLetter(s, t1)));
        print(arrayOfStr, "Sorting by 'j' letter");



/*

    Exercises: Lambda Expressions Part 1

Making your own interfaces for which lambdas can be used. Your eventual goal is to make a
method called betterString that takes two Strings and a lambda that says whether the first of the two
is “better”. The method should return that better String; i.e., if the function given by the lambda
returns true, the betterString method should return the first String, otherwise betterString should
return the second String. Here are two examples of how your code should work when it is finished
    (the first lambda example returns whichever of string1 and string2 is longer, and the second lambda
            example always returns string1).
    • String string1 = ...;
    • String string2 = ...;
    • String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
    • String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
Accomplishing all of this requires you to do three things:
• Define the TwoStringPredicate interface. It will specify a method that takes 2 strings and returns a
boolean. This interface is normal Java 7 code.
• Define the static method betterString. That method will take 2 strings and an instance of your
interface. It returns string1 if the method in interface returns true, string2 otherwise. This method
is normal Java 7 code.
• Call betterString. You can now use lambdas for the 3rd argument, as in the examples above.
*/
        String string1 = "java";
        String string2 = "javascript";


        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        print("Printing  Lambda Expressions Part 1");
        print(longer);

/*
3. Making generically-typed interfaces for which lambdas can be used. Use generics to replace

your String-specific solutions to problem 3 with generically typed solutions. That is, replace better-
String with betterEntry and TwoStringPredicate with TwoElementPredicate. Make sure your previ-
ous examples still work when you only change betterString to betterElement. But, now you should

also be able to supply two Cars and a Car predicate, two Employees and an Employee predicate,
etc. For example:
    • ElementUtils.betterElement(string1, string2, (s1, s2) -> s1.length() > s2.length())
    • ElementUtils.betterElement(car1, car2, (c1, c2) -> c1.getPrice() > c2.getPrice())
    • ElementUtils.betterElement(employee1, employee2, (e1, e2) -> e1.getSalary() > e2.getSalary())

*/

        Employee employee1 = new Employee(100);
        Employee employee2 = new Employee(1000);

        String aws = ElementUtils.betterElement("python", "c++", (s1, s2) -> s1.length() > s2.length());
        Employee emp = ElementUtils.betterElement(
                employee1, employee2,
                (e1, e2) -> employee1.getSalary() > employee2.getSalary());
        print("Generics");
        print(aws);
        System.out.println(emp);
    }


    private static int sortByjLetter(String s, String t1) {
        if (s.charAt(0) == 'j' || t1.charAt(0) == 'j')
            return -1;
        else
            return 1;
    }


    private static <T> void print(T array[], String message) {
        System.out.println(message);
        System.out.println(Arrays.asList(array));
    }

    private static void print(String msg) {
        System.out.println(msg);
    }


}
