package blog;

import exception.InvalidLinkException;

public class Blog {

	private Usuario usuarioAtual;
	public void posta(String endereco)throws InvalidLinkException {
		getUsuarioAtual().posta(endereco);
		
	}
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}
	public void novoUsuario(String nome) {
		usuarioAtual = new Usuario(nome);
	}

}
