package onlinestore;

public class Product {

	/* The Name */
	private String name;

	/* The UnitPrice */
	private float unitPrice;

	/* The Category */
	private Category category;

	/* The Image */
	private ImageInfo image;

	/* The Category */
	private int unitsInStock;

	public Product(String name, float unitPrice, Category category, ImageInfo image) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.category = category;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public Category getCategory() {
		return category;
	}

	public ImageInfo getImage() {
		return image;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String toXml() {
		return "<product>" + "<name>" + name + "</name>" + "<category>"
				+ category + "</category>" + "</product>";
	}
}
