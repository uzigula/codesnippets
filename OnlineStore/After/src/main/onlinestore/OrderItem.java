package onlinestore;

public class OrderItem {
	
	public Product product;
	public int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public float total() {
		return unitPricePerQuantity() - createCategoryDiscount().calculateDiscount(this);
	}

	private CategoryDiscount createCategoryDiscount() {
		CategoryDiscount categoryDiscount=null;
		if (getProduct().getCategory() == Category.Accessories) {
			categoryDiscount = new AccessoriesDiscount();
		}
		if (getProduct().getCategory() == Category.Bikes) {
			categoryDiscount = new BikesDiscount();
		}
		if (getProduct().getCategory() == Category.Cloathing) {
			categoryDiscount = new CloathingDiscount();
		}
		return categoryDiscount;
	}

	float unitPricePerQuantity() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
