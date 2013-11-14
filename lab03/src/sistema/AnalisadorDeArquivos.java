package sistema;
quebra
	private ObservadorDeAnaliseDeArquivo observer;

	public AnalisadorDeArquivos() {
		this.arquivos = new ArrayList<File>();
		this.threads = new ArrayList<ThreadAnalisadoraDeArquivo>();
		this.contagem = new HashMap<String, Integer>();
		this.tempoDeExecucao = 0;
		iniciaContagem();
	}
	
	public void setObserver(ObservadorDeAnaliseDeArquivo observer) {
		this.observer = observer;
	}
	
	public void processaArquivos(String dir,int maxThreads){
		iniciaContagem();
		preparaArquivos(dir);
		iniciaThreads(maxThreads);
	}
	
	private void iniciaContagem() {
		for (String palavra : PalavrasReservadasJava.getPalavras()) {
			contagem.put(palavra, 0);
		}
	}

	public void preparaArquivos(String dir) {
		arquivos.clear();
		FileUtil.fillAllFilesList(arquivos, new File(dir));
		fileIterator = arquivos.iterator();
		if(observer != null){
			observer.arquivosEncontrados(arquivos.size());
		}
	}

	public void iniciaThreads(int numMaxThreads) {
		if(numMaxThreads == 0){
			numMaxThreads = 5;
		}
		for (int i = numMaxThreads; i > 0 ; i--) {
			ThreadAnalisadoraDeArquivo thread = new ThreadAnalisadoraDeArquivo(this);
			threads.add(thread);
			thread.start();	
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
	
	public Map<String, Integer> getContagem(){
		return contagem;
	}

	@Override
	public synchronized void arquivoAnalizado(Map<String, Integer> contagemNoArquivo) {
		for(String palavra: contagemNoArquivo.keySet()){
			contagem.put(palavra, contagem.get(palavra) + contagemNoArquivo.get(palavra));
		}
		if(observer != null){
			observer.arquivoAnalisado();
		}
	}
}
