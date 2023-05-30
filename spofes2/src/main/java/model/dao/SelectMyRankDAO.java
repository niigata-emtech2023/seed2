package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.SpoFesBean;

public class SelectMyRankDAO {

	public List<SpoFesBean> select(String name,SpoFesBean bean) {

		List<SpoFesBean> list = new ArrayList<SpoFesBean>();

		try {

			String sql = "SELECT * FROM m_rank r,m_team t WHERE r.team_id = t.team_id";

			try(Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt =  con.prepareStatement(sql)){

				ResultSet res = pstmt.executeQuery();

				// 結果の操作
				while (res.next()) {
					String teamName = res.getString("team_name");
					int point = res.getInt("point");
					
					bean.setTeamName(teamName);
					bean.setPoint(point);

					list.add(bean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}
