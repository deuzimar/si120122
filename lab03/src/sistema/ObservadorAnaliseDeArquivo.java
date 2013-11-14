package sistema;

import java.util.Map;

public interface ObservadorAnaliseDeArquivo {

	void proximoArquivo(ThreadAnalisadoraDeArquivo thread);

	void arquivoAnalizado(Map<String, Integer> contagemNoArquivo);
	
}
