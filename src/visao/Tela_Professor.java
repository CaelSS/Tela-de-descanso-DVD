package visao;
import javax.swing.JPanel;
import controle.ControleDisciplina;
import controle.ControleProfessor;
import modelo.Professor;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

public class Tela_Professor extends JPanel {

	ControleProfessor cp = new ControleProfessor();
	private DefaultTableModel modeloTabela;
	private JTextField tftNomeProfessor;
	private JTextField textCPF;
	private JTextField textIDADE;
	private JTextField textDataNasc;
	private JTextField textCurso;
	private JLabel JblCPF;
	private JLabel lblIdade;
	private JLabel lblDataNasc;
	private JLabel lblCurso;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JLabel lblDisciplina;
	private JTextField textProfDisciplina;
	private JTextField textCargaHora;
	private JTextField textTitulacao;
	private JLabel lblTituloCadastroProfessor;

	
// o diacho pra popular a tabela que foi dificil entender
	public void popularTabela(ArrayList<Professor> professores) {
		modeloTabela.setRowCount(0);
		professores.forEach(professor -> modeloTabela.addRow(
				new String[]{
						professor.getNome(), 
						professor.getCpf(),
						professor.getIdade(),
						professor.getData_nasc(),
						professor.getCurso(),
						professor.getDisciplina(),
						professor.getCarga_horaria(),
						professor.getTitulacao(),
						}));

	}

	/**
	 * criacao do frame.
	 */
	public Tela_Professor() {

		//setBounds(100, 100, 700, 329);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		// Campos de texto do prof

		tftNomeProfessor = new JTextField();
		tftNomeProfessor.setColumns(10);

		textCPF = new JTextField();
		textCPF.setColumns(10);

		textIDADE = new JTextField();
		textIDADE.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setColumns(10);

		textCurso = new JTextField();
		textCurso.setColumns(10);
		
		
		textProfDisciplina = new JTextField();
		textProfDisciplina.setColumns(10);
		
		JLabel lblCargaHoraria = new JLabel("Carga Hora:");
		
		textCargaHora = new JTextField();
		textCargaHora.setColumns(10);
		
		JLabel lblTitulacao = new JLabel("Titulação");
		
		textTitulacao = new JTextField();
		textTitulacao.setColumns(10);

		JLabel JblNomeProf = new JLabel("Nome:");

		JblCPF = new JLabel("CPF");

		lblIdade = new JLabel("Idade");

		lblDataNasc = new JLabel("Data Nasc.");

		lblCurso = new JLabel("Curso:");
		
		lblDisciplina = new JLabel("Disciplina:");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // fecha o trem se apertar nele
			}
		});

		JButton btnBotaoSalvar = new JButton("Salvar");
		btnBotaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Professor professor = new Professor();
				professor.setNome(tftNomeProfessor.getText());
				professor.setCpf(textCPF.getText());
				professor.setIdade(textIDADE.getText());
				professor.setData_nasc(textDataNasc.getText());
				professor.setCurso(textCurso.getText());
				professor.setDisciplina(textProfDisciplina.getText());
				professor.setCarga_horaria(textCargaHora.getText());
				professor.setTitulacao(textTitulacao.getText());

				if (cp.salvarProfessor(professor)) {
					JOptionPane.showMessageDialog(null, "Professor Cadastrado");
					tftNomeProfessor.setText("");
					textCPF.setText("");
					textIDADE.setText("");
					textDataNasc.setText("");
					textCurso.setText("");
					textProfDisciplina.setText("");
					textCargaHora.setText("");
					textTitulacao.setText("");
					
				popularTabela(cp.retornarDadosProfessor());
				cp.salvarEmArquivo("C:\\Users\\Cael\\Desktop\\Dados_do_professors.txt");
				} else {

					JOptionPane.showMessageDialog(null, "Deu ruim");
				}
			}
		});

		scrollPane_1 = new JScrollPane();
		
		lblTituloCadastroProfessor = new JLabel("Cadastre Professor:");
		lblTituloCadastroProfessor.setForeground(new Color(88, 146, 167));
		lblTituloCadastroProfessor.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		
		
		
		
		
		

		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(31)
											.addComponent(JblCPF))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblIdade)
											.addComponent(lblDataNasc)
											.addComponent(lblCurso)
											.addComponent(lblDisciplina)
											.addComponent(lblCargaHoraria)
											.addComponent(lblTitulacao)))
									.addGap(10))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(JblNomeProf)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textTitulacao, Alignment.LEADING)
								.addComponent(textCargaHora, Alignment.LEADING)
								.addComponent(textProfDisciplina, Alignment.LEADING)
								.addComponent(textCurso, Alignment.LEADING)
								.addComponent(textDataNasc, Alignment.LEADING)
								.addComponent(textIDADE, Alignment.LEADING)
								.addComponent(textCPF, Alignment.LEADING)
								.addComponent(tftNomeProfessor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(171)
									.addComponent(btnBotaoSalvar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCancelar))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(lblTituloCadastroProfessor)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTituloCadastroProfessor)
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tftNomeProfessor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JblNomeProf))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JblCPF))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textIDADE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdade))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDataNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataNasc))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurso))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDisciplina)
								.addComponent(textProfDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCargaHoraria)
								.addComponent(textCargaHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitulacao)
								.addComponent(textTitulacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBotaoSalvar)
								.addComponent(btnCancelar))
							.addGap(42))))
		);
		this.setLayout(gl_contentPane);

		
		
		
		
		
		ArrayList<String> colunas = new ArrayList<String>(Arrays.asList("Nome", "CPF", "Idade", "Data Nasc", "Curso","Disciplina", "Carga Hora", "Titulação") );
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		modeloTabela = new DefaultTableModel();
		
		colunas.forEach(coluna -> modeloTabela.addColumn(coluna));
		table.setModel(modeloTabela);	
		scrollPane_1.setViewportView(table);
		setLayout(gl_contentPane);
	}
}
