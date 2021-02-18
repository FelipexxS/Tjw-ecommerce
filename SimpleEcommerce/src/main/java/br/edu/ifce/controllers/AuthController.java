package br.edu.ifce.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.dao.ClienteDao;
import br.edu.ifce.dao.ProdutoDao;

/**
 * Servlet implementation class AuthController
 */
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clientedao;
	private ProdutoDao produtodao;
	String forward;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthController() {
		super();
		// TODO Auto-generated constructor stub
		clientedao = new ClienteDao();
		produtodao = new ProdutoDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		PrintWriter pw = response.getWriter();

		if (clientedao.isClientAuth(email, pwd)) {
			forward = "views/store-frontpage.jsp";
			request.setAttribute("produto", produtodao.getAllProdutos());
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			pw.println("<span style='color: red;'> Email ou senha incorretos.</span>");
		}
	}

}
