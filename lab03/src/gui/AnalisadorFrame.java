package gui;

import java.io.File;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import sistema.AnalisadorDeArquivos;
import sistema.ObservadorDeAnaliseDeArquivo;

public class AnalisadorFrame extends javax.swing.JFrame implements
		ObservadorDeAnaliseDeArquivo {

	private AnalisadorDeArquivos analisador;
	private int arquivosProcessados;
	private int maxArquivos;
	private long inicio;

	/**
	 * Creates new form AnalisadorFrame
	 */
	public AnalisadorFrame(AnalisadorDeArquivos analisador) {
		this.setTitle("Analisador de Arquivos Java");
		this.analisador = analisador;
		this.analisador.setObserver(this);
		arquivosProcessados = 0;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		AnalisarButton = new javax.swing.JButton();
		numThreads = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 100,
				1));
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		progressText = new javax.swing.JTextField();
		jTextArea1 = new javax.swing.JTextArea();
		progressBar = new javax.swing.JProgressBar();
		resultMessage = new javax.swing.JTextField();

		progressBar.setMinimum(0);
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 333,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		AnalisarButton.setText("Analisar Diret�rio");
		AnalisarButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AnalisarButtonActionPerformed(evt);
			}
		});

		jLabel1.setText("N�mero M�ximo de Threads :");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addGap(138, 138, 138)
										.addComponent(jLabel1)
										.addGap(18, 18, 18)
										.addComponent(
												numThreads,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												54,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(AnalisarButton)
										.addGap(43, 43, 43)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																AnalisarButton)
														.addComponent(
																numThreads,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel1))
										.addContainerGap(15, Short.MAX_VALUE)));

		jTable1.setAutoCreateColumnsFromModel(true);
		jTable1.setAutoCreateRowSorter(true);
		jTable1.setModel(new PalavrasReservadasTableModel(analisador
				.getContagem()));
		jScrollPane1.setViewportView(jTable1);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setText("0 de 0 Arquivos processados");

		resultMessage.setText("Nenhuma an�lise foi realisada.");
		resultMessage.setToolTipText("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jPanel2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addComponent(
																										progressText,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										269,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										progressBar,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										jScrollPane1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										627,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										resultMessage,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										627,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGap(0,
																		9,
																		Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(3, 3, 3)
																.addComponent(
																		progressBar,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addComponent(
														progressText,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														31,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 21, Short.MAX_VALUE)
								.addComponent(resultMessage,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										404,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		pack();
	}

	private void AnalisarButtonActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jchooser = new JFileChooser(
				"Escolha a pasta de origem da pesquisa");
		jchooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jchooser.showOpenDialog(this);
		File dirFile = jchooser.getSelectedFile();
		if (dirFile == null)
			return;
		arquivosProcessados = 0;
		inicio = System.currentTimeMillis();
		analisador.processaArquivos(dirFile.getAbsolutePath(),
				(Integer) numThreads.getValue());
	}

	private JButton AnalisarButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JSpinner numThreads;
	private javax.swing.JProgressBar progressBar;
	private JTextField progressText;
	private javax.swing.JTextField resultMessage;

	@Override
	public void arquivosEncontrados(int num) {
		progressBar.setMaximum(num);
		maxArquivos = num;
	}

	@Override
	public void arquivoAnalisado() {
		progressBar.setValue(++arquivosProcessados);
		progressText.setText(arquivosProcessados + " de " + maxArquivos
				+ " Arquivos processados");
		progressBar.updateUI();
		progressText.updateUI();
		jTable1.updateUI();
		if (arquivosProcessados == maxArquivos) {
			resultMessage
					.setText("An�lise dos arquivos conclu�da em "
							+ (System.currentTimeMillis() - inicio)
							+ " milissegundos.");
		}
	}
}
