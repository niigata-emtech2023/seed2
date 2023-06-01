package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ContactDAO;
import model.entity.SpoFesBean;

/**
 * Servlet implementation class ContactServlat
 */
@WebServlet("/contact-servlat")
public class ContactServlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlat() {
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
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int point = Integer.parseInt(request.getParameter("point"));
		String teamname = request.getParameter("teamname");
		session.setAttribute("teamname", teamname);
		session.setAttribute("point",point);
		SpoFesBean bean =new SpoFesBean();
		bean.setPoint(point);
		bean.setTeamName(teamname);
		
		ContactDAO dao = new ContactDAO();
		try {
			if((dao.checkTask(bean)==1)){
				url="contactresult.jsp";
				
			}else {
				url="contactconfirmation.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
