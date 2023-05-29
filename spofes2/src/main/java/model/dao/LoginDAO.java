package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.SpoFesBean;

public class LoginDAO {
	public boolean loginCheck(String Id, String pass,SpoFesBean bean) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){

			// プレースホルダへの値の設定
			pstmt.setString(1, Id);
			pstmt.setString(2, pass);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();
			bean.setName("name");

			// 結果の操作
			if(res.next()) {
				return true;
			}
		}
		return false;
	}
}
