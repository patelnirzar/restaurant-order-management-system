package com.api.roms.helper;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomOrderIdGenerator implements IdentifierGenerator {
	
	private int lastNumber = 0;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "order";
		String query = "SELECT MAX(order_id) FROM orders";
		Connection connection;
		try {
			connection = session.getJdbcConnectionAccess().obtainConnection();

			try (PreparedStatement statement = connection.prepareStatement(query)) {
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					String lastId = rs.getString(1);
					if (lastId != null) {
						System.out.println("lastid :"+lastId);
						int number = Integer.parseInt(lastId.substring(prefix.length())) + 1;
						
						System.out.println("num:"+number);
						
						if(lastNumber == number) {
							number++;
							lastNumber++;
						}
						else if (number < lastNumber) {
							lastNumber++;
							number = lastNumber;
						}
						else {
							lastNumber=number;
						}
						
						
						if(number <= 9) {
							return prefix + "0"+ number;
						}
						else {
							return prefix + number;
						}
					
					}
				}
			} catch (SQLException e) {
				throw new HibernateException("Unable to generate ID", e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prefix + 1; // Initial value if no records are present
	}

}
