package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.SpoFesBean;

public class SelectMyRankDAO {

	public List<SpoFesBean> select(String name) {

		List<SpoFesBean> list = new ArrayList<SpoFesBean>();

		try {

			String sql = "SELECT team_name,point FROM m_rank r,m_team t,m_user u "
					+ "WHERE r.team_id = t.team_id AND u.team_id = t.team_id AND name = ?";

			try(Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt =  con.prepareStatement(sql)){

				ResultSet res = pstmt.executeQuery();
				
				pstmt.setString(1, name);

				// 結果の操作
				while (res.next()) {
					String teamName = res.getString("team_name");
					int point = res.getInt("point");
					SpoFesBean bean = new SpoFesBean();

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
