/**
 * 
 */
package org.otojunior.municipioserver.model;

import java.io.Serializable;

/**
 * @author 01456231650
 *
 */
public class Arquivo implements Serializable {
	private static final long serialVersionUID = 7882041571753033926L;

	private String nome;
	private boolean vazio;
	private byte[] conteudo;
	
	/**
	 * @param nome
	 * @param vazio
	 * @param conteudo
	 */
	public Arquivo(String nome, boolean vazio, byte[] conteudo) {
		super();
		this.nome = nome;
		this.vazio = vazio;
		this.conteudo = conteudo;
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
	 * @return the vazio
	 */
	public boolean isVazio() {
		return vazio;
	}

	/**
	 * @param vazio the vazio to set
	 */
	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}

	/**
	 * @return the conteudo
	 */
	public byte[] getConteudo() {
		return conteudo;
	}

	/**
	 * @param conteudo the conteudo to set
	 */
	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return String.format("{nome=%s,vazio=%b}", nome, vazio);
	}
}
