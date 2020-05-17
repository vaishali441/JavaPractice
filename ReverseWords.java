package rough;

public class ReverseWords {

	public static void main(String[] args) {
       String line = "I am a Super Automation resource";
       String arr[] = line.split("\\s");
       for(int i = arr.length-1 ; i>=0;i--)
       {
    	   System.out.print(arr[i] + " ");
       }
	}

}
