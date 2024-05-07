package product.test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import product.dao.ProductDao;
import product.dao.ProductDaoImpl;
import product.entities.*; 


public class Test {

	public static void main(String args[]) throws IOException {
		
//		Product product=new Product("fold phone",5000,"Samusung","very good phone it is");	
		
//		Configuration cfg=new Configuration();
//		cfg.configure("resources/hibernate.cfg.xml");
//			SessionFactory sf=cfg.buildSessionFactory();
//			Session s=sf.openSession();
//			ProductDao pd=new ProductDaoImpl();
			
//		ApplicationContext ap=new ClassPathXmlApplicationContext("resources/springconfig.xml");
//		ProductDao pd=(ProductDao)ap.getBean(ProductDao.class);
		
//				System.out.println(pd.save(product));
//				System.out.println(pd.find(product.getId()));
//				product.setName("botttle");
//				pd.update(product);
//				System.out.println("update product");
//				System.out.println(pd.findAll());
//				//pd.delete(product);
//				System.out.println("delting");
//		System.out.println(pd.productsCount());
		Logger log=java.util.logging.Logger.getLogger("");
		File file=new File("");
		File newfile=new File(file.getAbsoluteFile()+File.separator);
		log.info(newfile.getAbsolutePath());
		String str[]=newfile.list();
		for(String s:str)
		log.info(s);
			
			
	}
}
