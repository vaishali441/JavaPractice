package rough;

public class RemoveSpecial {

	public static void main(String[] args) {
   String a = "Va!&i$sha@li#";
   
   String output = a.replaceAll("[^a-zA-Z]", "");
   System.out.println(output);
	}

}
