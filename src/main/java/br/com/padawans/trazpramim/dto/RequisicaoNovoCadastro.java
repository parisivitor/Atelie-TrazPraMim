package br.com.padawans.trazpramim.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import br.com.padawans.trazpramim.model.Endereco;
import br.com.padawans.trazpramim.model.User;

@Controller
public class RequisicaoNovoCadastro {

	@NotBlank
	@Email
	private String login;
	@NotBlank
	@Size(min = 6, max = 20)
	private String senha;
	@NotBlank
	private String confirmarSenha;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String dataNascimento;
	@NotBlank
	private String sexo;
	@NotBlank @Pattern(regexp = "^\\d{3}.?\\d{3}.?\\d{3}-?\\d{2}$")
	private String cpf;
	
	@NotBlank @Pattern(regexp = "^\\d{5}-\\d{3}$")
	private String cep;
	@NotBlank
	private String estado;
	@NotBlank
	private String cidade;
	@NotBlank
	private String rua;
	@NotNull
	private Integer numero;
	@NotBlank
	private String complemento;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public User toCadastro() {
		User user = new User();
		user.setLogin(login);
		user.setSenha(new BCryptPasswordEncoder().encode(senha));
		user.setDataNascimento(LocalDate.parse(dataNascimento));
		user.setNome(nome);
		user.setSobrenome(sobrenome);
		user.setSexo(sexo);
		user.setCpf(cpf);
		Endereco end = new Endereco();
		end.setCep(cep);
		end.setEstado(estado);
		end.setCidade(cidade.toUpperCase());
		end.setRua(rua);
		end.setComplemento(complemento);
		end.setNumero(numero);
		user.setEndereco(end);
		return user;
	}

	public Boolean validaSenha() {
		if (senha != confirmarSenha) {
			return false;
		} else
			return true;
	}

}
