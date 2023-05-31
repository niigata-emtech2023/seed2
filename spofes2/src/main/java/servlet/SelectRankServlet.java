package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.SelectRankDAO;
import model.entity.SpoFesBean;

/**
 * Servlet implementation class SelectRankServlet
 */
@WebServlet("/select-rank-servlet")
public class SelectRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRankServlet() {
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
		
		SelectRankDAO dao = new SelectRankDAO();
		
		SpoFesBean bean = new SpoFesBean();
		
		List<SpoFesBean> list = new ArrayList<SpoFesBean>();
		
		HttpSession session = request.getSession();
		
		list = dao.select();
		session.setAttribute("teamrank", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("select-all-servlet");
		rd.forward(request, response);
		
	}

}
