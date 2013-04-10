package sistema;

import java.util.Arrays;
import java.util.List;

import org.picketbox.util.StringUtil;

import com.ibm.wsdl.util.StringUtils;

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
	
	private String linhaParaString(List<String> lista){
		String msg = "";
		for(String palavra : lista){
			msg += palavra + " ";
		}
		return msg;
	}
	
	public int getNumeroDeLinhas(){
		int linhas = (palavras.size()/NUM_PALAVRAS_LINHA) + 1;
		return linhas;
	}
	
	
	public String getLinha(int numeroDaLinha){
		
		return linhaParaString(palavras.subList(numeroDaLinha*NUM_PALAVRAS_LINHA, 
				Math.max(palavras.size(), (numeroDaLinha +1)*NUM_PALAVRAS_LINHA - 1 )));
	}
}
