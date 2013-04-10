package recombinador;

import exception.NaoHaMaisLinhasException;
import sistema.Texto;

public class RecombinadorInverso implements RecombinadorDeTexto {
	Texto texto;
	int linhaAtual = Integer.MIN_VALUE;
	@Override
	public String getLinha() throws NaoHaMaisLinhasException {
		if(linhaAtual == Integer.MIN_VALUE){
			linhaAtual = texto.getNumeroDeLinhas() - 1;
		}else if(linhaAtual == -1){
			throw new NaoHaMaisLinhasException("Nao há mais linhas.");
		}
		return texto.getLinha(linhaAtual--);
	}

	@Override
	public void setTexto(Texto texto) {
		this.texto = texto;
	}

	@Override
	public boolean haMaisLinhas() {
		return linhaAtual == -1;
	}

}
