package product.entities.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import product.entities.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product=(Product)target;
		
		if(product.getPrice()<=0) {
			errors.rejectValue("price", "product.price.min", "price must be greater than 0");
		}
		
		if(product.getQuantity()<=0) {
			errors.rejectValue("quantity", "product.quantity.min", "quantity must be greater than 0");
		}

	}

}
