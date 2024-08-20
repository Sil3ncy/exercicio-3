package dao;

import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

public class ProdutoDAO{
	private DataSource dataSource;
	
	public ProdutoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ArrayList<Produto> readAll(){
		
		try {
			String SQL = "SELECT * FROM produto";
			PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Produto> lista = new ArrayList<Produto>();
			
			while(rs.next()) {
				Produto pro = new Produto();
				pro.setId(rs.getInt("id"));
				pro.setDescricao(rs.getString("descricao"));
				pro.setPreco(rs.getFloat("preco"));
				pro.setQuantidade(rs.getInt("quantidade"));
				pro.setDataFabricacao(rs.getTimestamp("fabricacao").toLocalDateTime());
			}
		}
		catch (SQLException ex){
			System.err.println("erro ao recuperar" + ex.getMessage());
		}
		catch (Exception ex) {
			System.err.println("erro geral" + ex.getMessage());
		}
		return null;
		
	}
}