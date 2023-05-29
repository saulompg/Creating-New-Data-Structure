package application;

/*
* Na Estrutura de Dados Clip os Elementos são inseridos sempre no inicio
* do arranjo, deslocando os demais elementos para o final do arranjo;
* Os Elementos são removidos do Clip no inicio do arranjo;
* 
* Author: Saulo Gomes 
*/

// CLASSE Clip
public class Clip {

//	DECLARAÇÃO DE VARIÁVEIS
	private Agenda[] arr;		// arranjo que irá armazenar os elementos
	private int size;			// tamanho máximo do arranjo
	private int lastElement;	// indice do ultimo elemento do arranjo
	
//	CONSTUTOR PADRÃO
	public Clip() {
		
		this(10); // define um tamanho padrão para o Clip
		
	}
	
//	CONSTRUTOR
	public Clip(int size) {

		arr = new Agenda[size];	// instancia o arranjo 'arr' do tipo 'Agenda' e tamanho 'size'
		this.size = size; 		// inicializa a variável 'size'
		lastElement = -1; 		// inicializa a variável 'lastElement'
		
	}
	
//	MÉTODOS
	// verifica se o Clip está vazio
	public boolean isEmpty() {
		
		return lastElement == -1; // checa a condição e retorna True ou False
		
	}
	
	// verifica se o Clip está cheio
	public boolean isFull() {
		
		return lastElement == size - 1; // checa a condição e retorna True ou False
		
	}
	
	// adiciona um novo Elemento no centro do Clip
	public void add(Agenda element) {
		
		// se a fila estivar cheia, exibe uma mensagem indicando e encerra o método
		if(isFull()) {
			System.out.println("O Clip está cheio");
			return;
		}
		
		lastElement++; 							// incrementa o tamanho utilizado no Clip
		for(int i = lastElement; i > 0; i--) 	// percorre o arranjo
			arr[i] = arr[i-1]; 					// move os elementos pra direita
		arr[0] = element; 						// adiciona o novo elemento no centro do Clip
		
	}
	
	// remove um elemento do Clip
	public Agenda remove() {
		
		// se o Clip estiver vazio retorna null
		if(isEmpty())
			return null;
			
		Agenda element; // declara um objeto temporário do tipo Agenda
		
		element = arr[0]; 						// pega o elemento que será removido
		for(int i = 0; i < lastElement; i++) 	// percorre o arranjo
			arr[i] = arr[i+1]; 					// move os Elementos para a esquerda
		lastElement--; 							// decrementa o tamanho utilizado do Clip
		
		// retorna o elemento removido
		return element;
		
	}
	
	// retorna o primeiro elemento do Clip
	public Agenda get() {

		if(!isEmpty())
			return arr[0];
		
		else
			return null;
		
	}
	
	// exibe os elementos do Clip
	public boolean print() {
		
		// se o Clip está vazio, exibe uma mensagem indicando e encerra o método.
		if(isEmpty())
			return false;
		
		// percorre todo o Clip
		for(int i = 0; i <= lastElement; i++)
			System.out.printf("ID: %d | aluno: %s\n", arr[i].getId(), arr[i].getName());
		System.out.println();
		
		return true;

	}
	
	// exibe o tamanho do Clip
	public int size() {
		
		return size;
		
	}
	
}
