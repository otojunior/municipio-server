/**
 * 
 */
package org.otojunior.municipioserver.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.opencsv.bean.CsvBindByPosition;

/**
 * @author 01456231650
 *
 */
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@CsvBindByPosition(position = 0) private Integer id;
	@CsvBindByPosition(position = 1) private String nome;
	@CsvBindByPosition(position = 2) private String cep;
	@CsvBindByPosition(position = 3) private String descricao;
	@CsvBindByPosition(position = 4) private Integer populacao;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the populacao
	 */
	public Integer getPopulacao() {
		return populacao;
	}
	/**
	 * @param populacao the populacao to set
	 */
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
