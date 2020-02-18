package smagu;

class CarNumberPricingCalculator {

	private String number;

	public CarNumberPricingCalculator() {
	}

	public CarNumberPricingCalculator(String number) {
		super();
		this.number = number;
		checkIfPlateIsValid(number);
	}

	private void checkIfPlateIsValid(String number) {
		if (number.isEmpty() || number.length() > 6)
			throw new IllegalArgumentException(
					"Incorrect plate number format. Must be 1-6 symbols latin letters and number combination");
	}

	/**
	 * Naudojam TDD Kursime programą Regitrai, kuri turi paskaičiuoti kainą pagal
	 * pageidautiną automobilio numerį. Kainą politika yra tokia: Jeigu visos trys
	 * raidės yra vienodos, arba jeigu visi trys skaičiai vienodi arba "001","666" -
	 * numerio kaina 1000 eur. Jeigu trys raidės vienodos IR trys skaičiai vienodi -
	 * numerio kaina 5000 EUR. Jeigu raidžių rinkinys yra vienas iš "GOD", "KLR",
	 * "BOS" numerio kaina 2000 EUR. Jeigu prie aukščiau minėto raidžių rinkinio
	 * pridėsime tris vienodus skaičius - 7000 EUR. Jeigu numeris yra ne iš trijų
	 * simbolių ir trijų skaičių (1-6 simboliai) jis yra vardinis - kaina 10 000
	 * EUR. Jei skaičiuoklei paduodamas blogo formato numeris - turi mesti
	 * IllegalArgumentException su pranešimu - "Incorrect plate number format. Must
	 * be 1-6 symbols latin letters and number combination" mažosiomis ir d P.S.
	 * NIEKADA realiose sistemose nenaudokite float/double pinigų ir kitoms
	 * tikslioms operacijoms tam naudokite BigDecimal tipą!
	 */

	public double calculatePrice(String number) {
		if(number.length() == 6) {
			String letters = number.substring(0, 3);
			String numbers = number.substring(3);

			
		}
		
		return 0.0;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		checkIfPlateIsValid(number);
		this.number = number;
	}

}
