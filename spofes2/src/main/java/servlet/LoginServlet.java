package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.dao.LoginDAO;
//import model.entity.SpoFesBean;

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
		
//		SpoFesBean bean = new SpoFesBean();
//
//		try {
//			// DAOの生成
//			LoginDAO loginDao = new LoginDAO();
//
//			// DAOの利用
//			if (loginDao.loginCheck(id, pass,bean)) {
//				// 認証成功
//				url = "select-my-rank-servlet";
//
//				// セッションオブジェクトの取得
//				HttpSession session = request.getSession();
//
//				// セッションスコープへの属性の設定
//				
//				session.setAttribute("name", bean.getName());
//
//			} else {
//				// 認証失敗
//				url = "login.jsp";
//				request.setAttribute("err","IDかパスワードが間違っています。");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		// リクエストの転送
//		RequestDispatcher rd = request.getRequestDispatcher(url);
//		rd.forward(request, response);
		
		// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
				response.setContentType("text/html; charset=UTF-8");

				// レスポンス書き出し用オブジェクトの取得
				PrintWriter pw = response.getWriter();

				// レスポンスの書き出し
				pw.println("<!DOCTYPE html><html>");
				pw.println("<head><title>依頼受付完了</title></head>");
				pw.println("<body>");
				pw.println("依頼を受け付けました<br>");
				pw.println("名前：" + id + "<br>");
				pw.println("連絡方法：" + pass + "<br>");
				pw.print("依頼内容：");
//				for (String str : ask) {
//					pw.print(str + " ");
//				}
				pw.println();
				pw.println("</body></html>");
			

	}

}
