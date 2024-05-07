package product.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import product.dao.ProductDao;
import product.entities.Product;
import product.util.FileHandling;

public class DeleteProduct implements Controller {
	private ProductDao pd;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Product product=pd.find(id);
		System.out.println(product);
		
		String path=request.getSession().getServletContext().getRealPath(File.separator)+File.separator+"products_image";
		FileHandling fh=new FileHandling(path,product.getImageName());
		fh.deleteFile();
		pd.delete(product);
		
		
		Map<String,Object> map=new HashMap<>();
		
		map.put("msg", product.getName()+"Product deleted successfully");
		map.put("products", pd.findAll());
		return new ModelAndView("product",map);
	}
	public ProductDao getPd() {
		return pd;
	}
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

}
