package br.com.padawans.trazpramim.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.padawans.trazpramim.dto.RequisicaoNovoCadastro;
import br.com.padawans.trazpramim.dto.RequisicaoViajante;
import br.com.padawans.trazpramim.model.User;
import br.com.padawans.trazpramim.model.Viajante;
import br.com.padawans.trazpramim.repository.UserRepository;
import br.com.padawans.trazpramim.repository.ViajanteRepository;

@Controller
@RequestMapping("cadastro")
public class CadastroController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ViajanteRepository viajanteRepository;

	@GetMapping("formulario")
	public String cadastro(RequisicaoNovoCadastro requisicao) {
		return "cadastro/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoCadastro requisicao, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors())
			return "cadastro/formulario";

		if (!requisicao.getSenha().equals(requisicao.getConfirmarSenha())) {
//			attributes.addFlashAttribute("erroSenha", "As senhas digitadas precisam ser iguais");
//			attributes.addAttribute(requisicao);
			return "cadastro/formulario";
		}

		User user = requisicao.toCadastro();
		userRepository.save(user);

		return "redirect:/login";
	}

	@GetMapping("formularioViajante")
	public String viajante(RequisicaoViajante requisicao) {
		return "cadastro/formularioViajante";
	}

	@PostMapping("novoViajante")
	public String novoViajante(@Valid RequisicaoViajante requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "cadastro/formularioViajante";
		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> user = userRepository.findByLogin(username);
		Viajante viajante = requisicao.toViajante();
		viajanteRepository.save(viajante);
		
		Long id = viajante.getId();
		System.out.println("teste id "+ id);
		User usuario = user.get();
		usuario.setViajante(viajante);
		userRepository.save(usuario);
		
		return "redirect:/viagem/formulario";
	}
}
