
public class Colega implements Comparable<Colega> {
	
	private String nome;
	private String celular;
	
	public Colega(String nome, String celular) {
		super();
		this.nome = nome;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int compareTo(Colega c) {
		return this.nome.compareToIgnoreCase(c.getNome());
	}
	
	public String toString(){
		return "Nome: " + this.nome + "\nCelular: " + this.celular;
	}
	
}