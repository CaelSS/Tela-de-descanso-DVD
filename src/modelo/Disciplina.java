package modelo;

public class Disciplina {
	
	private String nome;
	private String codigoDaDisciplina;
	private String profDisciplina;
	private String numeroSala;
	private String horasAula;
	
	
	
	public Disciplina() {
		
	}



	public Disciplina(String nome, String codigoDaDisciplina, String profDisciplina, String numeroSala, String horasAula) {
		super();
		this.nome = nome;
		this.codigoDaDisciplina = codigoDaDisciplina;
		this.profDisciplina = profDisciplina;
		this.numeroSala = numeroSala;
		this.horasAula = horasAula;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCodigoDaDisciplina() {
		return codigoDaDisciplina;
	}



	public void setCodigoDaDisciplina(String string) {
		this.codigoDaDisciplina = string;
	}



	public String getProfDisciplina() {
		return profDisciplina;
	}



	public void setProfDisciplina(String string) {
		this.profDisciplina = string;
	}



	public String getNumeroSala() {
		return numeroSala;
	}



	public void setNumeroSala(String numeroSala) {
		this.numeroSala = numeroSala;
	}



	public String getHorasAula() {
		return horasAula;
	}



	public void setHorasAula(String horasAula) {
		this.horasAula = horasAula;
	}



	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", codigoDaDisciplina=" + codigoDaDisciplina + ", profDisciplina="
				+ profDisciplina + ", numeroSala=" + numeroSala + ", horasAula=" + horasAula + "]";
	}



	public void add(Disciplina disciplina) {
		// TODO Auto-generated method stub
		
	}










	
	
	
	
	
	
	

}
