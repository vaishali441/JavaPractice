package com.string.day2;

/*Input: "When the world realise its own mistake, corona will dissolve automatically"
output: "When eht world esilaer its nwo mistake, anoroc will evlossid automatically"
*/
public class Altrev_1 {

	public static void main(String[] args) {
      
		String input = "When the world realise its own mistake, corona will dissolve automatically";
		String output = "";
		String arr[] = input.split("\\s");
		int len = arr.length;
		for(int i =0 ; i < len ; i++)
		{
			String word1 = "";
			if(i%2 != 0) {
				String word = arr[i];
				
				char  letter[] = word.toCharArray();
				for(int j = word.length()-1 ; j >= 0; j--)
					{
						word1 = word1 + letter[j];
					}
			}
			else
			{
				word1 = arr[i];	
			}
			
			output = output + " " + word1;
			
			
			
		}
		
		System.out.println(output);
	}

}
