package blog;

import java.util.List;

import tempo.IntervaloDeTempo;
import exception.InvalidLinkException;
/**
 * Um usuario do blog
 */
public class Usuario {
	/** O nome do usuario*/
	private String nome;
	/** A linha do tempo do usuario */
	private LinhaDoTempo linhaDoTempo;
	/**
	 * Construtor de um Usuario a partir de um nome
	 * @param nome o nome do usuario
	 */
	public Usuario(String nome){
		this.nome = nome;
		this.linhaDoTempo = new LinhaDoTempo();
	}
	/**
	 * Posta um link no blog
	 * @param endereco o endereco do link
	 * @throws InvalidLinkException exceção caso o link seja inválido
	 */
	public void posta(String endereco)throws InvalidLinkException {
		getLinhaDoTempo().posta(endereco);
		
	}

	/**
	 * Retorna a linha do tempo do usuario
	 * @return o objeto {@link LinhaDoTempo} que pertence ao Usuario
	 */
	public LinhaDoTempo getLinhaDoTempo() {
		return linhaDoTempo;
	}
	/**
	 * Retorna o site mais postado pelo usuario atual
	 * @return o site mais postado pelo usuario
	 */
	public String getSiteMaisPostado() {
		return linhaDoTempo.getSiteMaisPostado();
	}

	/**
	 * Retorna o tempo medio entre as postagens do usuario
	 * @return um {@link IntervaloDeTempo} com valor e unidade
	 */
	public IntervaloDeTempo getTempoMedioEntrePostagens() {
		return linhaDoTempo.getTempoMedioEntrePostagens();
	}
	
	public List<Link> getUltimosLinksPostados(){
		return linhaDoTempo.getUltimosLinksPostados();
	}

}
