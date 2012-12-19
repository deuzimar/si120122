package blog;

import exception.InvalidLinkException;

public class Usuario {
	private String nome;
	private LinhaDoTempo linhaDoTempo;
	public Usuario(String nome){
		this.nome = nome;
		this.linhaDoTempo = new LinhaDoTempo();
	}

	public void posta(String endereco)throws InvalidLinkException {
		getLinhaDoTempo().posta(endereco);
		
	}

	public LinhaDoTempo getLinhaDoTempo() {
		return linhaDoTempo;
	}

}
