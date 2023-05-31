package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ContactDAO {
	public int checkTask(String point,String teamname) throws SQLException, ClassNotFoundException {

		int count = 0; //処理件数
		
		String selectsql="SELECT point,team_id FROM t_rank r,m_team t WHERE t.team_id = r.team_id AND team_name = ?";
		String insertsql="UPDATE m_team SET point = ? WHERE team_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(selectsql)) {
			
			
			// プレースホルダへの値の設定
			pstmt.setString(1, teamname);
			ResultSet res = pstmt.executeQuery();
			point += res.getInt("point");
			
			PreparedStatement pstmt2 = con.prepareStatement(insertsql);
			pstmt2.setString(1, point);
			pstmt2.setInt(2, res.getInt("team_id"));
			

			// SQLステートメントの実行
			count = pstmt2.executeUpdate();
		}

		return count;

	}
}