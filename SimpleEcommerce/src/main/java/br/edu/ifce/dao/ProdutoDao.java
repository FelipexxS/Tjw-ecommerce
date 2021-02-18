package br.edu.ifce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.beans.Produto;
import br.edu.ifce.utils.DbUtil;

public class ProdutoDao {
	private Connection connection;
	
	public ProdutoDao() {
		connection = DbUtil.getConnection();
	}
	
	
	public List<Produto> getAllProdutos () {
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		
		String sql = "SELECT * FROM produto";
			
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
	            Produto produto = new Produto();
	            produto.setIdproduto(rs.getInt("idproduto"));
	            produto.setNome_produto(rs.getString("nome_produto"));
	            produto.setPreco_produto(rs.getDouble("preco_produto"));
	            produto.setDepartamento(rs.getString("departamento"));
	            produto.setProduto_indicado(rs.getInt("produto_indicado"));
	            listaDeProdutos.add(produto);
	        }
			
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDeProdutos;
	}
	
	public Produto getProdutoById(int id) {
        Produto produto = new Produto();
        try {
            PreparedStatement st = connection.prepareStatement("select * from produto where idproduto=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
            	produto.setIdproduto(rs.getInt("idproduto"));
	            produto.setNome_produto(rs.getString("nome_produto"));
	            produto.setPreco_produto(rs.getDouble("preco_produto"));
	            produto.setDepartamento(rs.getString("departamento"));
	            produto.setProduto_indicado(rs.getInt("produto_indicado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		if (produto.getNome_produto() == null) {
			return null;
		} else {
			return produto;
		}
    }
	


}
