package rough;

public class Encapsulation {

	/*
	 * Encapsulation is hiding the data by making the variables private and showing
	 * only the functionalities thru getter and setter methods
	 */
	
	public static void main(String[] args) {
		
		Encap e = new Encap();
		System.out.println(e.getMoney());
		e.setMoney(2000);
		System.out.println(e.getMoney());

	}
	
//	in your project where you have implemented
//	FCBean and FCBeanMapper  in VDS see to understand 

}
