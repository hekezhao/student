package dao;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class BaseDao {
    DataSource dataSource;
    public BaseDao(){
    	try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/wisdomDS");
		} catch (NamingException e) {
			System.out.println(e);
		}
    }
    public Connection getConnection() throws Exception{
    	return dataSource.getConnection();
    }
}
