package Lambda_Practice_3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Run {
    /*
        Some general notes:
        • Arrays.asList is a simple way to make a List. E.g.:
            List<String> words = Arrays.asList("hi", "hello", ...);
        • List has a useful toString method, so you can directly print a List (unlike an array). E.g.:
            System.out.println(words);
        • Remember that Predicate (problems 1 and 2) and Function (problems 3 and 4) are in the
            java.util.function package.

        1. Make a static method called allMatches. It should take a List of Strings and a
            Predicate<String>, and return a new List of all the values that passed the test. Test it with several
            examples. E.g.:
            • List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
            • List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
            • List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
    */
    public static void main(String[] args) {
        System.out.println("1. . Make a static method called allMatches ");
        List<String> words = Arrays.asList("hi", "hello", "labas");
        List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        System.out.println(words);
        System.out.println(shortWords);

/*
        2. Redo allMatches so it works on any List and associated Predicate, not just on Strings.
        Verify that your examples from #1 still work. But now, you should be able to also do things like this:
            • List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
            • List<Integer> bigNums = ElementUtils.allMatches(nums, n -> n>500);
*/
        System.out.println("2. AllMatches so it works on any List");
        List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
        List<Integer> bigNums = ElementUtils.allMatches(nums, n -> n > 500);
        List<String> shortWords2 = ElementUtils.allMatches(words, s -> s.length() < 4);
        System.out.println(nums);
        System.out.println(bigNums);
        System.out.println(shortWords2);

/*

        3. Make a static method called transformedList. It should take a List of Strings and a
        Function<String,String> and return a new List that contains the results of applying the Function to
        each element of the original List. E.g.:
            • List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
            • List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
            • List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
*/
        List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
        List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
        List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
        System.out.println("3. Function<String,String> ");
        System.out.println(excitingWords);
        System.out.println(eyeWords);
        System.out.println(upperCaseWords);

/*
        4. Redo transformedList so it works with generic types. Verify that your examples from #3 still work.
        But now, you should also be able to also do things like this:
            • List<Integer> wordLengths = ElementUtils.transformedList(words, String::length);
            Notice above that I am passing in a List of Strings, but getting out a List of Integer. Make sure your
            generic types support this idea.
        */
        List<Integer> wordLengths = ElementUtils.transformedList(words, String::length);
        List<Integer> wordLengths2 = ElementUtils.transformedList(words, (a) -> a.length() );

        excitingWords = ElementUtils.transformedList(words, s -> s + "!");
        eyeWords = ElementUtils.transformedList(words, s -> s.replace("i", "eye"));
        upperCaseWords = ElementUtils.transformedList(words, String::toUpperCase);

        System.out.println("4. Redo transformedList so it works with generic types");
        System.out.println(words);
        System.out.println(wordLengths);
        System.out.println(wordLengths2);
        System.out.println(excitingWords);
        System.out.println(eyeWords);
        System.out.println(upperCaseWords);
    }
}
