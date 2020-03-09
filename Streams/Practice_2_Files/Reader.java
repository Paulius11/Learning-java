package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
	public static String FILENAME = "C:\\Users\\Sup\\eclipse-workspace\\streams\\src\\streams\\wordlist.txt";
	public static String FILENAME_OUTPUT = "C:\\Users\\Sup\\eclipse-workspace\\streams\\src\\streams\\twitter-words.txt";
	public static String ECLIPSE_DIR = "C:\\Users\\Sup\\eclipse-workspace\\";

	public static void main(String[] args) {
		System.out.println("1. Print the first 10-letter word found in the fileb");
		printFileContentLimit10();

		System.out.println("Print the first 8-letter word that contains “a”, “b”, and “c”.");
		printContainingLetterabc();

		System.out.println(
				"Repeat the previous problem, but handle the possibility of mixed-case words in the file. Hint: do\r\n"
						+ "something shorter than merely modifying your filter tests to include “A”, “B”, and “C”.");
		printContainingLetterabcABC();

		System.out.println("Print the longest English word that contains neither “a” nor “e”");
		findLongestString();

		System.out.println("5. Print the shortest English word that contains a “q”.");
		findShortestString();

		System.out.println(
				"Make a file called “twitter-words.txt” that contains all words from the enable1 list that contain\r\n"
						+ "“wow” or “cool”. The words should be sorted, in uppercase, and have an exclamation point at the\r\n"
						+ "end. (E.g., “COOLER!”).");
		twitterWords();

		System.out.println("7. Print out the number of files in your Eclipse project. Folders count as files.");
		filesAndFoldersInEclipseProject();

	}

	private static void filesAndFoldersInEclipseProject() {
		try (Stream<Path> walk = Files.walk(Paths.get(ECLIPSE_DIR))) {

			List<String> result = walk.filter(arg0 -> Files.isDirectory(arg0) || Files.isRegularFile(arg0))
					.map(x -> x.toString()).collect(Collectors.toList());

			System.out.println(result.size());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void twitterWords() {
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
			Iterable<String> parsedText = stream.filter(x -> x.contains("wow") || x.contains("cool"))
					.map(x -> x.toUpperCase() + "!").sorted()::iterator;

			Files.write(Paths.get(FILENAME_OUTPUT), parsedText);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void findShortestString() {
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
			String shortestString = stream.filter(x -> x.contains("q")).min(Comparator.comparingInt(String::length))
					.orElse(null);
			System.out.println(shortestString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void findLongestString() {
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
			String longestString = stream.filter(x -> !x.contains("a") && !x.contains("b"))
					.max(Comparator.comparingInt(String::length)).orElse(null);
			System.out.println(longestString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printContainingLetterabcABC() {
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
			stream.filter(x -> x.toLowerCase().contains("a") && x.toLowerCase().contains("b")
					&& x.toLowerCase().contains("c")).limit(8).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printContainingLetterabc() {
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
			stream.filter(x -> x.contains("a") && x.contains("b") && x.contains("c")).limit(8)
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printFileContentLimit10() {
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
			stream.limit(10).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
