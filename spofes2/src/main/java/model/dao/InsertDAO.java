 /** model.dao.InsertDAO.java
 * @author i
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.SpoFesBean;

public class InsertDAO {
	public int insert(SpoFesBean bean, int size) throws SQLException, ClassNotFoundException{
		
		int number = 0; //処理件数
		
		String sql = "INSERT INTO m_task VALUES(?,?)";
		
		//データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String task_info = bean.getTaskName();

			// プレースホルダへの値の設定
			pstmt.setInt(1, (size+1));
			pstmt.setString(2, task_info);

			// SQLステートメントの実行
			number = pstmt.executeUpdate();
		}
		return number;
		
	}

}
