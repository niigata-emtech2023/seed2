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

import model.dao.SelectAllDAO;
import model.dao.UpdateDAO;
import model.entity.SpoFesBean;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		String task_id  = request.getParameter("task_id");
		String update_info = (String) request.getParameter("update_info");
		int count = 0;
		String url = "adminselect.jsp";

		SpoFesBean spofes = new SpoFesBean();
		spofes.setTaskId(task_id);
		spofes.setTaskName(update_info);
		try {
			UpdateDAO dao = new UpdateDAO();
			count = dao.UpdateInfo(spofes);
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		request.setAttribute("task_id",task_id);
		request.setAttribute("update_info", update_info);

		if(count!=0) {
			try {
				SelectAllDAO selectAllDao = new SelectAllDAO();
				List<SpoFesBean> taskList = selectAllDao.selectAll();
				session.setAttribute("taskList", taskList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			url = "updateresult.jsp";
		}else{
			url = "update.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
