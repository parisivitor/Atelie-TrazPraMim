package br.com.padawans.trazpramim.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Controller;

import br.com.padawans.trazpramim.model.Viagem;

@Controller
public class RequisicaoNovaViagem {

	@NotBlank
	private String cidadeOrigem;
	@NotBlank
	private String cidadeDestino;
	@NotBlank
	private String dataDaEntrega;
	@NotBlank
	private String descricao;
	@NotBlank
	private String nomeProduto;
	
	private String urlImagem;
	@NotBlank @Pattern(regexp = "^\\d+{2}$")
	private String Quantidade;
	@NotBlank @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String preco;

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

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Viagem toViagem() {
		Viagem viagem = new Viagem();
		viagem.setCidadeOrigem(cidadeOrigem);
		viagem.setCidadeDestino(cidadeDestino);
		viagem.setDataDaEntrega(LocalDate.parse(dataDaEntrega));
		viagem.setDescricao(descricao);
		viagem.setNomeProduto(nomeProduto);
		viagem.setQuantidade(Integer.parseInt(Quantidade));
		viagem.setPreco(new BigDecimal(preco));
		viagem.setUrlImagem(urlImagem);
		return viagem;
	}

}
