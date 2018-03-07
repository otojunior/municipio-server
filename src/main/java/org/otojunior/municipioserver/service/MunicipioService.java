/**
 * 
 */
package org.otojunior.municipioserver.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.otojunior.municipioserver.mock.Municipios;
import org.otojunior.municipioserver.model.Municipio;
import org.springframework.stereotype.Component;

/**
 * @author 01456231650
 *
 */
@Component
@Path("/municipio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MunicipioService {
	/**
	 * 
	 * @return
	 */
	@GET
	public List<Municipio> obterMunicipios() {
		return Municipios.obterMunicipios();
	}
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/pesquisa/{id}")
	public Municipio obterMunicipio(@PathParam("id") Integer id) {
		try {
			return Municipios.obterMunicipios().
				stream().
				filter(m -> m.getId().equals(id)).
				findFirst().
				get();
		} catch (NoSuchElementException e) {
			Municipio nullObj = new Municipio();
			nullObj.setId(-1);
			nullObj.setNome("N/A");
			nullObj.setCep("N/A");
			nullObj.setDescricao("Não se aplica");
			nullObj.setPopulacao(0);
			return nullObj;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("pesquisa")
	public Municipio obterMunicipioPorParametro(@QueryParam("id") Integer id) {
		try {
			return Municipios.obterMunicipios().
				stream().
				filter(m -> m.getId().equals(id)).
				findFirst().
				get();
		} catch (NoSuchElementException e) {
			Municipio nullObj = new Municipio();
			nullObj.setId(-1);
			nullObj.setNome("N/A");
			nullObj.setCep("N/A");
			nullObj.setDescricao("Não se aplica");
			nullObj.setPopulacao(0);
			return nullObj;
		}
	}
	
	@POST
	@Path("novo")
	@Produces(MediaType.TEXT_PLAIN)
	public String inserirMunicipio(Municipio municipio) {
		Municipios.inserirMunicipio(municipio);
		return "[OK] Registro Inserido";
	}
	
	@POST
	@Path("novo")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String inserirMunicipio(
			@QueryParam("id") Integer id,
			@QueryParam("nome") String nome,
			@QueryParam("cep") String cep,
			@QueryParam("descricao") String descricao,
			@QueryParam("populacao") Integer populacao) {
		String response = "[OK] Registro Inserido";
		Municipio novo = new Municipio();
		novo.setId(id);
		novo.setNome(nome);
		novo.setCep(cep);
		novo.setDescricao(descricao);
		novo.setPopulacao(populacao);
		Municipios.inserirMunicipio(novo);
		return response;
	}
	
	@DELETE
	@Path("remocao/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerMunicipio(@PathParam("id") Integer id) {
		Municipios.removerMunicipio(id);
		return "[OK] Registro(s) Removido(s)";
	}
}
