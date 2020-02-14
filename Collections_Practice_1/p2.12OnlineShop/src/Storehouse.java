import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Storehouse {
	private Map<String, Integer> productsPrice = new HashMap<>();
	private Map<String, Integer> productsStock = new HashMap<>();

	public void addProduct(String product, int price, int stock) {
		productsPrice.put(product, price);
		productsStock.put(product, stock);
	}

	public int price(String product) {
		return productsPrice.getOrDefault(product, -99);
	}

	public int stock(String product) {
		return productsStock.getOrDefault(product, 0);
	}

	public boolean take(String product) {
		int currentProduct = productsStock.getOrDefault(product, -99);
		if (currentProduct > 0) {
			productsStock.put(product, --currentProduct);
			return true;
		}
		return false;
	}

	public Set<String> products() {
		Set<String> poducts = new TreeSet<>();
		poducts.addAll(productsPrice.keySet());
		return poducts;

	}
}
