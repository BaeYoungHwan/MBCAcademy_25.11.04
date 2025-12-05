package cls;

import inter.PrintNameInterface;

public class NameCard {
	String name;
	String phone;
	String email;
	
	// interface
	PrintNameInterface printNameInter;
	
	public NameCard(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public void setPrintNameInter(PrintNameInterface printNameInter) {
		this.printNameInter = printNameInter;
	}
	
	public void print() {
		printNameInter.print(this);
	}	
	
}
