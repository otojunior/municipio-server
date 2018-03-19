/**
 * 
 */
package org.otojunior.municipioserver.service;

import java.io.ByteArrayInputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.otojunior.municipioserver.dao.MunicipioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 01456231650
 *
 */
@Component
@Path("/download")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DownloadService {
	@Autowired
	private MunicipioDao municipioDao;

	@GET
	@Path("/municipio")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadMunicipioCsv() {
		byte[] conteudo = municipioDao.obterMunicipiosCsv();
		ByteArrayInputStream in = new ByteArrayInputStream(conteudo);
		return Response.ok(in).
			type(MediaType.APPLICATION_OCTET_STREAM).
			header("Content-Disposition", "attachment; filename=municipios.csv").
			build();
	}
}
