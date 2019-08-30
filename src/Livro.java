import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Livro implements Comparable<Livro> {
	
	private String titulo;
	private String autor;
	private int valor;
	private boolean emprestado;//define situacao, se esta emprestado ou nao
	private GregorianCalendar dataEmprestimo;
	private Colega c;//caso o livro esteja emprestado armazena o colega que o emprestou
	
	public Livro(String titulo, String autor, int valor){
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
		this.emprestado = false;
		this.dataEmprestimo = null;
	}
	
	public Livro(String titulo, String autor, int valor, GregorianCalendar dataEmprestimo) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
		this.emprestado = false;
		this.dataEmprestimo = (dataEmprestimo);
	}
	
	public Livro(String titulo, String autor, int valor, int dia, int mes, int ano) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
		this.emprestado = false;
		this.setDataEmprestimo(new GregorianCalendar(ano, mes - 1, dia));
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public boolean isEmprestado() {
		return emprestado;
	}
	
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	public GregorianCalendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(GregorianCalendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public Colega getC(){
		if (this.isEmprestado()){
			return this.c;
		}else{
			return null;
		}
	}
	
	public void setC(Colega c){
		this.c = c;
	}
	
	public int compareTo(Livro l) {
		return this.getTitulo().compareToIgnoreCase(l.getTitulo());
	}
	
	public String toString(){
		if (this.emprestado){
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	        String sData = sdf.format(this.dataEmprestimo.getTime());
			return "Livro: " + this.titulo + "\nAutor: " + this.autor + "\nValor de emprestimo: " + valor + 
					"\nSituacao: emprestado por " + c.getNome() + "\nData de emprestimo: " + sData;
		}else{
			return "Livro: " + this.titulo + "\nAutor: " + this.autor + "\nValor de emprestimo: " + valor + 
					"\nSituacao: nao emprestado";
		}
	}
	
}