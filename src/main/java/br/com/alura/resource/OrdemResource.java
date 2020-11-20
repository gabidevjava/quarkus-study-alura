package br.com.alura.resource;

import javax.inject.Inject;
import javax.ws.rs.Path;

import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;

@Path("ordens")
public class OrdemResource {
	
	@Inject
	OrdemRepository repository;
	
	public void inserir(Ordem ordem) {
		//ordem.set
		repository.persist(ordem);
	}

}