package modelo;

public abstract class Pessoa {
	
	private String nome;
	private String idade;
	private String cpf;
	private String data_nasc;
	
	public Pessoa() {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String string) {
		this.cpf = string;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String string) {
		this.data_nasc = string;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", data_nasc=" + data_nasc
				+ ", getNome()=" + getNome() + ", getIdade()=" + getIdade() + ", getCpf()=" + getCpf()
				+ ", getData_nasc()=" + getData_nasc() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
