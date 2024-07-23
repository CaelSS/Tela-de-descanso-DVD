package controle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Aluno;
import modelo.Disciplina;

public class ControleAluno {

	private ArrayList<Aluno> alunos = new ArrayList<>();

	public boolean salvarAluno(Aluno aluno) {

		try {

			alunos.add(aluno);
			System.out.println(aluno);

			return true;
		
		} catch (Exception e) {
			System.out.println(e);
			return false;

		}
	}

	public ArrayList<Aluno> retornarDadosDosAlunos() {
		
		return alunos;

	}
	
	  public void salvarEmArquivo(String caminhoArquivo) {
	        try {
	            FileWriter arquivo = new FileWriter(caminhoArquivo);
	            PrintWriter gravador = new PrintWriter(arquivo);
//String nome, String idade, String cpf, String data_nasc, String curso, String matricula
	            for (Aluno aluno : alunos) {
	                gravador.println(" nome:" + aluno.getNome() +
	                                 "\n cpf: " + aluno.getCpf()+
	                                 "\n curso" +aluno.getCurso() +
	                                 "\n data nascimento: " + aluno.getData_nasc() +
	                                 "\n matricula" + aluno.getMatricula()+
	                                 "\n idade" + aluno.getIdade());
	                					
	            }

	            gravador.close();
	            System.out.println("Dados salvos no arquivo: " + caminhoArquivo);
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar dados no arquivo: " + e.getMessage());
	        }
	    }

}
