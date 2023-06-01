package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.SpoFesBean;

public class SelectAllDAO {

	public List<SpoFesBean> selectAll() throws ClassNotFoundException, SQLException{
		List<SpoFesBean> list = new ArrayList<SpoFesBean>();

		String sql = "SELECT * FROM m_task";

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt =  con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			// 結果の操作
			while(res.next()) {
				SpoFesBean task = new SpoFesBean();
				task.setTaskId(res.getString("task_id"));
				task.setTaskName(res.getString("task_info"));
				list.add(task);
			}
		}
		return list;
	}
}