package visao;
import javax.swing.JPanel;
import controle.ControleDisciplina;
import modelo.Disciplina;
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

public class Tela_Disciplina extends JPanel {

	ControleDisciplina cd = new ControleDisciplina();
	private DefaultTableModel modeloTabela;
	private JTextField tftNomeDisciplina;
	private JTextField textCodigoDisciplina;
	private JTextField textProfessorDisciplina;
	private JTextField textNumSala;
	private JTextField textHorasAula;
	private JLabel lblCodigoDisciplina;
	private JLabel lblProfessorDisciplina;
	private JLabel lblNumSala;
	private JLabel lblHorasAula;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JLabel lblTituloCadastroDisciplina;

	
// o diacho pra popular a tabela que foi dificil entender
	public void popularTabela(ArrayList<Disciplina> disciplinas) {
		modeloTabela.setRowCount(0);
		disciplinas.forEach(disciplina -> modeloTabela.addRow(
				new String[]{
						disciplina.getNome(), 
						disciplina.getCodigoDaDisciplina(),
						disciplina.getProfDisciplina(),
						disciplina.getNumeroSala(),
						disciplina.getHorasAula()
						}));

	}

	/**
	 * criacao do frame.
	 */
	public Tela_Disciplina() {

		//setBounds(100, 100, 700, 329);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		// Campos de texto da disciplina

		tftNomeDisciplina = new JTextField();
		tftNomeDisciplina.setColumns(10);

		textCodigoDisciplina = new JTextField();
		textCodigoDisciplina.setColumns(10);

		textProfessorDisciplina = new JTextField();
		textProfessorDisciplina.setColumns(10);

		textNumSala = new JTextField();
		textNumSala.setColumns(10);

		textHorasAula = new JTextField();
		textHorasAula.setColumns(10);

		JLabel JblNomeDisciplina = new JLabel("Nome:");

		lblCodigoDisciplina = new JLabel("Codigo Disciplina:");

		lblProfessorDisciplina = new JLabel("Professor:");

		lblNumSala = new JLabel("Nº da Sala:");

		lblHorasAula = new JLabel("Horas Aula:");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // fecha o trem se apertar nele
			}
		});

		JButton btnBotaoSalvar = new JButton("Salvar");
		btnBotaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Disciplina disciplina = new Disciplina();
				disciplina.setNome(tftNomeDisciplina.getText());
				disciplina.setCodigoDaDisciplina(textCodigoDisciplina.getText());
				disciplina.setProfDisciplina(textProfessorDisciplina.getText());
				disciplina.setNumeroSala(textNumSala.getText());
				disciplina.setHorasAula(textHorasAula.getText());

				if (cd.salvar(disciplina)) {
					JOptionPane.showMessageDialog(null, "DISCIPLINA CADASTRADA");
					tftNomeDisciplina.setText("");
					textCodigoDisciplina.setText("");
					textProfessorDisciplina.setText("");
					textNumSala.setText("");
					textHorasAula.setText("");
				popularTabela(cd.retornarDadosDisciplina());
				
				cd.salvarEmArquivo("C:\\Users\\Cael\\Desktop\\Dados_da_Disciplina.txt");
				} else {

					JOptionPane.showMessageDialog(null, "Deu ruim");
				}
			}
		});

		scrollPane_1 = new JScrollPane();
		
		lblTituloCadastroDisciplina = new JLabel("Cadastre Disciplina:");
		lblTituloCadastroDisciplina.setForeground(new Color(88, 146, 167));
		lblTituloCadastroDisciplina.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		
		
		
		
		

		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTituloCadastroDisciplina, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodigoDisciplina)
								.addComponent(lblProfessorDisciplina)
								.addComponent(lblNumSala)
								.addComponent(lblHorasAula)
								.addComponent(JblNomeDisciplina))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textHorasAula)
								.addComponent(textNumSala, Alignment.TRAILING)
								.addComponent(textProfessorDisciplina, Alignment.TRAILING)
								.addComponent(textCodigoDisciplina, Alignment.TRAILING)
								.addComponent(tftNomeDisciplina, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnBotaoSalvar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCancelar)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTituloCadastroDisciplina, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnBotaoSalvar)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tftNomeDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JblNomeDisciplina))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCodigoDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigoDisciplina))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textProfessorDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProfessorDisciplina))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNumSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumSala))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHorasAula)
								.addComponent(textHorasAula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		this.setLayout(gl_contentPane);

		
		
		
		
		
		ArrayList<String> colunas = new ArrayList<String>(Arrays.asList("Nome", "codigo", "professor", "sala", "Horas aula") );
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		modeloTabela = new DefaultTableModel();
		
		colunas.forEach(coluna -> modeloTabela.addColumn(coluna));
		table.setModel(modeloTabela);	
		scrollPane_1.setViewportView(table);
		setLayout(gl_contentPane);
	}
}
