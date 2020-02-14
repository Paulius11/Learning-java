import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingBasket {

	private List<Purchase> shopingBasket = new ArrayList<>();

	public void add(String name, int price) {
		boolean foundInBasket = false;
		for (Purchase purchase : shopingBasket) {
			if (purchase.getProduct() == name) {
				purchase.increaseAmount();
				foundInBasket = true;
			}
		}
		if (!foundInBasket)
			shopingBasket.add(new Purchase(name, 1, price));

	}

	public int price() {
		return shopingBasket.stream().mapToInt(Purchase::price).sum();
	}

	public void print() {
		Set<Purchase> shopingBasketSet = new HashSet<>(shopingBasket);
		shopingBasketSet.stream().forEach((x) -> System.out.println(x));
	}

	public static void main(String[] args) {
		ShoppingBasket basket = new ShoppingBasket();
		basket.add("milk", 3);
		basket.add("milk", 3);
		basket.print();
	}

}
