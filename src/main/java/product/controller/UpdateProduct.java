package product.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import product.dao.ProductDao;
import product.entities.Product;

public class UpdateProduct implements Controller {

	private ProductDao pd;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		Product product=pd.find(id);
		
		Map<String,Object> map=new HashMap<>();
		map.put("product",product);
		return new ModelAndView("index",map);
	}
	public ProductDao getPd() {
		return pd;
	}
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

}
