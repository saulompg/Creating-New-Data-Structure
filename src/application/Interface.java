package application;

// IMPORTAÇÕES
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;


// CLASSE PRINCIPAL DA APLICAÇÃO
public class Interface {

//  INSTANCIANDO O OBJETO SCANNER PARA ENTRADA DE DADOS
	static Scanner sc = new Scanner(System.in);
	
//	MÉTODO MAIN
	public static void main(String[] args) {
		
//		DECLARAÇÃO DAS VARIÁVEIS AUXILIARES
		Agenda temp_aluno;
		String temp_nome;
		String temp_email;
		String temp_telefone;
		String temp_rua;
		String temp_numero;
		String temp_bairro;
		String temp_cep;
		
//		INSTANCIANDO O CLIP
		final int tamanho = 5; // Define o tamanho do monte
		Clip agenda = new Clip(tamanho);
		
		String sair = ""; // variável auxiliar para manter o programa em execução
		
		// Enquanto não for escolhida a opção 0 no menu, o programa continua rodando
		while(!sair.equals("0")) {
			
			// Exibe o menu de navegação e recebe do usuário o valor referente à opção desejada
			sair = menu();
			System.out.printf("\n");
			
			// Direciona o funcionamento do programa segundo a opção escolhida pelo usuário
			switch(sair) {
			
			case "0":
				
				System.out.printf("Finalizando o programa \n");
				break;
				
			case "1":
				
				System.out.printf("-- Cadastrando novo aluno -- \n");
				
				// recebe do usuário o nome do aluno
				System.out.printf("Nome: ");
				temp_nome = sc.nextLine().trim().toUpperCase();
				
				// recebe do usuário o email do aluno
				System.out.printf("Email: ");
				while(!isValidEmailRegex(temp_email = sc.nextLine().trim())) {
					System.err.printf("O email informado não é válido! \n");
					System.out.printf("Email: ");
				}
				
				// recebe do usuário o telefone do aluno
				System.out.printf("Telefone: ");
				// realiza a verificação no telefone informado
				while(!isValidPhoneRegex(temp_telefone = sc.nextLine().replaceAll(" ",""))) { // enquanto estiver incorreto, pede ao usuário para inserir novamente
					System.err.printf("O telefone informado é inválido! \n");
					System.err.printf("\t- (DDD) 9XXXX-XXXX \n");
					System.err.printf("\t- Digite apenas números \n");
					System.out.printf("Telefone: ");
				}
				temp_telefone = formatPattern(temp_telefone, "(##) #####-####"); // coloca o telefone informado no padrão correto
				
				// recebe do usuário o endereço do aluno
				System.out.printf("Logradouro: ");
				temp_rua = sc.nextLine().trim();
				
				System.out.printf("Número: ");
				temp_numero = sc.nextLine().trim();
				
				System.out.printf("Bairro: ");
				temp_bairro = sc.nextLine().trim();
				
				// recebe do usuário o CEP do usuário
				System.out.printf("CEP: ");
				// realiza a verificação no CEP informado
				while(!isValidCepRegex(temp_cep = sc.nextLine().trim())) { // enquanto estiver incorreto, pede ao usuário para inserir novamente
					System.err.printf("O CEP informado é inválido! Digite apenas números \n");
					System.out.printf("CEP: ");
				}
				temp_cep = formatPattern(temp_cep, "#####-###"); // coloca o CEP informado no padrão correto
				
				// instancia o objeto aluno
				temp_aluno = new Agenda(temp_nome, temp_email, temp_telefone, temp_rua, temp_numero, temp_bairro, temp_cep);
				
				// adiciona o objecto aluno à agenda
				agenda.add(temp_aluno);
				
				break;
				
			case "2":
				
				// remove aluno da agenda
				temp_aluno = agenda.remove();
				
				if(temp_aluno == null) // se não há alunos cadastrados, exibe uma mensagem
					System.out.printf("Não há alunos cadastrados em nossa Agenda \n");
				else // se há, exibe o aluno que foi removido
					System.out.printf("Removendo -> ID: %d | aluno: %s \n", temp_aluno.getId(), temp_aluno.getName());
				
				break;
				
			case "3":
				
				System.out.printf("-- Agenda de Alunos -- \n");
				if(!agenda.print()) { // verifica se há e exibe os alunos cadastrados na agenda
					System.out.printf("Não há registros cadastrados. \n"); // caso não haja, exibe uma mensagem
					break;
				}
				
				System.out.printf("-- Último aluno cadastrado \n");
				temp_aluno = agenda.get(); 		// retorna o primeiro elemento no Clip
				System.out.println(temp_aluno);	// exibe mais informações sobre o aluno	
				break;
			
			case "4":
				
				System.out.print("Insira o ID (0 - VOLTAR): ");
				int id = sc.nextInt();	// recebe o ID para apresentar mais informações do aluno
				sc.nextLine(); 			// captura o \n
				if(id == 0) 			// se o ID for 0, volta ao menu inicial
					break;
				else
					System.out.println(); // imprime uma quebra de linha
				
				temp_aluno = getById(agenda, id); // procura se há aluno no agenda com o ID informado
				if(temp_aluno == null) // se não há, exibe mensagem
					System.out.printf("Não há alunos cadastrados com o ID %d \n", id);
				else { // se há, exibe informações do aluno
					System.out.printf("-- ID: %d \n", id);
					System.out.printf(temp_aluno + "\n");
				}
				
				break;
				
			default:
				// caso a opção escolhida no menu não corresponda às opções
				System.err.printf("Opção Inválida! \n"); 
				break;
				
			}
			
			System.out.println(); // pula uma linha antes de reiniar o loop
			
		}
		
		sc.close(); // encerra o scanner
		
	}	
	
//	MÉTODO PARA ENCONTRAR UM ALUNO VIA ID
	static Agenda getById(Clip agenda, int id) {
		
		// cria um Clip temporário para armazenar os elementos da agenda
		Clip temp_agenda = new Clip(agenda.size());
		
		// instancia uma variável temporária para armazenar o aluno
		Agenda temp_aluno = null;
		
		while(!agenda.isEmpty()) {
			
			temp_aluno = agenda.remove(); 		 // retorna o primeiro aluno da agenda
			temp_agenda.add(temp_aluno); 		 // armazena o aluno no Clip temporário
			
			if(temp_aluno.getId() == id) {		 // verifica se o id é igual ao procurado
				break;
			} else {
				temp_aluno = null; // atribui o valor null à variável temp_aluno
			}
			
		}
		
		while(!temp_agenda.isEmpty()) {
			agenda.add(temp_agenda.remove());
		}

		return temp_aluno;
		
	}
	
	
//	MÉTODO DE EXIBIÇÃO DO MENU
	static String menu() {
		
		// exibe as opções do menu
		System.out.printf("+-------------------------------+ \n");
		System.out.printf("+        ICTI - Data Base       + \n");
		System.out.printf("+-------------------------------+ \n");
		System.out.printf("| 1 - Cadastrar novo aluno      | \n");
		System.out.printf("| 2 - Remover aluno cadastrado  | \n");
		System.out.printf("| 3 - Exibir alunos cadastrados | \n");
		System.out.printf("| 4 - Pesquisar aluno por ID    | \n");
		System.out.printf("| 0 - SAIR                      | \n");
		System.out.printf("+-------------------------------+ \n");
		System.out.print("Escolha uma opção: ");
		String option = sc.nextLine(); // registra a opção escolhida pelo usuário
		
		return option; // retorna a opção escolhida
		
	}
	
	
//  MÉTODOS DE VALIDAÇÃO DE DADOS
	// verifica se o email informado é válido
    private static boolean isValidEmailRegex(String email) {
        
    	boolean isEmailIdValid = false; // inicializa uma variável auxiliar com o valor False
        
    	if(email != null && email.length() > 0) { // verifica se a string não é nula nem está vazia
    		
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";				// Expressão Regular que identifica o padrão do email
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);	// Compila a expressão em um padrão 
            Matcher matcher = pattern.matcher(email);									// Objeto que recebe a String a ser comparada e o padrão definido
            
            if(matcher.matches())
                isEmailIdValid = true; // caso a string coincida com o padrão, a variável recebe o valor True

        }
    	
