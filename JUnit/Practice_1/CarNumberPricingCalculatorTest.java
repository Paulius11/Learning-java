package smagu;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CarNumberPricingCalculatorTest {

	private CarNumberPricingCalculator priceCalc;

	@Before
	public void setUp() throws Exception {
		priceCalc = new CarNumberPricingCalculator();
	}

	@Test
	public void testWhenCostAre1000() {
		double resultPrice = 1000.0;
		List<String> testCases = Arrays.asList("AAA123", "ABC111", "DEF001", "DEF666");
		testCases.stream().forEach(x -> assertEquals("Cost must be must be " + resultPrice, resultPrice,
				this.priceCalc.calculatePrice(x), 0));

	}

	@Test
	public void testWhenCostAre5000() {
		double resultPrice = 5000.0;
		List<String> testCases = Arrays.asList("AAA111", "ZZZ999");
		testCases.stream().forEach(x -> assertEquals("Cost must be must be " + resultPrice, resultPrice,
				this.priceCalc.calculatePrice(x), 0));

	}

	@Test
	public void testWhenCostAre2000() {
		double resultPrice = 1000.0;
		List<String> testCases = Arrays.asList("GOD123", "KLR123", "BOS123");
		testCases.stream().forEach(x -> assertEquals("Cost must be must be " + resultPrice, resultPrice,
				this.priceCalc.calculatePrice(x), 0));
	}

	@Test
	public void testWhenCostAre7000() {
		double resultPrice = 7000.0;
		List<String> testCases = Arrays.asList("GOD111", "KLR222", "BOS333");
		testCases.stream().forEach(x -> assertEquals("Cost must be must be " + resultPrice, resultPrice,
				this.priceCalc.calculatePrice(x), 0));
	}

	@Test
	public void testWhenCost10000() {
		double resultPrice = 10_000.0;
		List<String> testCases = Arrays.asList("HELLO", "AS", "LABAS", "11111");
		testCases.stream().forEach(x -> assertEquals("Cost must be must be " + resultPrice, resultPrice,
				this.priceCalc.calculatePrice(x), 0));

	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void testIllegalPlateNumber() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(
				"Incorrect plate number format. Must be 1-6 symbols latin letters and number combination");
		priceCalc.setNumber("");

	}

}
