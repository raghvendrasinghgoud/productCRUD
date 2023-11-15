package product.business;

import java.util.List;
import product.entities.Product;

public class ProductsOperation {	
	
	public int getToatalAmount(List<Product> products) {
		int sum=0;
		for(Product p:products) {
			sum+=p.getPrice();
		}
		return sum;
	}
}
