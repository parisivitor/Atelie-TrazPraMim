package br.com.padawans.trazpramim.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.padawans.trazpramim.dto.RequisicaoNovoCadastro;
import br.com.padawans.trazpramim.model.User;
import br.com.padawans.trazpramim.repository.UserRepository;


@Controller
@RequestMapping("cadastro")
public class CadastroController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String cadastro(RequisicaoNovoCadastro requisicao) {
		return "cadastro/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoCadastro requisicao, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors())
			return "cadastro/formulario";

		if(!requisicao.getSenha().equals(requisicao.getConfirmarSenha())) {
			attributes.addFlashAttribute("erroSenha", "As senhas digitadas precisam ser iguais");
			attributes.addAttribute(requisicao);
			return "redirect:/cadastro/formulario";
		}
			
		
		User user = requisicao.toCadastro();
		userRepository.save(user);
		
		return "redirect:/login";
	}
}
