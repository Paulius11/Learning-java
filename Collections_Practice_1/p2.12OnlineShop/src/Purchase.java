
public class Purchase {

	private String product;
	private int amount;
	private int unitPrice;

	public Purchase(String product, int amount, int unitPrice) {
		super();
		this.product = product;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + unitPrice;
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
		Purchase other = (Purchase) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (unitPrice != other.unitPrice)
			return false;
		return true;
	}

	public int price() {
		return unitPrice * amount;
	}

	public String getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}

	public void increaseAmount() {
		amount++;
	}

	@Override
	public String toString() {
		return String.format("%s: %d", product, amount);
	}
}
