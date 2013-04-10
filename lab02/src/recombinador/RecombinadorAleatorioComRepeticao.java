package recombinador;

import java.util.Random;

import sistema.Texto;
import exception.NaoHaMaisLinhasException;

public class RecombinadorAleatorioComRepeticao implements RecombinadorDeTexto{

	private Texto texto;
	private int numeroDeLinhas;
	@Override
	public String getLinha() throws NaoHaMaisLinhasException {
		Random rand = new Random();
		return texto.getLinha(rand.nextInt(numeroDeLinhas));
	}

	@Override
	public void setTexto(Texto texto) {
		this.texto = texto;
		this.numeroDeLinhas = texto.getNumeroDeLinhas();
	}

	@Override
	public boolean haMaisLinhas() {
		return true;
	}

}
