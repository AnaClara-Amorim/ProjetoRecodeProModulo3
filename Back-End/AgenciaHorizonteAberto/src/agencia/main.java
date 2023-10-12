package agencia;
import java.util.List;
import java.util.Scanner;

import agencia.DAO.CompraDAO;
import agencia.DAO.PacotesDAO;
import agencia.DAO.UsuariosDAO;

public class main {

	public static void main(String[] args) {
		
		int resposta = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nMenu - Agência Horizonte Aberto");
            System.out.println("1. Cadastrar Usuários");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Atualizar Usuários");
            System.out.println("4. Deletar Usuários");
            System.out.println("5. Cadastrar Pacotes");
            System.out.println("6. Listar Pacotes");
            System.out.println("7. Atualizar Pacotes");
            System.out.println("8. Deletar Pacotes");
            System.out.println("9. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                	
                	System.out.println("Você está na opção de cadastro de usuário, preencha os campos a seguir: ");
                	Usuarios usuarioCadastro = new Usuarios();
                	
                	System.out.println("Digite o nome do usuário: ");  
                	usuarioCadastro.setNome(scanner.nextLine());  
                	scanner.nextLine();
                    
                    System.out.println("Digite o endereço do usuário: ");
                    usuarioCadastro.setEndereco(scanner.nextLine());
                    scanner.nextLine();
                    
                    System.out.println("Digite seu email: ");
                    usuarioCadastro.setEmail(scanner.nextLine());
                    scanner.nextLine();
                    
                    System.out.println("Digite sua senha: ");
                    usuarioCadastro.setSenha(scanner.nextLine());
                    scanner.nextLine();
                    
                    UsuariosDAO.create(usuarioCadastro);
                    System.out.println("Cadastro realizado!");
                                                        
                    break;

                case 2:
                	System.out.println("Você está na opção de listar usuários.");
                	
                	for (Usuarios u : UsuariosDAO.getUsers()) {
                		System.out.println("ID: " + u.getIdUsuario());
                		System.out.println("Nome: " + u.getNome());
                		System.out.println("Endereço: " + u.getEndereco());
                		System.out.println("Email: " + u.getEmail());
                		System.out.println("--------------");
                	}
                	                    
                    break;

                case 3:
                	
                	System.out.println("Você está na opção de atualização de usuário, preencha os campos a seguir para atualizar: ");
                	Usuarios usuarioUpdate = new Usuarios();
                	
                	System.out.println("Digite o id do usuário a ser modificado: ");
                	usuarioUpdate.setIdUsuario(scanner.nextInt());
                	scanner.nextLine();
                	
                	System.out.println("Digite o novo nome do usuário: ");  
                	usuarioUpdate.setNome(scanner.nextLine());  
                	scanner.nextLine();
                    
                    System.out.println("Digite o novo endereço do usuário: ");
                    usuarioUpdate.setEndereco(scanner.nextLine());
                    scanner.nextLine();
                    
                    System.out.println("Digite novo seu email: ");
                    usuarioUpdate.setEmail(scanner.nextLine());
                    scanner.nextLine();
                    
                    System.out.println("Digite novo sua senha: ");
                    usuarioUpdate.setSenha(scanner.nextLine());
                    scanner.nextLine();
                    
                    UsuariosDAO.update(usuarioUpdate);
                    System.out.println("Atualização realizada!");
                    break;

                case 4:
                	
                    System.out.println("Você está na opção de deletar usuário");
                    System.out.println("Digite o id do usuário a ser deletado: ");
                    UsuariosDAO.remove (scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Deletado com sucesso!");                    
                 
                    break;

                case 5:

                	System.out.println("Você está na opção de cadastro de pacotes, preencha os campos a seguir: ");
                	Pacotes pacoteCadastro = new Pacotes();

                	System.out.println("Digite o destino do pacote: ");  
                	pacoteCadastro.setDestino(scanner.nextLine());
                	scanner.nextLine();

                	System.out.println("Digite o preço do pacote: ");
                	pacoteCadastro.setPreco(scanner.nextDouble());
                	scanner.nextLine();

                	System.out.println("Digite 'true' (é promoção) ou 'false' (não é promoção) para identificar se é uma promoção ou não: ");
                	pacoteCadastro.setPromocao(scanner.nextLine());  
                	scanner.nextLine();

                	PacotesDAO.create(pacoteCadastro);
                	System.out.println("Cadastro realizado!");

                    break;

                case 6:
                	
                    System.out.println("Você está na opção de listar pacotes.");
                	
                	for (Pacotes u : PacotesDAO.getUsers()) {
                		System.out.println("ID: " + u.getIdPacote());
                		System.out.println("Destino: " + u.getDestino());
                		System.out.println("Preço: " + u.getPreco());
                		System.out.println("Promoção: " + u.getPromocao());
                		System.out.println("--------------");
                	}
                	
                    break;

                case 7:
                	
                	System.out.println("Você está na opção de atualização de pacotes, preencha os campos a seguir para atualizar: ");
                	Pacotes pacoteUpdate = new Pacotes();

                	System.out.println("Digite o id do pacote a ser modificado: ");
                	int idPacoteParaAtualizar = scanner.nextInt();
                	pacoteUpdate.setIdPacote(idPacoteParaAtualizar);

                	System.out.println("Digite o novo nome do destino: ");  
                	scanner.nextLine(); 
                	String novoDestino = scanner.nextLine();
                	pacoteUpdate.setDestino(novoDestino);

                	System.out.println("Digite o novo preço do pacote: ");
                	double novoPreco = scanner.nextDouble();
                	pacoteUpdate.setPreco(novoPreco);

                	System.out.println("Digite true (é promoção) ou false (não é promoção) para identificar se é uma promoção ou não: ");
                	scanner.nextLine(); 
                	String novaPromocao = scanner.nextLine();
                	pacoteUpdate.setPromocao(novaPromocao);
                	
                	PacotesDAO.update(pacoteUpdate);

                	System.out.println("Pacote atualizado!");

                    break;

                case 8:
                	System.out.println("Você está na opção de deletar pacote");
                    System.out.println("Digite o id do pacote a ser deletado: ");
                    PacotesDAO.remove (scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Deletado com sucesso!");
                    break;

                case 9:
                    System.out.println("Você saiu do menu!");
                    resposta = 9;
                    break;

                default:
                    System.out.println("Digite um número de 1 à 9");
            }
        } while (resposta != 9);
    }
		
		//TESTES
	
		 //MÉTODO CREATE - USUÁRIOS 
		
		//Usuarios usuario = new Usuarios (1, "Ana", "PE", "anaa@gmail.com", "123");
		//UsuariosDAO.create(usuario);
		
		/* System.out.println(usuario.getIdUsuario());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getEndereco());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getIdUsuario()); */
		
		//MÉTODO CREATE - PACOTES
		
		//Pacotes pacote = new Pacotes (1, "Irlanda", 2000, true);
		//PacotesDAO.create(pacote);
		 
		/*System.out.println(pacote.getIdPacote());
		System.out.println(pacote.getDestino());
		System.out.println(pacote.getPreco());
		System.out.println(pacote.isPromocao()); */
		
		 //MÉTODO DELETE - USUARIOS E PACOTES
		//UsuariosDAO.remove(1);
		//PacotesDAO.remove(1);
		
		// MÉTODO UPDATE - USUÁRIOS 
		// UsuariosDAO.update(usuario);
		// Fazendo UPDATE de pacote 
		// PacotesDAO.update(pacote);
		
		// MÉTODO GET - USUÁRIOS 
		
		/*for (Usuarios u : UsuariosDAO.getUsers()) {

			System.out.println("Usuário: " + u.getNome());

			System.out.println("Endereço: " + u.getEndereco());

			System.out.println("Email: " + u.getEmail());

			System.out.println("=======================");
	} */
		
		// MÉTODO GET - PACOTES
		
		/* for (Pacotes u : PacotesDAO.getUsers()) {

			System.out.println("Destino: " + u.getDestino());

			System.out.println("Preço da viagem: " + u.getPreco());

			System.out.println("Promocao: " + u.isPromocao());

			System.out.println("=======================");
	} */
		
		
		//Compra compra = new Compra (usuario, pacote, 1);
		//CompraDAO.create(compra);
		
		//CompraDAO.remove(3);
				
	}

	 
