package br.univille.projetodsi.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
