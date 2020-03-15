import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class ExcersiceImpl implements Exercises {

	// TODO: fix IntegerGenerator
	IntegerGenerator generator = new IntegerGenerator() {

		@Override
		public Integer getNext() {
			return null;
		}
	};

	@Override
	public List<Integer> computeNumbersUpTo(int numberUpTo) {
		return IntStream.range(1, numberUpTo).boxed().collect(Collectors.toList());
	}

	@Override
	public int computeSumOfNumbers(int number) {
		return IntStream.rangeClosed(1, number).boxed().reduce(0, Integer::sum);
	}

	@Override
	public int computeSumOfNumbers(int number, NumberFilter filter) {
		return IntStream.rangeClosed(1, number).boxed().filter(filter::accept).reduce(0, Integer::sum);
	}

	@Override
	public List<Integer> consume(Iterator<Integer> it) {
		List<Integer> list = new ArrayList<>();
		if (it.hasNext())
			list.add(it.next());
		return list;
	}

	@Override
	public Map<Integer, Integer> countOccurrences(List<Integer> numbers) {
		Map<Integer, Integer> mapIng = new HashMap<>();
		for (Integer integer : numbers) {
			int count = mapIng.containsKey(integer) ? mapIng.get(integer) : 0;
			mapIng.put(integer, count + 1);
		}
		return mapIng;
	}

	@Override
	public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator generator, NumberFilter filter) {
		return null;
	}

	@Override
	public IntegerGenerator createIntegerGenerator(int from, int to) {

		return null;
	}

	@Override
	public Integer findLargest(List<Integer> numbers) {
		return numbers.stream().reduce(Integer::max).orElse(null);
	}

	@Override
	public Integer findSmallest(List<Integer> numbers) {
		return numbers.stream().reduce(Integer::min).orElse(null);
	}

	@Override
	public boolean isEqual(Object lhs, Object rhs) {
		return lhs.equals(rhs);
	}

	@Override
	public boolean isSameObject(Object lhs, Object rhs) {
		return lhs == rhs;
	}

}
