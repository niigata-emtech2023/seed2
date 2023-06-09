package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DeleteDAO;
import model.dao.SelectAllDAO;
import model.entity.SpoFesBean;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete-servlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=null;
		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String task = (String)session.getAttribute("task");

		// DAOの生成
		DeleteDAO dao = new DeleteDAO();

		int number = 0; //処理件数

		try {
			// DAOの利用
			number = dao.delete(task);
			if(number==1) {
				
				SelectAllDAO selectAllDao = new SelectAllDAO();
				List<SpoFesBean> taskList = selectAllDao.selectAll();
				session.setAttribute("taskList", taskList);

				// リクエストスコープへの属性の設定
				request.setAttribute("number", number);
				
				url = "deleteresult.jsp";
			}else {
				url = "deleteconfirmation.jsp";
				request.setAttribute("err","削除できませんでした。");
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("deleteresult.jsp");
		rd.forward(request, response);
	}

}
