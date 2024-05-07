package product.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import product.entities.Product;

public class ProductDaoImpl implements ProductDao {

	private HibernateTemplate ht;
	private TransactionTemplate transactionTemplate;	
	public ProductDaoImpl(HibernateTemplate ht,TransactionTemplate transactionTemplate){
		this.ht=ht;
		this.transactionTemplate=transactionTemplate;
	}
	
	
	
	public ProductDaoImpl() {
		super();
	}



	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}


	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		transactionTemplate = transactionTemplate;
	}


	public HibernateTemplate getHt() {
		return ht;
	}


	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void saveOrUpdate(Product product) {
		transactionTemplate.execute( new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				ht.saveOrUpdate(product);
				
			}
		});
	}

	public Product find(int id) {
		return (Product)ht.get(Product.class,id);
	}


	public void delete(Product product) {
		System.out.println("delleting product...");
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				ht.delete(product);
				
			}			
		});
	}

	public List<Product> findAll() {
		return (List<Product>)ht.find("from Product");
		
	}



	@Override
	public int productsCount() {
			int res=Integer.parseInt(transactionTemplate.execute(status-> {
			
				
		SQLQuery<Object> query=ht.getSessionFactory().getCurrentSession().createSQLQuery("select auto_increment from information_schema.TABLES where table_schema='newproduct' and table_name='product'");
	
		 return query.list().get(0);
		 			
		}).toString());
		 
		return res;
		}
}
