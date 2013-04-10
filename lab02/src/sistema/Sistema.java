package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recombinador.RecombinadorAleatorioComRepeticao;
import recombinador.RecombinadorAleatorioSemRepeticao;
import recombinador.RecombinadorDeTexto;
import recombinador.RecombinadorInverso;

public class Sistema {
	private List<Texto> textos;
	private Map<String, RecombinadorDeTexto> recombinadores;
	public Sistema(){
		this.textos = new ArrayList<Texto>();
		this.recombinadores = new HashMap<String, RecombinadorDeTexto>();
		inicializaRecombinadores();
	}
	private void inicializaRecombinadores() {
	recombinadores.put("Recombinador Aleatório sem Repetição", new RecombinadorAleatorioSemRepeticao());
	recombinadores.put("Recombinador Aleatório com Repetição", new RecombinadorAleatorioComRepeticao());
	recombinadores.put("Recombinador Inverso", new RecombinadorInverso());
	}
}
