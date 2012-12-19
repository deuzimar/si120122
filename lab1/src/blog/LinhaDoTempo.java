package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.cfg.defs.MaxDef;

import tempo.IntervaloDeTempo;
import tempo.UnidadeDeTempo;
import exception.InvalidLinkException;

public class LinhaDoTempo {

	private ArrayList<Link> links;
	private Map<String,Integer> postagensDoSite;

	public LinhaDoTempo(){
		links = new ArrayList<Link>();
		postagensDoSite = new HashMap<String, Integer>();
	}

	public void posta(String endereco) throws InvalidLinkException{
		if (endereco.startsWith("http://") ||
				endereco.startsWith("https://")){
			links.add(new Link(endereco));
			String dominio = getDominioDoSite(endereco);
			postagensDoSite.put(dominio,
					postagensDoSite.get(dominio)!= null? postagensDoSite.get(dominio) + 1: 1);
		}else{
			throw new InvalidLinkException("Link Inválido.");
		}

	}

	private String getDominioDoSite(String endereco) {
		String dominio = endereco.split("/")[2];
		if(dominio.startsWith("www.")){
			dominio = dominio.substring(4);
		}
		return dominio;
	}

	public IntervaloDeTempo getTempoMedioEntrePostagens(){

		if (links.size() < 2){
			return null;
		}else{
			Date dataPrimeiraPostagem = links.get(0).getDataDePostagem();
			Date dataUltimaPostagem = links.get(links.size()-1).getDataDePostagem();
			return calculaTempoMedio(dataPrimeiraPostagem,dataUltimaPostagem);
		}
	}

	private IntervaloDeTempo calculaTempoMedio(Date dataPrimeiraPostagem,
			Date dataUltimaPostagem) {
		int numeroDePostagens = links.size() -1;
		double milisegundosPorDia = 1000*60*60*24;
		double tempoEntreDatasMiliSec = dataUltimaPostagem.getTime() - dataPrimeiraPostagem.getTime();
		double tempoMedioEntrePostagens = tempoEntreDatasMiliSec/(milisegundosPorDia*numeroDePostagens);
		if(tempoMedioEntrePostagens >= 1f){
			return new IntervaloDeTempo(tempoMedioEntrePostagens,UnidadeDeTempo.Dias);
		}else {
			tempoMedioEntrePostagens *= 24;
			if(tempoMedioEntrePostagens >= 1f){
				return new IntervaloDeTempo(tempoMedioEntrePostagens, UnidadeDeTempo.Horas);
			}else{
				tempoMedioEntrePostagens *= 60;
				if(tempoMedioEntrePostagens >= 1f){
					return new IntervaloDeTempo(tempoMedioEntrePostagens, UnidadeDeTempo.Minutos);
				}else{
					tempoMedioEntrePostagens *= 60;
					return new IntervaloDeTempo(tempoMedioEntrePostagens, UnidadeDeTempo.Segundos);
				}
			}
		}

	}

	public void posta(String endereco, int dia, int mes, int ano, int hora, int minuto) {
		links.add(new Link(endereco, dia, mes, ano, hora, minuto));	
	}

	public String getSiteMaisPostado() {
		String siteMaisPostado= "";
		int maximoDePostagens = 0;
		for(String key : postagensDoSite.keySet()){
			if(postagensDoSite.get(key) > maximoDePostagens){
				siteMaisPostado = key;
				maximoDePostagens = postagensDoSite.get(key);
			}
		}
		return siteMaisPostado;
	}

	public List<Link> getUltimosLinksPostados(){
		if(links.size() < 10){
			return links.subList(0, links.size());
		}else{
			return links.subList(0, 10);
		}
	}

}
