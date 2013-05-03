package sistema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import util.FileUtil;
import util.PalavrasReservadasJava;

public class AnalisadorDeArquivos implements ObservadorAnaliseDeArquivo {
	private List<File> arquivos;
	List<ThreadAnalisadoraDeArquivo> threads;
	private Iterator<File> fileIterator;
	private Map<String, Integer> contagem;
	int arquivosProcessados;
	int tempoDeExecucao;

	public AnalisadorDeArquivos() {
		this.arquivos = new ArrayList<File>();
		this.threads = new ArrayList<ThreadAnalisadoraDeArquivo>();
		this.contagem = new HashMap<String, Integer>();
		this.arquivosProcessados = 0;
		this.tempoDeExecucao = 0;
		iniciaContagem();
	}
	
	public long processaArquivos(String dir,int maxThreads){
		long tempoInicial = System.currentTimeMillis();
		preparaArquivos(dir);
		iniciaThreads(maxThreads);
		return System.currentTimeMillis() - tempoInicial;	
	}
	
	private void iniciaContagem() {
		for (String palavra : PalavrasReservadasJava.getPalavras()) {
			contagem.put(palavra, 0);
		}
	}

	public void preparaArquivos(String dir) {
		FileUtil.fillAllFilesList(arquivos, new File(dir));
		fileIterator = arquivos.iterator();
	}

	public void iniciaThreads(int numMaxThreads) {
		if(numMaxThreads == 0){
			numMaxThreads = arquivos.size();
		}
		for (int i = numMaxThreads; i > 0 && fileIterator.hasNext(); i--) {
			ThreadAnalisadoraDeArquivo thread = new ThreadAnalisadoraDeArquivo(this);
			threads.add(thread);
			thread.start();	
		}
		for(Thread t : threads){
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public synchronized void proximoArquivo(
			ThreadAnalisadoraDeArquivo thread) {
		if (fileIterator.hasNext()) {
			thread.novoArquivo(fileIterator.next());
		}else{
			thread.novoArquivo(null);
		}

	}

	@Override
	public synchronized void arquivoAnalizado(Map<String, Integer> contagemNoArquivo) {
		for(String palavra: contagemNoArquivo.keySet()){
			contagem.put(palavra, contagem.get(palavra) + contagemNoArquivo.get(palavra));
		}
		arquivosProcessados += 1;
	}
}
