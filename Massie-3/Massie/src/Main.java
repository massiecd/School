import java.util.Scanner;

public class Main {
	
	public static ItemToPurchase getItemForCart(final Scanner scnr) {
		ItemToPurchase item = new ItemToPurchase();
		String line;
		System.out.println("Enter the item name: ");
		line = scnr.nextLine();
		item.setName(line);
		System.out.println("Enter the item price: ");
		line = scnr.nextLine();
		item.getPrice(Integer.valueOf(line));
		System.out.println("Enter the item quantity: ");
		line = scnr.nextLine();
		item.setQuantity(Integer.valueOf(line));

		return item;
	}

	public static void main(final String[] args) {
		final int MAX_CART_ITEMS = 2;
		ShoppingCartPrinter cart = new ShoppingCartPrinter();

		Scanner scnr = new Scanner(System.in);
		for (int i = 1; i <= MAX_CART_ITEMS; i++) {
			System.out.println("Item " + i);
			cart.add(getItemForCart(scnr));
			System.out.println();
		}

		cart.printTotal();
	}
}
