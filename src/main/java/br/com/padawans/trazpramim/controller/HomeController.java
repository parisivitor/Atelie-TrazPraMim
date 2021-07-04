package br.com.padawans.trazpramim.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.padawans.trazpramim.model.Viagem;
import br.com.padawans.trazpramim.repository.ViagemRepository;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@GetMapping
	public String home(Model model) {
		
		Sort sort = Sort.by("dataDaEntrega").ascending();
		PageRequest paginacao = PageRequest.of(0, 5, sort);
		
		LocalDate data = LocalDate.now();
		List<Viagem> viagensList = viagemRepository.findByDataDaEntregaGreaterThan(data, paginacao);
		model.addAttribute("viagens", viagensList);
		return "home";
	}
	
}
