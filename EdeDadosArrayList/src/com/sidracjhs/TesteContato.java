package com.sidracjhs;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteContato {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ArrayList<Contato> contato = new ArrayList(20);
		//criarContato(3, contato);

		int opcao = 1;
		while (opcao != 0){
			opcao = obterOpcao(scan);
			switch(opcao){
			case 1:{
				System.out.println("ADCIONAR CONTATO");
				adcionarContato(scan,contato);

				break;
			}
			case 2:{
				System.out.println("MOSTRANDO CONTATO");
				obterContato(scan, contato);

				break;
			}
			case 3:{
				System.out.println("ESCOLHER CONTATOS");
				apagarContato(scan, contato);
				break;
			}
			case 4:{
				System.out.println("MOSTRAR TODOS OS CONTATOS");
				mostrarTodos(contato);
				break;
			}
			case 5:{
				System.out.println("APAGAR TODOS OS CONTATOS");
				contato.clear();
				break;
			}
			case 6:{
				System.out.println("TAMANHO DO ARRAY DE CONTATOS");
				contato.size();
				break;
			}
			default:
				break;
			}
		}
		System.out.println("Prgrma terminando");

	}
	public static int obterOpcao(Scanner scan){
		int opcao = -1;
		String entrada;
		boolean entradaValida=false;
		while (!entradaValida){
			System.out.println("DIGITE A OPCAO DESEJADA");
			System.out.println("[1]- ADCIONAR CONTATO");
			System.out.println("[2]- BUSCAR CONTATO");
			System.out.println("[3]- APAGAR CONTATO");
			System.out.println("[4]- MOSTRAR TODOS OS CONTATOS");
			System.out.println("[5]- APAGAR TODOS OS CONTATOS");
			System.out.println("[6]- VER TAMANHO DO ARRAY");

			System.out.println("[0]- SAIR");
			try {
				entrada=scan.nextLine();
				opcao = Integer.parseInt(entrada);
				if(opcao >= 0 && opcao <=4){
					entradaValida = true;
				}else{
					System.out.println("Entrada inválida. Digite novamente");
				}
			}catch (Exception e){
				System.out.println("Entrada inválida. Digite novamente");
			}

		}
		return opcao;
	}
	public static String lerInfo(String inf, Scanner scan){
		System.out.println(inf);
		String entrada = scan.nextLine();
		return entrada;
	}
	public static void adcionarContato(Scanner scan, ArrayList<Contato> lista){
		System.out.println("INFORMAÇÕES DOO CONTATO");
		String nome = lerInfo("Digite o nome",scan);
		String telefone = lerInfo("Digite o telefone",scan);
		String email = lerInfo("Digite o email",scan);
		Contato c = new Contato(nome,telefone,email);

		lista.add(c);
		System.out.println("Contato criado com sucesso");
		System.out.println(c);


	}
	public static void obterContato(Scanner scan,ArrayList<Contato> lista){
		String pesquisa =lerInfo("Digite a posicao contato",scan);
		int posicao = Integer.parseInt(pesquisa);
		try {
			Contato contato =lista.get(posicao);
			System.out.println(contato);
		}catch (Exception e){
			System.out.println("Contato não existe");
		}

	}
	public static void apagarContato(Scanner scan, ArrayList<Contato> lista) {
		String pesquisa =lerInfo("Digite a posicao contato a ser excluido",scan);
		int posicao = Integer.parseInt(pesquisa);
		try {
			lista.remove(posicao);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não encontrado");
		}
	}

	public static void mostrarTodos(ArrayList<Contato> cont){
		System.out.println(cont);
	}

	public static void criarContato(int quantidade,ArrayList<Contato> lista){
		Contato contato;
		for(int i=1; i<quantidade; i++){
			contato = new Contato();
			contato.setNome("Contato "+i);
			contato.setTelefone("9999-9999"+i);
			contato.setEmail("contato"+i+"@emal.com");

			lista.add(contato);
		}

	}

}


