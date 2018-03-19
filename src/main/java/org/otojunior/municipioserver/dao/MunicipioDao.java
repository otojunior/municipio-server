/**
 * 
 */
package org.otojunior.municipioserver.dao;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.NoSuchElementException;

import org.otojunior.municipioserver.mock.Municipios;
import org.otojunior.municipioserver.model.Municipio;
import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * @author 01456231650
 *
 */
@Component
public class MunicipioDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Municipio obterMunicipio(Integer id) {
		Municipio retorno = null;
		try {
			retorno = Municipios.obterMunicipios(Municipios.COUNT_MUNICIPIOS).
				stream().
				filter(m -> m.getId().equals(id)).
				findFirst().
				get();
		} catch (NoSuchElementException e) {
			retorno = new Municipio();
			retorno.setId(-1);
			retorno.setNome("N/A");
			retorno.setCep("N/A");
			retorno.setDescricao("Não se aplica");
			retorno.setPopulacao(0);
		}
		return retorno;
	}

	/**
	 * 
	 * @param registros 
	 * @return
	 */
	public List<Municipio> obterMunicipios(int registros) {
		return Municipios.obterMunicipios(registros);
	}

	/**
	 * @param numero registros a retornar
	 * @return
	 */
	public byte[] obterMunicipiosCsv(int registros) {
		try (StringWriter writer = new StringWriter()) {
			List<Municipio> municipios = obterMunicipios(registros);
			if (!municipios.isEmpty()) {
				StatefulBeanToCsv<Municipio> beanToCsv = new StatefulBeanToCsvBuilder<Municipio>(writer).
					withLineEnd(CSVWriter.DEFAULT_LINE_END).
					withSeparator(';').
					withQuotechar(CSVWriter.DEFAULT_QUOTE_CHARACTER).
					build();
				beanToCsv.write(municipios);
				return 
					writer.toString().
					getBytes(Charset.forName("ISO-8859-1"));
			} else {
				return new byte[0];
			}
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException ex) {
            ex.printStackTrace();
            return null;
        }
	}
}
