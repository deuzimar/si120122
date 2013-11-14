package tempo;
/**
 *	Classe que representa um intervalo de tempo com unidade e valor
 */
public class IntervaloDeTempo {
	/**O valor do intervalo*/
	private double valor;
	/**Unidade de tempo do intervalo*/
	private UnidadeDeTempo unidade;
	/**
	 * Cria um intervalo de tempo a partir de um valor e de uma unidade
	 * @param valor o valor do intervalo de tempo
	 * @param unidade a {@link UnidadeDeTempo} do intervalo
	 */
	public IntervaloDeTempo(double valor, UnidadeDeTempo unidade){
		this.valor = valor;
		this.unidade = unidade;
	}
	/**
	 * Retorna o valor do intervalo 
	 */
	public double getValor(){
		return valor;
	}
	/**
	 * Retorna a {@link UnidadeDeTempo} do intervalo
	 */
	public UnidadeDeTempo getUnidade(){
		return unidade;
	}
	
}
