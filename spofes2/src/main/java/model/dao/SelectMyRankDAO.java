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
		List<SpoFesBean> ranklist = new ArrayList<SpoFesBean>();

		try {

			String sql = "SELECT team_name,point FROM t_rank r,m_team t,m_user u "
					+ "WHERE r.team_id = t.team_id AND u.team_id = t.team_id AND name = ?";
			String sql1 = "SELECT team_name FROM t_rank r,m_team t WHERE r.team_id = t.team_id ORDER BY point DESC";

			try(Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt =  con.prepareStatement(sql);
						PreparedStatement pstmt2 =  con.prepareStatement(sql1)){
				
				pstmt.setString(1, name);

				ResultSet res = pstmt.executeQuery();
				SpoFesBean bean = new SpoFesBean();
				String myTeamName = null;

				// 結果の操作
				if (res.next()) {
					myTeamName = res.getString("team_name");
					int point = res.getInt("point");

					bean.setTeamName(myTeamName);
					bean.setPoint(point);
				}
				
				ResultSet res2 = pstmt2.executeQuery();
				int i = 1;
				
				while (res2.next()) {
					String teamName = res2.getString("team_name");
					if(teamName.equals(myTeamName)) {
						bean.setRank(i);
						list.add(bean);
					}
					i++;
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
