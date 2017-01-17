import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ShoppingCartPrinter {
	private static final int MAX_CART_ITEMS = 2;
	
	public static ItemToPurchase getItemForCart(
		final Scanner scnr) {
		ItemToPurchase item = new ItemToPurchase();
		String line;
		System.out.println("Enter the item name: ");
		line = scnr.nextLine();
		item.setName(line);
		System.out.println("Enter the item price: ");
		line = scnr.nextLine();
		item.setPrice(Integer.valueOf(line));
		System.out.println("Enter the item quantity: ");
		line = scnr.nextLine();
		item.setQuantity(Integer.valueOf(line));	
		
		return item;
	}
	
	public static void printTotal(
		final Collection<ItemToPurchase> cartItems) {
		//System.out.println();
		System.out.println("TOTAL COST");
		
		int totalCost = 0;
		int itemCost = 0;
		for (ItemToPurchase item : cartItems) {
			itemCost = item.getPrice() * item.getQuantity();
			totalCost += itemCost;
			System.out.println(item.getName() + " " + item.getQuantity() + " @ $" + item.getPrice() + " = $" + itemCost);
		}
		System.out.println();
		System.out.println("Total: $" + totalCost);
	}
	
	public static void main(final String[] args) {
		Collection<ItemToPurchase> cart = new ArrayList<>();
		
		Scanner scnr = new Scanner(System.in);
		for (int i = 1; i <= MAX_CART_ITEMS; i++) {
			System.out.println("Item " + i);
			cart.add(getItemForCart(scnr));
			System.out.println();
		}
		
		printTotal(cart);
	}
}
