
public class ItemToPurchase {

	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	
	public ItemToPurchase() {
		this.itemName = "none";
		this.itemPrice = 0;
		this.itemQuantity = 0;
	}
	
	public ItemToPurchase setName(
		final String itemName) {
		this.itemName = itemName;
		return this;
	}
	
	public String getName() {
		return itemName;
	}
	
	public ItemToPurchase setPrice(
		final int itemPrice) {
		this.itemPrice = itemPrice;
		return this;
	}
	
	public int getPrice() {
		return itemPrice;
	}
	
	public ItemToPurchase setQuantity(
		final int itemQuantity) {
		this.itemQuantity = itemQuantity;
		return this;
	}
	
	public int getQuantity() {
		return itemQuantity;
	}
}
