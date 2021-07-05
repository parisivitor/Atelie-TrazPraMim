package br.com.padawans.trazpramim.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Viagem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cidadeOrigem;
	private String cidadeDestino;
	private LocalDate dataDaEntrega;
	private String descricao;
	
	private String nomeProduto;
	private String urlImagem;
	private Integer quantidade;
	private BigDecimal preco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "viagem", fetch = FetchType.LAZY)
//	private List<Produtos> produtos = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	

//	public List<Produtos> getProdutos() {
//		return produtos;
//	}
//
//	public void setProdutos(List<Produtos> produtos) {
//		this.produtos = produtos;
//	}
	
	
	
	
}
