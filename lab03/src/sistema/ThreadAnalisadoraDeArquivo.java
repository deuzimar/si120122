package sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.PalavrasReservadasJava;

public class ThreadAnalisadoraDeArquivo extends Thread {

	private ObservadorDeThreadDeArquivo observer;
	private File file;
	private Map<String, Integer> contagem;
	private List<String> reservadas;

	public ThreadAnalisadoraDeArquivo(ObservadorDeThreadDeArquivo obs) {
		this.observer = obs;
		this.reservadas = Arrays.asList(PalavrasReservadasJava.getPalavras());
		this.contagem = new HashMap<String, Integer>();
		iniciaContagem();
	}

	private void iniciaContagem() {
		for (String palavra : reservadas) {
			contagem.put(palavra, 0);
		}
	}

	@Override
	public void run() {
		while (true) {
			observer.proximoArquivo(this);
			if(file == null) break;
			iniciaContagem();
			analisaArquivo();
			observer.arquivoAnalizado(contagem);
		}

	}

	private void analisaArquivo() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));

			Pattern padrao = Pattern.compile("[a-z]+");
			Matcher matcher;

			String linha = reader.readLine();
			while (linha != null) {
				matcher = padrao.matcher(linha);
				while (matcher.find()) {
					String palavra = matcher.group();
					if (reservadas.contains(palavra)) {
						contagem.put(palavra, contagem.get(palavra) + 1);
					}
				}
				linha = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}

	public void novoArquivo(File file) {
		this.file = file;
	}
}
