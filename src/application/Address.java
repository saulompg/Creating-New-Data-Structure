package application;

//CLASSE ENDEREÇO
class Address {
	
//	CONSTRUTORES
	public Address() {}

	public Address(String street, String number, String neighborhood, String zip) {
		setStreet(street); 				// instancia a rua
		setNumber(number); 				// instancia o numero
		setNeighborhood(neighborhood);	// instancia o bairro
		setZip(zip); 					// instancia o CEP
	}

//	ATRIBUTOS
	private String street;			// rua da residência do aluno
	private String number;			// número da residência do aluno
	private String neighborhood;	// bairro da residência do aluno
	private String zip;				// CEP da residência do aluno
	
//	GETTERS AND SETTERS
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
//	MÉTODOS
	// método toString()
	public String toString() {
		return String.format("Logradouro: %s, n° %s - Bairro: %s | CEP: %s", getStreet(), getNumber(), getNeighborhood(), getZip());
	}
	
}

