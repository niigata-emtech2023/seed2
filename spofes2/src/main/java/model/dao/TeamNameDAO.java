package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.SpoFesBean;

public class TeamNameDAO {

	public List<SpoFesBean> getTeamName() throws ClassNotFoundException, SQLException{
		List<SpoFesBean> list = new ArrayList<SpoFesBean>();

		String sql = "SELECT * FROM m_team";

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt =  con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			// 結果の操作
			while(res.next()) {
				SpoFesBean teamList = new SpoFesBean();
				teamList.setTeamName(res.getString("team_name"));
				list.add(teamList);
			}
		}
		return list;
	}
}