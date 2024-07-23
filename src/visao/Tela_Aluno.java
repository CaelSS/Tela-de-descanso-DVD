package visao;
import javax.swing.JPanel;

import controle.ControleAluno;
import controle.ControleProfessor;
import modelo.Aluno;

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
import java.awt.Color;
import java.awt.Font;

public class Tela_Aluno extends JPanel {

	ControleAluno ca = new ControleAluno();
	private DefaultTableModel modeloTabela;
	private JTextField tftNomeAluno;
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
	private JLabel lblMatricula;
	private JTextField textMatricula;
	private JLabel LblTituloPainelAluno;

	
// o diacho pra popular a tabela que foi dificil entender
	public void popularTabela(ArrayList<Aluno> alunos) {
		modeloTabela.setRowCount(0);
		alunos.forEach(aluno -> modeloTabela.addRow(
				new String[]{
						aluno.getNome(), 
						aluno.getCpf(),
						aluno.getIdade(),
						aluno.getData_nasc(),
						aluno.getCurso(),
						aluno.getMatricula(),
						
						}));

	}

	/**
	 * criacao do frame.
	 */
	public Tela_Aluno() {
		setForeground(new Color(192, 192, 192));
		setBackground(new Color(240, 240, 240));

		//setBounds(100, 100, 700, 329);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		// Campos de texto do aluno

		tftNomeAluno = new JTextField();
		tftNomeAluno.setColumns(10);

		textCPF = new JTextField();
		textCPF.setColumns(10);

		textIDADE = new JTextField();
		textIDADE.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setColumns(10);

		textCurso = new JTextField();
		textCurso.setColumns(10);
		
		
		textMatricula = new JTextField();
		textMatricula.setColumns(10);

		JLabel JblNomeProf = new JLabel("Nome:");

		JblCPF = new JLabel("CPF:");

		lblIdade = new JLabel("Idade:");

		lblDataNasc = new JLabel("Data Nasc:");

		lblCurso = new JLabel("Curso:");
		
		lblMatricula = new JLabel("Matricula:");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // fecha o trem se apertar nele
			}
		});

		JButton btnBotaoSalvar = new JButton("Salvar");
		btnBotaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Aluno aluno = new Aluno();
				aluno.setNome(tftNomeAluno.getText());
				aluno.setCpf(textCPF.getText());
				aluno.setIdade(textIDADE.getText());
				aluno.setData_nasc(textDataNasc.getText());
				aluno.setCurso(textCurso.getText());
				aluno.setMatricula(textMatricula.getText());

				if (ca.salvarAluno(aluno)) {
					JOptionPane.showMessageDialog(null, "Aluno Cadastrado");
					tftNomeAluno.setText("");
					textCPF.setText("");
					textIDADE.setText("");
					textDataNasc.setText("");
					textCurso.setText("");
					textMatricula.setText("");					
					
				popularTabela(ca.retornarDadosDosAlunos());
				ca.salvarEmArquivo("C:\\Users\\Cael\\Desktop\\Dados_do_aluno.txt");
				} else {

					JOptionPane.showMessageDialog(null, "Deu ruim");
				}
			}
		});

		scrollPane_1 = new JScrollPane();
		
		LblTituloPainelAluno = new JLabel("CADASTRE ALUNO:");
		LblTituloPainelAluno.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		LblTituloPainelAluno.setForeground(new Color(88, 146, 167));
		
		
		
		
		
		

		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCurso)
										.addComponent(lblMatricula)
										.addComponent(lblDataNasc)
										.addComponent(lblIdade)
										.addComponent(JblCPF)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(JblNomeProf)))
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textMatricula, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(textIDADE, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(tftNomeAluno, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(textCPF, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(textDataNasc, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(textCurso, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBotaoSalvar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCancelar))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(LblTituloPainelAluno)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(LblTituloPainelAluno)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tftNomeAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(lblMatricula)
								.addComponent(textMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnBotaoSalvar))
					.addGap(36))
		);
		this.setLayout(gl_contentPane);

		
		
		
		
		
		ArrayList<String> colunas = new ArrayList<String>(Arrays.asList("Nome", "CPF", "Idade", "Data Nasc", "Curso","Matricula") );
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		modeloTabela = new DefaultTableModel();
		
		colunas.forEach(coluna -> modeloTabela.addColumn(coluna));
		table.setModel(modeloTabela);	
		scrollPane_1.setViewportView(table);
		setLayout(gl_contentPane);
	}
}
