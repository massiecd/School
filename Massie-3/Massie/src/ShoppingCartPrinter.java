import java.util.ArrayList;
import java.util.Collection;

public class ShoppingCartPrinter {
	private Collection<ItemToPurchase> cartItems = new ArrayList<>();
	private int totalCost = 0;
	
	public void add(
		final ItemToPurchase item) {
		cartItems.add(item);
		totalCost += item.getSubtotal();
	}
	
	public void printTotal() {
		System.out.println();
		System.out.println("TOTAL COST");
		
		for (ItemToPurchase item : cartItems) {
			System.out.println(item.getName() + " " + item.getQuantity() + " @ $" + item.getPrice() + " = $" + item.getSubtotal());
		}
		System.out.println();
		System.out.println("Total: $" + totalCost);
	}
}
