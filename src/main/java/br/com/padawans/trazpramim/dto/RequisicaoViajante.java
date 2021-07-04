package br.com.padawans.trazpramim.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Controller;

import br.com.padawans.trazpramim.model.Viajante;

@Controller
public class RequisicaoViajante {

	@NotBlank
	private String marca;
	@NotBlank
	private String modelo;
	@NotBlank
	private String numeroPortas;
	@NotBlank
	private String placa;
	
	private String urlCarro;

	public RequisicaoViajante() {
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(String numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUrlCarro() {
		return urlCarro;
	}

	public void setUrlCarro(String urlCarro) {
		this.urlCarro = urlCarro;
	}
	
	public Viajante toViajante() {
		Viajante viajante = new Viajante();
		viajante.setMarca(marca);
		viajante.setModelo(modelo);
		viajante.setNumeroPortas(numeroPortas);
		viajante.setPlaca(placa);
		viajante.setUrlCarro(urlCarro);
		return viajante;
	}

}
