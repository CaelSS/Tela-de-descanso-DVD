package controle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Aluno;
import modelo.Professor;

public class ControleProfessor {

	private ArrayList<Professor> professores = new ArrayList<>();

	public boolean salvarProfessor(Professor professor) {

		try {

			professores.add(professor);
			System.out.println(professor);

			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;

		}
	}

	public ArrayList<Professor> retornarDadosProfessor() {

		return professores;

	}

	public void salvarEmArquivo(String caminhoArquivo) {
		try {
			FileWriter arquivo = new FileWriter(caminhoArquivo);
			PrintWriter gravador = new PrintWriter(arquivo);

			for (Professor professor : professores) {
				gravador.println( 
						"\n nome:" + professor.getNome() +  
						"\n cpf:" + professor.getCpf() + 
						"\n curso:" + professor.getCurso() +   
						"\n data de nascimento:" + professor.getData_nasc() + 
						"\n carga horaria:" + professor.getCarga_horaria() + 
						"\n idade:" + professor.getIdade()+
						"\n Titulacao  "+ professor.getTitulacao());

			}

			gravador.close();
			System.out.println("Dados salvos no arquivo: " + caminhoArquivo);
		} catch (IOException e) {
			System.out.println("Erro ao salvar dados no arquivo: " + e.getMessage());
		}
	}

}