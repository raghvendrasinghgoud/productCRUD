package product.utility;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdCreater implements IdentifierGenerator {
	String id="P00";
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		try {
		Connection con=session.connection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select LAST_INSERT_ID()");
		if(rs.next()) {
			id+=rs.getInt(1);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
