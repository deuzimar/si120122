package blog;

import java.util.Date;
/**
 *	Classe que representa um Link 
 */
public class Link {
	/**Endereco do link*/
	private String endereco;
	/**Data de postagem do link*/
	private Date dataDePostagem;
	/**
	 * retorna a data de postagem do link
	 * @return o objeto Date que representa a data de postagem do link
	 */
	public Date getDataDePostagem() {
		return dataDePostagem;
	}
	/**
	 * Construtor de um link a partir de um enrereço
	 * @param endereco o endereço link
	 */
	public Link(String endereco) {
		this.endereco = endereco;
		this.dataDePostagem = new Date();
	}

	public Link(String endereco, int dia, int mes, int ano, int hora,
			int minuto) {
		this.endereco = endereco;
		dataDePostagem = new Date(ano, mes, dia, hora, minuto);
	}

}
