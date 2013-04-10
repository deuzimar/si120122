package blog;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import exception.InvalidLinkException;
/**
 *	Classe que representa um Link 
 */
public class Link {
	/**Endereco do link*/
	private String endereco;
	/**Data de postagem do link*/
	private Calendar dataDePostagem;
	
	/**
	 * Construtor de um link a partir de um enrereço
	 * @param endereco o endereço link
	 */
	public Link(String endereco) throws InvalidLinkException{
		if(!endereco.startsWith("http://")  &&
				!endereco.startsWith("https://")){
			throw new InvalidLinkException("Link em formato Inválido.");
		}
		this.endereco = endereco;
		this.dataDePostagem = new GregorianCalendar();
	}
	
	/**
	 * retorna a data de postagem do link
	 * @return o objeto Date que representa a data de postagem do link
	 */
	public Calendar getDataDePostagem() {
		return dataDePostagem;
	}

	@SuppressWarnings("deprecation")
	public Link(String endereco, int dia, int mes, int ano, int hora,
			int minuto) {
		this.endereco = endereco;
		dataDePostagem = new GregorianCalendar(ano, mes, dia, hora, minuto);
	}
	
	public String getEndereco(){
		return endereco;
	}
	

	public String getData(){
		return   String.format("%02d/%02d/%04d", dataDePostagem.get(Calendar.DAY_OF_MONTH),
		 dataDePostagem.get(Calendar.MONTH) + 1,dataDePostagem.get(Calendar.YEAR));
	}
	
	
	public String getHorario(){
		return String.format("%02d:%02d", dataDePostagem.get(Calendar.HOUR_OF_DAY),
				dataDePostagem.get(Calendar.MINUTE));
	}
	
}
