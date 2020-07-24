package java8Basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UncommonStringOutput {

	public static void main(String[] args) 
	{
        String a = "input";
        String b = "upi";
        
        String out = a.concat(b);
        System.out.println(out);
        char outarr[] = out.toCharArray();
        Arrays.sort(outarr);
        for(int i =0 ; i<outarr.length-1;i++)
        {
        	char comm = outarr[i] ;
        	
        	if(outarr[i] ==outarr[i+1])
        	{
        		out = out.replaceAll(Character.toString(comm),"");
        	}
        }
        System.out.println(out);
       
	}

}
