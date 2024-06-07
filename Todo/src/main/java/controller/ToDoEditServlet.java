package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToDoBean;
import services.SQLservicesTodo;

/**
 * Servlet implementation class ToDoEditServlet
 */
@WebServlet("/ToDoEditServlet")
public class ToDoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ToDoBean lists = null;
		SQLservicesTodo sqlserv = new SQLservicesTodo();
		
		
		String edit_id = request.getParameter("edit_id");
		lists = sqlserv.select_EditID(Integer.parseInt(edit_id));
		request.setAttribute("lists", lists);	
		request.getRequestDispatcher("/todoEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLservicesTodo sqlserv = new SQLservicesTodo();

		String afterEdit_id = request.getParameter("afterEdit_id");
		String title = request.getParameter("title");
		String priority = request.getParameter("priority");
		String term = request.getParameter("term");
		String contents = request.getParameter("contents");

		
		sqlserv.update_id(Integer.parseInt(afterEdit_id), title,priority, term, contents);
		response.sendRedirect("ToDoServlet");
		
		//mainに戻す
	}

}
