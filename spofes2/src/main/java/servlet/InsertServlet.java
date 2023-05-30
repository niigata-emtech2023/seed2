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

import model.dao.InsertDAO;
import model.entity.SpoFesBean;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert-servlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
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

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String task_info = (String) session.getAttribute("task_info");
		List<SpoFesBean> taskList = (List<SpoFesBean>) session.getAttribute("taskList");
		SpoFesBean spofes = new SpoFesBean();
		spofes.setTaskName(task_info);


		// DAOの生成
		InsertDAO dao = new InsertDAO();

		int number = 0; //処理件数

		try {
			// DAOの利用
			number = dao.insert(spofes,taskList.size());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定
		request.setAttribute("spofes", spofes);
		request.setAttribute("number", number);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("insertresult.jsp");
		rd.forward(request, response);
	}

}
