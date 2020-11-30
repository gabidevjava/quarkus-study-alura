package br.com.alura.service;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {
	
	@Inject
	OrdemRepository repository;

	public void inserir(SecurityContext context, Ordem ordem) {
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADO");
		
		repository.persist(ordem);
	}
}