package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAdminDAO {
	public String login(String Id, String pass)throws ClassNotFoundException, SQLException {

		String sql = "SELECT name FROM m_admin WHERE id = ? AND pass = ?";
		String name=null;
		
		// データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){

			// プレースホルダへの値の設定
			pstmt.setString(1, Id);
			pstmt.setString(2, pass);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			// 結果の操作
			if(res.next()) {
			name = res.getString("name");
			}
		}
		return name;
	}
}
