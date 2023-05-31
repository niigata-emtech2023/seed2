package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.SpoFesBean;



public class ContactDAO {
	public int checkTask(SpoFesBean spofes) throws SQLException, ClassNotFoundException {

		int count = 0; //処理件数

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_point VALUE(?, ?, sysdate, ?, ?)")) {

			// DTOからのデータの取り出し
			int teamId = spofes.getTeamId();
			int taskId = spofes.getTaskId();
			int pointAdd = spofes.getPointAdd();
			int pointSub = spofes.getPointSub();

			// プレースホルダへの値の設定
			pstmt.setInt(1, teamId);
			pstmt.setInt(2, taskId);
			pstmt.setInt(3, pointAdd);
			pstmt.setInt(4, pointSub);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}

		return count;

	}

	public int searchTeamId(String team_name) throws SQLException, ClassNotFoundException {

		int team_id=-1;

		String sql = "SELECT * FROM m_team WHERE team_name = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, team_name);
			ResultSet res = pstmt.executeQuery();

			team_id = res.getInt("team_id");

		} catch(SQLException e) {
			e.printStackTrace();
		}

	return team_id;	
	}
}