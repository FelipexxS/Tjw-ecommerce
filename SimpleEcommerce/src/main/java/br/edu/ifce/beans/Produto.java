package br.edu.ifce.beans;

public class Produto {
	
	private int idproduto;
	private String nome_produto;
	private Double preco_produto;
	private String departamento;
	private int produto_indicado;
	
	public int getIdproduto() {
		return idproduto;
	}
	
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	
	public String getNome_produto() {
		return nome_produto;
	}
	
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	
	public Double getPreco_produto() {
		return preco_produto;
	}
	
	public void setPreco_produto(Double preco_produto) {
		this.preco_produto = preco_produto;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public int getProduto_indicado() {
		return produto_indicado;
	}
	
	public void setProduto_indicado(int produto_indicado) {
		this.produto_indicado = produto_indicado;
	}
}
