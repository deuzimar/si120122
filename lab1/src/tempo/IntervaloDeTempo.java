package tempo;

public class IntervaloDeTempo {
	
	private double intervalo;
	private UnidadeDeTempo unidade;
	
	public IntervaloDeTempo(double intervalo, UnidadeDeTempo unidade){
		this.intervalo = intervalo;
		this.unidade = unidade;
	}

	public double getValue(){
		return intervalo;
	}
	
	public UnidadeDeTempo getUnidade(){
		return unidade;
	}
	
}
