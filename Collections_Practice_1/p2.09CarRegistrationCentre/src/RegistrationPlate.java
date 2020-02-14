
public class RegistrationPlate {
	// don't change the code which is already given to you

	// ATTENTION: the object variable types are final, meaning that their value
	// cannot be changed!
	private final String regCode;
	private final String country;

	public RegistrationPlate(String country, String regCode) {
		this.regCode = regCode;
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((regCode == null) ? 0 : regCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationPlate other = (RegistrationPlate) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (regCode == null) {
			if (other.regCode != null)
				return false;
		} else if (!regCode.equals(other.regCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return country + " " + regCode;
	}

}