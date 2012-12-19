package blog;

import java.util.Date;

public class Link {

	private String endereco;
	private Date dataDePostagem;

	public Date getDataDePostagem() {
		return dataDePostagem;
	}

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
