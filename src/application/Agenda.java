package application;

// CLASSE AGENDA
public class Agenda {

	//	CONSTRUTORES
	public Agenda() {
		address = new Address();
	}
	
	public Agenda(String name, String email, String phone, String street, String number, String neighborhood, String zip) {
		
		count++; 			// incrementa o contador 
		id = count; 		// atribui um id para o objeto
		setName(name); 		// instancia o nome
		setEmail(email); 	// instancia o email
		setPhone(phone); 	// instancia o telefone
		address = new Address(street, number, neighborhood, zip); // instancia o endereço
		
	}
	
//	ATRIBUTOS
	private static int count = 0;	// variável para contabilizar quantas instancias foram criadas dessa classe
	private int id;					// id do aluno
	private String name; 	 		// nome do aluno
	private String phone; 	 		// telefone do aluno
	private Address address; 		// endereço do aluno - instancia da classe endereço
	private String email; 	 		// email do aluno
	
//	GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
//	MÉTODOS
	// método toString()
    public String toString() {
    	return String.format("Nome: %s | Tel: %s | Email: %s\n%s", getName(), getPhone(), getEmail(), getAddress().toString());
    }
     
}


