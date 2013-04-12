package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.NaoHaMaisLinhasException;
import exception.RecombinadorInexistente;

import recombinador.RecombinadorAleatorioComRepeticao;
import recombinador.RecombinadorAleatorioSemRepeticao;
import recombinador.RecombinadorDeTexto;
import recombinador.RecombinadorInverso;

public class Sistema {
	private List<Texto> textos;
	private Map<String, RecombinadorDeTexto> recombinadores;
	private RecombinadorDeTexto recombinadorAtual;
	private static Sistema instancia;
	
	public static Sistema getInstance(){
		if(instancia == null){
			instancia = new Sistema();
		}
		return instancia;
	}
	private Sistema(){
		this.textos = new ArrayList<Texto>();
		this.recombinadores = new HashMap<String, RecombinadorDeTexto>();
		inicializaRecombinadores();
	}
	private void inicializaRecombinadores() {
	recombinadores.put("Recombinador Aleatorio sem Repeticao", new RecombinadorAleatorioSemRepeticao());
	recombinadores.put("Recombinador Aleatorio com Repeticao", new RecombinadorAleatorioComRepeticao());
	recombinadores.put("Recombinador Inverso", new RecombinadorInverso());
	}
	
	public List<String> getRecombinadores(){
		List<String> recombinadores = new ArrayList<String>();
		recombinadores.addAll(this.recombinadores.keySet());
		return recombinadores;
	}
	
	public void novoTexto(String texto){
		textos.add(new Texto(texto));
	}
	
	public List<Texto> getTextos(){
		
		return textos;
	}
	
	public void preparaRecombinador(String chaveRecomendador, Texto texto) throws RecombinadorInexistente{
		recombinadorAtual = recombinadores.get(chaveRecomendador);
		recombinadorAtual.setTexto(texto);
		if(recombinadorAtual == null){
			throw new RecombinadorInexistente("Recombinador inexistente.");
		}
	}
	
	public String getNovaLinha() throws NaoHaMaisLinhasException{
		return recombinadorAtual.getLinha();
	}
	public Texto achaTexto(String introducao) {
		for(Texto texto : textos){
			if(texto.getIntroducaoDoTexto().equals(introducao)){
				return texto;
			}
		}
		return null;
	}
	public boolean haLinhas() {
		if(recombinadorAtual == null){
			return false;
		}
		return recombinadorAtual.haMaisLinhas();
	}
}
