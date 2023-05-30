/**
 * model.dao.DeleteDAO.java
 * @author i
 */

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.SpoFesBean;

public class DeleteDAO {
public int delete(SpoFesBean bean) throws SQLException, ClassNotFoundException{
		
		int number = 0; //処理件数
		
		String sql = "DELETE from m_task WHERE task_info = ?";
		
		//データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String taskName = bean.getTaskName();

			// プレースホルダへの値の設定
			pstmt.setString(1, taskName);

			// SQLステートメントの実行
			number = pstmt.executeUpdate();
		}
		return number;
		
	}

}