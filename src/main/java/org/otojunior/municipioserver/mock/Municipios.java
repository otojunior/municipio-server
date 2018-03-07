/**
 * 
 */
package org.otojunior.municipioserver.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.otojunior.municipioserver.model.Municipio;

/**
 * @author 01456231650
 *
 */
public class Municipios {
	private static List<Municipio> municipios = new ArrayList<>();
	
	static {
		for (int i = 1; i <= 5; i++) {
			Municipio m = new Municipio();
			m.setId(i);
			m.setNome("Municipio " + i);
			m.setCep(String.valueOf(10000 * i));
			m.setDescricao("Descrição " + i);
			m.setPopulacao(150000 * i);
			municipios.add(m);
		}
	}
	
	/**
	 * 
	 * @param municipio
	 */
	public static void inserirMunicipio(Municipio municipio) {
		municipios.add(municipio);
	}
	
	/**
	 * 
	 * @param municipio
	 */
	public static void removerMunicipio(Municipio municipio) {
		municipios.remove(municipio);
	}
	
	/**
	 * 
	 * @param id
	 */
	public static void removerMunicipio(Integer id) {
		municipios = municipios.
			stream().
			filter(m -> !m.getId().equals(id)).
			collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Municipio> obterMunicipios() {
		return municipios;
	}
}
