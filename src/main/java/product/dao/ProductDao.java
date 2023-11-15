package product.dao;

import java.util.List;
import product.entities.*;
public interface ProductDao {

	public void saveOrUpdate(Product product);
	public Product find(int id);
	public void delete(Product product);
	public List<Product> findAll();
	
}
