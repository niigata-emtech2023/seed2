 /**
 * model.dao.ConnectionManager.java
 * @author i
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * コネクションマネージャ
 * @author emtech-user
 *
 */
public class ConnectionManager {
	
	/**
	 * DBのURL
	 */
	private final static String URL = "jdbc:mysql://localhost:3306/spofesdb";
	
	/**
	 * ユーザ
	 */
	private final static String USER = "embexU";
	
	/**
	 * パスワード
	 */
	private final static String PASSWORD = "embexP";
	
	/**
	 * データベースへの接続を取得して返す
	 * 
	 * @return コネクション
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		//jdbcドライバの読み込み
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
