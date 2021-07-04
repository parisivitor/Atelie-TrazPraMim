//package br.com.padawans.trazpramim.model;
//
//import java.math.BigDecimal;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//
//@Entity
//public class Produtos {
//	
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String nomeProduto;
//	private String urlImagem;
//	private Integer Quantidade;
//	private BigDecimal preco;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Viagem viagem;
//
//	public Produtos() {
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNomeProduto() {
//		return nomeProduto;
//	}
//
//	public void setNomeProduto(String nomeProduto) {
//		this.nomeProduto = nomeProduto;
//	}
//
//	public String getUrlImagem() {
//		return urlImagem;
//	}
//
//	public void setUrlImagem(String urlImagem) {
//		this.urlImagem = urlImagem;
//	}
//
//	public Integer getQuantidade() {
//		return Quantidade;
//	}
//
//	public void setQuantidade(Integer quantidade) {
//		Quantidade = quantidade;
//	}
//
//	public BigDecimal getPreco() {
//		return preco;
//	}
//
//	public void setPreco(BigDecimal preco) {
//		this.preco = preco;
//	}
//
//}
