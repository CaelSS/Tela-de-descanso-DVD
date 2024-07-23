package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Tela_Principal extends JFrame {

	private JPanel contentPane;
	private Tela_Disciplina tela_disciplina = new Tela_Disciplina();
	private Tela_Professor tela_professor = new Tela_Professor();
	private Tela_Aluno  tela_aluno = new Tela_Aluno();

/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal frame = new Tela_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel painelCadastros = new JPanel();
		painelCadastros.setBounds(0, 0, 724, 383);
		contentPane.add(painelCadastros);
		
		
		JButton btnCadDisciplina = new JButton("Cadastro Disciplina");
		btnCadDisciplina.setVerticalAlignment(SwingConstants.TOP);
		btnCadDisciplina.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		btnCadDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastros.removeAll();
				painelCadastros.add(tela_disciplina);
				painelCadastros.revalidate();
				painelCadastros.repaint();
			}
		});
		btnCadDisciplina.setBounds(123, 427, 149, 23);
		contentPane.add(btnCadDisciplina);
		
		JButton btnCadProf = new JButton("Cadastro Professor");
		btnCadProf.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		btnCadProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastros.removeAll();
				painelCadastros.add(tela_professor);
				painelCadastros.revalidate();
				painelCadastros.repaint();
			}
		});
		btnCadProf.setBounds(282, 427, 139, 23);
		contentPane.add(btnCadProf);
		
		JButton btnCadAluno = new JButton("Cadastro Aluno");
		btnCadAluno.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
		btnCadAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastros.removeAll();
				painelCadastros.add(tela_aluno);
				painelCadastros.revalidate();
				painelCadastros.repaint();
			}
		});
		btnCadAluno.setBounds(431, 427, 136, 23);
		contentPane.add(btnCadAluno);
		
		JLabel JblTituloDosBotoes = new JLabel("ESCOLHA O QUE CADASTRAR:");
		JblTituloDosBotoes.setToolTipText("");
		JblTituloDosBotoes.setFont(new Font("Sitka Text", Font.BOLD, 17));
		JblTituloDosBotoes.setBounds(230, 393, 280, 23);
		contentPane.add(JblTituloDosBotoes);
		
		ImageIcon gifIcon = new ImageIcon("C:\\Users\\Cael\\Documents\\giphy.gif"); //adiciona o diretorio
        JLabel gifLabel = new JLabel(gifIcon);
        painelCadastros.add(gifLabel, BorderLayout.CENTER);

		
		
		
	}
}
