package product.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import product.dao.ProductDao;
import product.entities.Product;
import product.entities.validate.ProductValidator;
import product.util.FileHandling;

public class UserHandle implements Controller {
	
	private ProductDao pd;
	private ProductValidator pv;
	
	public UserHandle(ProductValidator pv) {
		this.pv=pv;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();			
		map.put("products", pd.findAll());
		//ceating product obj
		Product product=new Product();
		
		//setting values;
		product.setName(request.getParameter("pname"));
		product.setPrice(Float.parseFloat(request.getParameter("pprice")));
		product.setBrand(request.getParameter("pbrand"));
		product.setQuantity(Integer.parseInt(request.getParameter("pquantity")));
		product.setDescription(request.getParameter("pdescription"));
		
		//validate product
		
		BindingResult br= new BindException(product,"product");
		pv.validate(product,br);
		
		if(br.hasErrors()) {
			System.out.println("There are some errors");
			map.put("error", br.getFieldErrors());
			return new ModelAndView("product",map);
		}
		
		//checking if it is update operation
		
		System.out.println(request.getParameter("id")+"is id");
		
		//saveOrupdate product image
		
		//geting submited image file from request part
		MultipartHttpServletRequest mpr=(MultipartHttpServletRequest)request;
		MultipartFile imageFile= mpr.getFile("img");
		
		System.out.println("product count "+pd.productsCount());
		
		//creating path and filename for saving image
		
		String imageFileName=pd.productsCount()+"product."+imageFile.getContentType().split("/")[1];
		
		String path=request.getSession().getServletContext().getRealPath(File.separator)+File.separator+"products_image";
		
		System.out.println(path);
		
				
		//if it is update operation
		if(!request.getParameter("id").equals("")) {
			Product tempProduct=pd.find(Integer.parseInt(request.getParameter("id")));
			
			imageFileName=tempProduct.getImageName();
			
			product.setId(Integer.parseInt(request.getParameter("id")));
			
		}
		
			product.setImageName(imageFileName);
		
		//file handling
		FileHandling fh=new FileHandling(path, imageFileName);
		
		//saving new image file
		fh.saveOrUpdateFile(imageFile.getInputStream());
		
		System.out.println(product);
		//saving obj to db
		pd.saveOrUpdate(product);
		
		map.put("msg", product.getName()+"Product added successfully");
		
		
		return new ModelAndView("product",map);
	}
	public ProductDao getPd() {
		return pd;
	}
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	
}
