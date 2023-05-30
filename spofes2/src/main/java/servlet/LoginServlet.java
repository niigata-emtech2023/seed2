package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoginDAO;
import model.entity.SpoFesBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		String url = null; //画面遷移先

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		SpoFesBean bean = new SpoFesBean();

		try {
			// DAOの生成
			LoginDAO loginDao = new LoginDAO();
			
			String name = loginDao.loginCheck(id,pass);
			// DAOの利用
			if (!(name.equals(null))) {
				// 認証成功
				url = "select-my-rank-servlet";

				// セッションオブジェクトの取得
				HttpSession session = request.getSession();

				// セッションスコープへの属性の設定
				
				session.setAttribute("name", name);

			} else {
				// 認証失敗
				url = "login.jsp";
				request.setAttribute("err","IDかパスワードが間違っています。");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		

	}

}