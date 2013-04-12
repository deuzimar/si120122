package recombinador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sistema.Texto;
import exception.NaoHaMaisLinhasException;

public class RecombinadorAleatorioSemRepeticao implements RecombinadorDeTexto {

	private Texto texto;
	private int linhasRestantes = 0;
	private List<Integer> indicesRestantes;
	private Random generator = new Random();

	@Override
	public String getLinha() throws NaoHaMaisLinhasException {
		if (linhasRestantes == 0) {
			throw new NaoHaMaisLinhasException("Não há mais linhas.");
		}
		int index = generator.nextInt(linhasRestantes--);
		String linha = texto.getLinha(indicesRestantes.get(index));
		indicesRestantes.remove(index);
		return linha;
	}

	@Override
	public void setTexto(Texto texto) {
		this.texto = texto;
		this.linhasRestantes = texto.getNumeroDeLinhas();
		preparaIndices();
	}

	private void preparaIndices() {
		indicesRestantes = new ArrayList<Integer>();
		for(int i = 0 ; i < linhasRestantes ; i++){
			indicesRestantes.add(i);
		}
	}

	@Override
	public boolean haMaisLinhas() {
		return linhasRestantes != 0;
	}

}
