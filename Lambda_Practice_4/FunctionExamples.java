package smagu;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionExamples {
	static class FunctionUtils {

		@SafeVarargs
		public static String firstAllMatch(Stream<String> stream, Predicate<String>... lamdas) {
			Predicate<String> predicate = e -> true;
			for (Predicate<String> lamda : lamdas)
				predicate = predicate.and(lamda);

			return stream.filter(predicate).findFirst().orElse(null);
		}

		public static <T> Predicate<T> anyPassPredicate(Predicate<T>... predicates) {
			Predicate<T> predicatesAndJoin = e -> true;
			for (Predicate<T> singlePredicate : predicates)
				predicatesAndJoin = predicatesAndJoin.and(singlePredicate);
			return predicatesAndJoin;
		}

		@SafeVarargs
		public static String firstAnyMatch(Stream<String> stream, Predicate<String>... lamdas) {
			Predicate<String> joinedLamdasPredicate = e -> true;
			joinedLamdasPredicate = anyPassPredicate(lamdas);
			return stream.filter(joinedLamdasPredicate).findFirst().orElse(null);
		}

	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("hello", "hola", "goodbye", "adios");

		String word1 = FunctionUtils.firstAllMatch(words.stream(), s -> s.contains("g"), s -> s.length() > 4);
		System.out.println("First word with o and 5+ letters is " + word1);

		String word2 = FunctionUtils.firstAllMatch(words.stream(), s -> s.contains("o"), s -> s.length() < 8);
		System.out.println("First word with o and 8+ letters is " + word2);

		String word3 = FunctionUtils.firstAnyMatch(words.stream(), s -> s.contains("o"), s -> s.length() > 5);
		System.out.println("First word with o or 5+ letters is " + word3);

		String word4 = FunctionUtils.firstAnyMatch(words.stream(), s -> s.contains("o"), s -> s.length() > 8);
		System.out.println("First word with o or 8+ letters is " + word4);

		String word5 = FunctionUtils.firstAnyMatch(words.stream(), s -> s.contains("q"), s -> s.length() > 8);
		System.out.println("First word with q or 8+ letters is " + word5);
	}

}