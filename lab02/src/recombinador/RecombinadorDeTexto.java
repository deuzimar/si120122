package recombinador;

import exception.NaoHaMaisLinhasException;
import sistema.Texto;

public interface RecombinadorDeTexto {
	public String getLinha() throws NaoHaMaisLinhasException;
	public void setTexto(Texto texto);
	public boolean haMaisLinhas();

}
