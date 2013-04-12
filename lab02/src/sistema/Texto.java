package sistema;

import java.util.Arrays;
import java.util.List;

public class Texto {
	List<String> palavras;
	int NUM_PALAVRAS_INTRODUCAO = 12;
	int NUM_PALAVRAS_LINHA = 10;
	public Texto(String texto){
		this.palavras = Arrays.asList(texto.split("\\s+"));
	}
	
	public String getIntroducaoDoTexto(){
		if (palavras.size() < NUM_PALAVRAS_INTRODUCAO){
			return linhaParaString(palavras);
		}
		return linhaParaString(palavras.subList(0, NUM_PALAVRAS_INTRODUCAO));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((palavras == null) ? 0 : palavras.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Texto other = (Texto) obj;
		if (palavras == null) {
			if (other.palavras != null)
				return false;
		} else if (!palavras.equals(other.palavras))
			return false;
		return true;
	}

	private String linhaParaString(List<String> lista){
		String msg = "";
		for(String palavra : lista){
			msg += palavra + " ";
		}
		return msg;
	}
	
	public int getNumeroDeLinhas(){
		int linhas = ((palavras.size()-1)/NUM_PALAVRAS_LINHA) + 1;
		return linhas;
	}
	
	
	public String getLinha(int numeroDaLinha){
		
		return linhaParaString(palavras.subList(numeroDaLinha*NUM_PALAVRAS_LINHA, 
				Math.min(palavras.size(), (numeroDaLinha +1)*NUM_PALAVRAS_LINHA )));
	}
	
	
}
