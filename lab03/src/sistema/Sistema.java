package sistema;

import gui.AnalisadorFrame;

public class Sistema {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnalisadorDeArquivos a = new AnalisadorDeArquivos();
		AnalisadorFrame frame = new AnalisadorFrame(a);
		frame.setVisible(true);
	}

}
