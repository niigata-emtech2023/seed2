package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.SpoFesBean;

public class UpdateDAO {
	public int UpdateInfo(SpoFesBean spofes) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数
		
		List<SpoFesBean> taskList = new ArrayList<SpoFesBean>();

		String sql = "UPDATE m_task SET task_info = ? WHERE task_id = ?";
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			String task_id = spofes.getTaskId();
			String update_info= spofes.getTaskName();
			
			pstmt.setString(1, update_info);
			pstmt.setString(2, task_id);
			
			count = pstmt.executeUpdate();
		} 
		return count;
	}
}