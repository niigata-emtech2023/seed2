/**
 * model.dao.DeleteDAO.java
 * @author i
 */

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
public int delete(String task) throws SQLException, ClassNotFoundException{
		
		int number = 0; //処理件数
		
		String sql = "DELETE from m_task WHERE task_info = ?";
		
		//データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1, task);

			// SQLステートメントの実行
			number = pstmt.executeUpdate();
		}
		return number;
		
	}

}