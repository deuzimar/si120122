package sistema;

import java.util.Map;

public interface ObservadorDeThreadDeArquivo {

	void proximoArquivo(ThreadAnalisadoraDeArquivo thread);

	void arquivoAnalizado(Map<String, Integer> contagemNoArquivo);
	
}
