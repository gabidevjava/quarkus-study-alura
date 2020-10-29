package br.com.alura.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.model.Bitcoin;

public interface BitcoinService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar();

}
