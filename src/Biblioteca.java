import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Biblioteca {
	
	static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Colega> alColega; //array list de colegas
	private static ArrayList<Livro> alLivro;//array list de livros
	
	public Biblioteca(){
		alLivro = new ArrayList<Livro>();
		alColega = new ArrayList<Colega>();
	}
	
	public int PerguntaDia(){
		int dia = 0;
		while((dia > 31) || (dia < 1)){//evita datas invalidas
			System.out.println("Insira o dia: ");
			dia = teclado.nextInt();
			if((dia > 31) || (dia < 1)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		return dia;
	}
	
	public int PerguntaMes(){
		int mes = 0;
		while((mes > 12) || (mes < 1)){
			System.out.println("Insira o mes: ");
			mes = teclado.nextInt();
			if((mes > 12) || (mes < 1)){
				System.out.println("Numero invalido, por favor insira outro");
			}
		}
		teclado.nextLine();
		return mes;
	}
	
	public int PerguntaAno(){
		int ano = 0;
		System.out.println("Insira o ano: ");
		ano = teclado.nextInt();
		teclado.nextLine();
		return ano;
		
	}
	
	public void AddColega(){
		String nome = "", celular = "";
		System.out.println("Insira o nome do colega: ");
		while(nome.isEmpty()){
			nome = teclado.nextLine();
			if(nome.isEmpty()){
				System.out.println("Nome invalido, por favor insira outro");
			}
		}
		System.out.println("Insira o celular do colega: ");
		while(celular.isEmpty()){
			celular = teclado.nextLine();
			if(celular.isEmpty()){
				System.out.println("Celular invalido, por favor insira outro");
			}
		}
		alColega.add(new Colega(nome, celular));
		System.out.println("Colega " + nome + " adicionado com sucesso");
	}
	
	public void AddLivro(){
		String titulo = "", autor = "";
		int valor = -1;
		System.out.println("Insira o titulo do livro: ");
		while(titulo.isEmpty()){
			titulo = teclado.nextLine();
			if(titulo.isEmpty()){
				System.out.println("Titulo invalido, por favor insira outro");
			}
		}
		System.out.println("Insira o nome do autor do livro: ");
		while(autor.isEmpty()){
			autor = teclado.nextLine();
			if(autor.isEmpty()){
				System.out.println("Nome invalido, por favor insira outro");
			}
		}
		System.out.println("Insira o valor a ser pago para o emprestimo do livro: ");
		while(valor < 0){
			valor = teclado.nextInt();
			teclado.nextLine();
			if (valor < 0){
				System.out.println("Valor invalido, por favor insira outro");
			}
		}
		alLivro.add(new Livro(titulo, autor, valor));
		System.out.println("Livro adicionado com sucesso");
	}
	
	public void AddEmprestimo(){
		int dia, mes, ano, valor = 0;
		boolean achou1 = false, achou2 = false;
		Colega c = null;
		System.out.println("Insira o nome do colega que deseja emprestar o livro: ");
		String nome = teclado.nextLine();
		for (int i = 0; i < alColega.size(); i++) {
			if(alColega.get(i).getNome().compareToIgnoreCase(nome) == 0){
				c = alColega.get(i);
				achou1 = true;
			}
		}
		System.out.println("Insira a data do emprestimo: ");
		dia = this.PerguntaDia();
		mes = this.PerguntaMes();
		ano = this.PerguntaAno();
		System.out.println("Insira o titulo do livro que deseja emprestar: ");
		String titulo = teclado.nextLine();
		for (int i = 0; i < alLivro.size(); i++) {
			if (alLivro.get(i).getTitulo().compareToIgnoreCase(titulo) == 0){
				Livro l = alLivro.get(i);
				if(l.isEmprestado()){
					achou2 = false;
				}else{
					l.setC(c);
					achou2 = true;
					l.setDataEmprestimo(new GregorianCalendar(ano, mes - 1, dia));
					l.setEmprestado(true);
					valor = l.getValor();
				}
			}
		}//em casa de nao encontrar livro, colega ou livro ja estar emprestado imprime mensagem de erro
		if((achou1 == false) || (achou2 == false)){
			System.out.println("Ocorreu um erro na operacao");
		}else{
			System.out.println("Livro emprestado com sucesso");
			System.out.println("O valor a ser pago pelo emprestimo é de: R$" + valor + ",00");
		}
	}
	
	public void AddDevolucao(){
		boolean achou = false;
		String titulo = "";
		System.out.println("Insira o titulo do livro que deseja devolver: ");
		while(titulo.isEmpty()){
			titulo = teclado.nextLine();
			if(titulo.isEmpty()){
				System.out.println("Titulo invalido, por favor insira outro");
			}
		}
		for (int i = 0; i < alLivro.size(); i++) {
			Livro l = alLivro.get(i);
			if(l.getTitulo().compareToIgnoreCase(titulo) == 0){
				achou = true;
				l.setEmprestado(false);
				l.setC(null);
				l.setDataEmprestimo(null);
			}
		}
		if(achou == false){
			System.out.println("Ocorreu um erro na operacao");
		}else{
			System.out.println("Livro devolvido com sucesso");
		}
	}
	
	public void ImprimirListaDeLivros(){
		Collections.sort(alLivro);//coloca em ordem alfabetica de titulo dos livros
		for (int i = 0; i < alLivro.size(); i++) {//percorre array list de livros
			System.out.println(alLivro.get(i) + "\n");//chama o toString redefinido
		}
	}

}