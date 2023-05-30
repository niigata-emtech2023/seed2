package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoginAdminDAO;
import model.entity.SpoFesBean;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin-login-servlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
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

		String url = null;

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		try {
			// DAOの生成
			LoginAdminDAO dao = new LoginAdminDAO();
			SpoFesBean bean = new SpoFesBean();

			// DAOの利用
			if (dao.login(id, pass,bean)) {
				// 認証成功
				url = "select-rank-servlet";

				// セッションオブジェクトの取得
				HttpSession session = request.getSession();

				// セッションスコープへの属性の設定
				
				session.setAttribute("name", bean.getName());

			} else {
				// 認証失敗
				url = "adminlogin.jsp";
				request.setAttribute("err","IDかパスワードが間違っています。");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
