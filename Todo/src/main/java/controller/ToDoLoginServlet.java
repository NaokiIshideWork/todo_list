package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Person;
import services.SQLservicesTodo;

/**
 * Servlet implementation class ToDoLoginServlet
 */
@WebServlet("/ToDoLoginServlet")
public class ToDoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/todoLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("password");

		SQLservicesTodo sqlserv = new SQLservicesTodo();
		Person person = sqlserv.Login(name, mail, pass);

		if (person != null) {
			// セッションにアカウント情報＆ロールを登録
			HttpSession session = request.getSession();
		
			session.setAttribute("person", person);
			
			response.sendRedirect("ToDoServlet");
		} else {
			doGet(request, response);
		}

	}

}
