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

import br.com.padawans.trazpramim.dto.RequisicaoNovaViagem;
import br.com.padawans.trazpramim.model.User;
import br.com.padawans.trazpramim.model.Viagem;
import br.com.padawans.trazpramim.repository.UserRepository;
import br.com.padawans.trazpramim.repository.ViagemRepository;

@Controller
@RequestMapping("viagem")
public class ViagemController {

	@Autowired
	private ViagemRepository viagemRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovaViagem requisicao) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> user = userRepository.findByLogin(username);
		if(user.get().getViajante() != null) {
			return "viagem/formulario";
		}
		else {
			return"redirect:/cadastro/formularioViajante";
		}

		
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovaViagem requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "viagem/formulario";
		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> user = userRepository.findByLogin(username);
		Viagem viagem = requisicao.toViagem();
		viagem.setUser(user.get());
		viagemRepository.save(viagem);
	
		return "redirect:/home";
	}
}
