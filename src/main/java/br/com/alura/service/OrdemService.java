package br.com.alura.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {
	
	@Inject
	OrdemRepository repository;

	public void inserir(SecurityContext context, Ordem ordem) {
		Optional<Usuario> userOptinal = Usuario.findByIdOptional(ordem.getUserId());
		
		Usuario usuario = userOptinal.orElseThrow();
		
		if(!usuario.getUsername().equals(context.getUserPrincipal().getName())) {
			throw new RuntimeException("O usuário logado é diferente do userId");
		}
		
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADO");
		
		repository.persist(ordem);
	}
}