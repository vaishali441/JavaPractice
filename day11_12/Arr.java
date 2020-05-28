package day11_12;

public class Arr {

	public static void main(String[] args) {
       char a[] = {'a','k','o','l','m'};
       System.out.println(a);  //akolm
       int b[] = {1,4,7,68,4,3,};
       System.out.println(b);  //[I@15db9742
       
       Integer c[] = {7,2,5,9,0,4};
       System.out.println(c); //[Ljava.lang.Integer;@6d06d69c
       for(int l :c)
       {
    	   System.out.println(l);                               //because these are objects and we cannot print directly
       }
       
       String d[] = {"asd","gjhj","hjh"};
       System.out.println(d); //[Ljava.lang.String;@7852e922
       
       for(String h :d)
       {
    	   System.out.println(h);
       }
    
       
       
	}

}
