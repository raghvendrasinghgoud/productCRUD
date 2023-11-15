package product.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import product.dao.ProductDao;
import product.dao.ProductDaoImpl;
import product.entities.Product;

public class UserHandle implements Controller {
	
	private ProductDao pd;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> map=new HashMap<>();
		//ceating product obj
		Product product=new Product();
		
		//setting values;
		product.setName(request.getParameter("pname"));
		product.setPrice(Float.parseFloat(request.getParameter("pprice")));
		product.setBrand(request.getParameter("pbrand"));
		product.setDescription(request.getParameter("pdescription"));
		//checking if it is update operation
		System.out.println(request.getParameter("id")+"is id");
		if(request.getParameter("id")!=null) 
			product.setId(Integer.parseInt(request.getParameter("id")));
		System.out.println(product);
		//saving obj to db
		pd.saveOrUpdate(product);
		
		
		map.put("msg", product.getName()+"Product added successfully");
		map.put("products", pd.findAll());
		System.out.println("inside controller");
		
		return new ModelAndView("product",map);
	}
	public ProductDao getPd() {
		return pd;
	}
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	
}
