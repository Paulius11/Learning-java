package boxes;

public class Thing {

	private String name;
	private int weight;

	public Thing(String name, int weight) {
		if (weight < 0)
			throw new IllegalArgumentException();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Thing other = (Thing) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Thing(String name) {
		this(name, 0);
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

}
