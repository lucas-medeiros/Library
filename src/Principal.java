import java.util.Scanner;

public class Principal { 
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		int x = -1;//contador para armazenar a resposta do menu
		do{//menu de selecao
			System.out.println(" ---Menu---");
			System.out.println("0 - sair");
			System.out.println("1 - cadastrar livro");
			System.out.println("2 - cadastrar colega");
			System.out.println("3 - cadastrar emprestimo");
			System.out.println("4 - efetuar devolucao");
			System.out.println("5 - listagem de livros em ordem alfabetica de titulo");
			System.out.print("Informe a opcao desejada: ");
			x = teclado.nextInt();
			teclado.nextLine();
			System.out.println();
			switch(x){
			case 0:
				System.out.println("\nAte a proxima! \n");
				break;
			case 1:
				biblioteca.AddLivro();
				break;
			case 2:
				biblioteca.AddColega();
				break;
			case 3:
				biblioteca.AddEmprestimo();
				break;
			case 4:
				biblioteca.AddDevolucao();
				break;
			case 5:
				biblioteca.ImprimirListaDeLivros();
				break;
			default:
				System.out.println("Numero invalido, por favor insira outro");
				break;
			}
		}while(x != 0);
	}
}