package br.univille.projetodsi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.projetodsi.model.Paciente;
import br.univille.projetodsi.repository.PacienteRepository;

@Controller	
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
    private PacienteRepository pacienteRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<Paciente> listaPaciente = this.pacienteRepository.findAll();
		return new ModelAndView("paciente/index", "listapac", listaPaciente);
	}
	@GetMapping("/novo")
    public String createForm(@ModelAttribute Paciente paciente) {
        return "paciente/form";
    }
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Paciente paciente, BindingResult result, RedirectAttributes redirect){
		paciente = this.pacienteRepository.save(paciente);
		return new ModelAndView("redirect:/paciente");
	}
}
