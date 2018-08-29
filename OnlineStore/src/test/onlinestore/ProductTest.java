package onlinestore;

import static org.junit.Assert.assertEquals;
import onlinestore.ImageInfo;
import onlinestore.Product;
import onlinestore.Category;

import org.junit.Test;

public class ProductTest {
	@Test
	public void serializeToXml() {
		Product product = createProduct();

		String xml = product.toXml();

		assertEquals("<product><name>Black Bike</name><category>Bikes</category></product>", xml);
	}

	private Product createProduct() {
		return new Product("Black Bike", 250, Category.Bikes, new ImageInfo("Bike01.jpg"));
	}
}
