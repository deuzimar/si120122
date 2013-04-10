package blog;

import java.util.List;

import tempo.IntervaloDeTempo;
import exception.InvalidLinkException;
/**
 * Classe que representa o blog de postagem de links
 */
public class Blog {
	/**O Usuario atual do blog*/
	private Usuario usuarioAtual;
	
	public Blog(){
		usuarioAtual = new Usuario("Padrao");
	}
	
	/**
	 * Posta um link no blog
	 * @param endereco o endereco do {@link Link}
	 * @throws InvalidLinkException exceção caso o link seja inválido
	 */
	public void posta(String endereco)throws InvalidLinkException {
		getUsuarioAtual().posta(endereco);
		
	}
	/**
	 * Retorna o usuario atual do blog
	 * @return o {@link Usuario} atual do blig
	 */
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}
	/**
	 * Cria um novo {@link Usuario} do blog e o seta como usuário atual
	 * @param nome o nome do usuário
	 */
	public void atualizaUsuario(String nome) {
		usuarioAtual = new Usuario(nome);
	}
	/**
	 * Retorna o site mais postado pelo usuario atual
	 * @return o site mais postado pelo usuario
	 */
	public String getSiteMaisPostado() {
		return usuarioAtual.getSiteMaisPostado();
	}
	/**
	 * Retorna o tempo medio entre as postagens do usuario
	 * @return um {@link IntervaloDeTempo} com valor e unidade
	 */
	public IntervaloDeTempo getTempoMedioEntrePostagens(){
		return usuarioAtual.getTempoMedioEntrePostagens();
	}
	
	public List<Link> getUltimosLinksPostados(){
		return usuarioAtual.getUltimosLinksPostados();
	}

}
