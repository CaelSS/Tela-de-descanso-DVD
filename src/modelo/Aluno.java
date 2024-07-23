package modelo;

public class Aluno extends Pessoa {

	
	public Aluno(String nome, String idade, String cpf, String data_nasc, String curso, String matricula) {
		super();
		this.curso = curso;
		this.matricula = matricula;
	}
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	private String curso;
	private String matricula;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	


}