        return isEmailIdValid; // retorna o valor da variável auxiliar
        
    }
    
    // verifica se o telefone informado é válido
    private static boolean isValidPhoneRegex(String phone) {
    	
    	boolean isPhoneIdValid = false; // inicializa uma variável auxiliar com o valor False
    	
    	if(phone != null && phone.length() > 0) { // verifica se a string não é nula nem está vazia
    		
    		String expression = "^(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])9[1-9][0-9]{7}$"; // Expressão Regular que identifica o padrão do telefone
    		Pattern pattern = Pattern.compile(expression);	// Compila a expressão em um padrão
    		Matcher matcher = pattern.matcher(phone); 		// Objeto que recebe a String a ser comparada e o padrão definido
    		
    		if(matcher.matches())
    			isPhoneIdValid = true; // caso a string coincida com o padrão, a variável recebe o valor True
    		
    	}
    	
    	return isPhoneIdValid; // retorna o valor da variável auxiliar
    	
    }
    
    // verifica se o CEP informado é válido
    private static boolean isValidCepRegex(String cep) {
    	
    	boolean isCepIdValid = false; // inicializa uma variável auxiliar com o valor False
    	
    	if(cep != null && cep.length() > 0) {				// verifica se a string não é nula nem está vazia
    		
    		String expression = "^[0-9]{8}$";				// Expressão Regular que identifica o padrão do CEP
    		Pattern pattern = Pattern.compile(expression);	// Compila a expressão em um padrão
    		Matcher matcher = pattern.matcher(cep);			// Objeto que recebe a String a ser comparada e o padrão definido
    		
    		if(matcher.matches())
    			isCepIdValid = true; // caso a string coincida com o padrão, a variável recebe o valor True
    		
    	}
    	
    	return isCepIdValid; // retorna o valor da variável auxiliar
    	
    }
    
	// formata o valor recebido com base no padrão determinado
    private static String formatPattern(String value, String pattern) {
        
    	MaskFormatter mf; // declara um objeto MaskFormatter
        try {
        	
            mf = new MaskFormatter(pattern); // instancia um objeto passando o padrão da máscara
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value); // retorna a String com o valor atribuido à máscara
            
        } catch (ParseException ex) {

        	return value; // se houver erro, retorna o valor original
        	
        }
    
    }
	
}
