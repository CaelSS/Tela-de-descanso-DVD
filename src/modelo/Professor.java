package modelo;

public class Professor extends Pessoa {

    private String curso;
    private String disciplina;
    private String carga_horaria;
    private String titulacao;
    


    public Professor(String Nome, String idade,String cpf,String data_nasc) {
        super();
        this.curso = curso;
        this.disciplina = disciplina;
        this.carga_horaria = carga_horaria;
        this.titulacao = titulacao;
    }

    
	public Professor() {
		// TODO Auto-generated constructor stub
	}


	public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

	
    
    
}
