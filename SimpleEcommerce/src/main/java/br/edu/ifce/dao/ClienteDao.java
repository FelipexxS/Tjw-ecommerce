package br.edu.ifce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.beans.Cliente;
import br.edu.ifce.utils.DbUtil;

public class ClienteDao {
	private Connection connection;
	
	public ClienteDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addCliente (Cliente cliente) {
		String sql = "INSERT INTO cliente (nome_cliente, email, pwd, cpf, endereco, telefone) VALUES (?,?,?,?,?,?)";

		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, cliente.getNome_cliente());
			st.setString(2, cliente.getEmail());
			st.setString(3, cliente.getPwd());
			st.setString(4, cliente.getCPF());
			st.setString(5, cliente.getEndereco());
			st.setString(6, cliente.getTelefone());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Cliente> getAllClientes () {
		List<Cliente> listaDeClientes = new ArrayList<Cliente>();
		
		String sql = "SELECT * FROM cliente";
			
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setIdcliente(rs.getInt("idcliente"));
	            cliente.setNome_cliente(rs.getString("nome_cliente"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setPwd(rs.getString("pwd"));
	            cliente.setCPF(rs.getString("CPF"));
	            cliente.setEndereco(rs.getString("endereco"));
	            cliente.setTelefone(rs.getString("telefone"));
	            listaDeClientes.add(cliente);
	        }
			
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaDeClientes;
	}
	
	public boolean isClientAuth(String email, String pwd) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement st = connection.prepareStatement("select * from cliente where email=? and pwd=?");
            st.setString(1, email);
            st.setString(2, pwd);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
            	cliente.setIdcliente(rs.getInt("idcliente"));
	            cliente.setNome_cliente(rs.getString("nome_cliente"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setPwd(rs.getString("pwd"));
	            cliente.setCPF(rs.getString("CPF"));
	            cliente.setEndereco(rs.getString("endereco"));
	            cliente.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (cliente.getEmail() == null && cliente.getPwd() == null) {
        	return false;
        } else {
        	return true;
        }
		
    }
	
	public Cliente getClienteById(Long id) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement st = connection.prepareStatement("select * from cliente where id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
            	cliente.setIdcliente(rs.getInt("idcliente"));
	            cliente.setNome_cliente(rs.getString("nome_cliente"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setPwd(rs.getString("pwd"));
	            cliente.setCPF(rs.getString("CPF"));
	            cliente.setEndereco(rs.getString("endereco"));
	            cliente.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return cliente;
    }
	
	public Cliente getClienteByEmail(String email) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement st = connection.prepareStatement("select * from cliente where email=?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
            	cliente.setIdcliente(rs.getInt("idcliente"));
	            cliente.setNome_cliente(rs.getString("nome_cliente"));
	            cliente.setEmail(rs.getString("email"));
	            cliente.setPwd(rs.getString("pwd"));
	            cliente.setCPF(rs.getString("CPF"));
	            cliente.setEndereco(rs.getString("endereco"));
	            cliente.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return cliente;
    }
}
