 /** model.dao.InsertDAO.java
 * @author i
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.SpoFesBean;

public class InsertDAO {
	public int insert(SpoFesBean bean) throws SQLException, ClassNotFoundException{
		
		int number = 0; //処理件数
		
		List<SpoFesBean> taskList = new ArrayList<SpoFesBean>();
		
		int task_id = taskList.size() + 1;
		
		String sql = "INSERT INTO m_task(task_id,task_info) VALUES(?,?)";
		
		//データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String task_info = bean.getTaskName();

			// プレースホルダへの値の設定
			pstmt.setInt(1, task_id);
			pstmt.setString(2, task_info);

			// SQLステートメントの実行
			number = pstmt.executeUpdate();
		}
		return number;
		
	}

}
