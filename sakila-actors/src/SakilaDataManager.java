import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class SakilaDataManager {

	public static MysqlDataSource ds = null;

	public static void setDataSource(String username, String password) {
		if (ds == null) {
			ds = new MysqlDataSource();
			ds.setServerName("localhost");
			ds.setPort(3306);
			ds.setUser(username);
			ds.setPassword(password);
			ds.setDatabaseName("sakila");
		}
	}

	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<>(); 
		try(Connection conn = ds.getConnection();  
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM country;");
				ResultSet rs = ps.executeQuery()) {
			while(rs.next()) {
				Country c = new Country();
				c.setId(rs.getInt("country_id"));
				c.setCountry(rs.getString("country"));
				c.setLastUpdate(new Timestamp(rs.getDate("last_update").getTime()).toLocalDateTime());
				countries.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countries;
	}

}
