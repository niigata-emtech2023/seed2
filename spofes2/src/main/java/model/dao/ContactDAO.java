package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.SpoFesBean;



public class ContactDAO {
	public int checkTask(SpoFesBean bean) throws SQLException, ClassNotFoundException {

		int count = 0; //処理件数
		
		String selectsql="SELECT point,r.team_id FROM t_rank r,m_team t WHERE t.team_id = r.team_id AND team_name = ?";
		String insertsql="UPDATE t_rank SET point = ? WHERE team_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
			  PreparedStatement pstmt2 = con.prepareStatement(insertsql);
				PreparedStatement pstmt = con.prepareStatement(selectsql)) {
			
			
			// プレースホルダへの値の設定
			pstmt.setString(1, bean.getTeamName());
			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();
			int sumPoint=0;
			int teamId=0;
			while (res.next()) {
				sumPoint = res.getInt("point");
				teamId = res.getInt("r.team_id");
			}
			sumPoint += bean.getPoint();
			// プレースホルダへの値の設定
			pstmt2.setInt(1, sumPoint);
			pstmt2.setInt(2, teamId);

			// SQLステートメントの実行
			count = pstmt2.executeUpdate();
			bean.setPoint(sumPoint);
		}

		return count;

	}
}