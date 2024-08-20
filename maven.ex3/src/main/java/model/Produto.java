package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Produto {
	private int id;
	private String descricao;
	private float preco;
	private int quantidade;
	private LocalDateTime dataFabricacao;	
	
	public Produto() {}
	
	public Produto(int id, String descricao, float preco, int quantidade, LocalDateTime fabricacao) {
		setId(id);
		setDescricao(descricao);
		setPreco(preco);
		setQuantidade(quantidade);
		setDataFabricacao(fabricacao);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

	public LocalDateTime getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDateTime dataFabricacao) {
		// Pega a Data Atual
		LocalDateTime agora = LocalDateTime.now();
		this.dataFabricacao = dataFabricacao;
	}


	@Override
	public String toString() {
		return "Produto: " + descricao + "   Preço: R$" + preco + "   Quantidade.: " + quantidade + "   Fabricação: ";
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Produto) obj).getID());
	}	
}