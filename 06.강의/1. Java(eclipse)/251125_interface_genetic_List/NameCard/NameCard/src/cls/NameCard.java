package cls;

public class NameCard {
	String name;
	String phone;
	String email;
		
	public NameCard(String name, String phone, String email) {		
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	
	PrintNameCard pNameCard;
	
	public void setpNameCard(PrintNameCard pNameCard) {
		this.pNameCard = pNameCard;
	}
	
	public void print() {
		pNameCard.print(this);
	}
	
	PrintNamePhoneCard pNamePhoneCard;

	public void setpNamePhoneCard(PrintNamePhoneCard pNamePhoneCard) {
		this.pNamePhoneCard = pNamePhoneCard;
	}
	
	public void printPhone() {
		pNamePhoneCard.print(this);
	}
	
	
	

}
