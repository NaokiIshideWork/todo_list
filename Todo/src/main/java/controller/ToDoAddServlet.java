package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.SQLservicesTodo;

/**
 * Servlet implementation class ToDoAddServlet
 */
@WebServlet("/ToDoAddServlet")
public class ToDoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		request.getRequestDispatcher("/todoPageAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLservicesTodo sqlserv = new SQLservicesTodo();

		String title = request.getParameter("title");
		String priority = request.getParameter("priority");
		String term = request.getParameter("term");
		String contents = request.getParameter("contents");

		sqlserv.insert(title, priority, term, contents);
		response.sendRedirect("ToDoServlet");

	}

}
