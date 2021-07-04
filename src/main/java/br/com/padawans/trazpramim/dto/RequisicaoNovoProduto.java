//package br.com.padawans.trazpramim.dto;
//
//import java.math.BigDecimal;
//
//import org.springframework.stereotype.Controller;
//
//import br.com.padawans.trazpramim.model.Produtos;
//
//@Controller
//public class RequisicaoNovoProduto {
//	
//	private String nomeProduto;
//	private String urlImagem;
//	private String quantidade;
//	private String preco;
//	
//	public RequisicaoNovoProduto() {
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
//	public String getQuantidade() {
//		return quantidade;
//	}
//
//	public void setQuantidade(String quantidade) {
//		this.quantidade = quantidade;
//	}
//
//	public String getPreco() {
//		return preco;
//	}
//
//	public void setPreco(String preco) {
//		this.preco = preco;
//	}
//	
//	public Produtos addProduto() {
//		Produtos produto = new Produtos();
//		produto.setNomeProduto(nomeProduto);
//		produto.setPreco(new BigDecimal(preco));
//		produto.setQuantidade(Integer.parseInt(quantidade));
//		return produto;
//		
//	}
//	
//	
//
//}
