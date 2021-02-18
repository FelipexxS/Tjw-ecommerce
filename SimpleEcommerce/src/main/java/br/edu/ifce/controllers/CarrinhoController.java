package br.edu.ifce.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifce.beans.Produto;
import br.edu.ifce.dao.ProdutoDao;

/**
 * Servlet implementation class CarrinhoController
 */
public class CarrinhoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String forward;
	private ProdutoDao produtodao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarrinhoController() {
        super();
        // TODO Auto-generated constructor stub
        produtodao = new ProdutoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Produto> carrinho = new ArrayList<Produto>();
		
		Produto produtoSelecionado = new Produto();
		String nomeProduto = request.getParameter("nomeproduto");
		System.out.println(request.getParameter("precoproduto"));
		Double precoProduto = Double.parseDouble(request.getParameter("precoproduto"));
		produtoSelecionado.setNome_produto(nomeProduto);
		produtoSelecionado.setPreco_produto(precoProduto);
		carrinho.add(produtoSelecionado);
		
		forward = "views/store-frontpage.jsp";
		request.setAttribute("produto", produtodao.getAllProdutos());
		request.setAttribute("carrinho", carrinho);
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
