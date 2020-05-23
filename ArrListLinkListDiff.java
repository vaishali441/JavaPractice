package rough;

import java.util.ArrayList;
import java.util.LinkedList;

//Both implements List interface
public class ArrListLinkListDiff {

	public static void main(String[] args) {
       ArrayList al = new ArrayList();
       al.add("B");
       al.add("A");
       
       al.add("C");
       System.out.println(al);    //[B, A, C]   - maintains insertion order
       
       LinkedList ll = new LinkedList();
       ll.add("C");
       ll.add("A");
       ll.add("B");
       
       System.out.println(ll); //[C, A, B] - maintains insertion order
       
       
		/*
		 * 1)ArrayList internally uses dynamic array to store the elements . Linked list
		 * uses doubly linked list to store the elements
		 * 
		 * 2)Search will be faster in ArrayList as its index-based Search will slow in
		 * linkedlist compared to ArrayList
		 * 
		 * 3)Add and remove will be slow in arraylist and in linkedlist add and remove
		 * will be fast
		 * 
		 * 4)ArrayList acts a list only but Linkedlist acts a both list and queue 
		 * as it  implements Deque interface
		 */
       
		/*
		 * when to go for what
		 *  if there is a req where less search and addition, removal
		 * is more then Linkedlist is best 
		 * or else 
		 * if there is more search and add,
		 * remove is less then we can go for Arraylist
		 */
         
       
       
       
	}

}
