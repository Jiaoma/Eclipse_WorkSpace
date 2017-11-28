package linkedlist;

import java.util.*;

public class LinkedListTest {
	public static void main(String[] args)
	{
		List<String> a= new LinkedList<>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		
		List<String> b= new LinkedList<>();
		b.add("Bob");
		b.add("Doung");
		b.add("Farances");
		b.add("Gloar");
		
		ListIterator<String> aIter=a.listIterator();
		Iterator<String> bIter=b.iterator();
		
		while(bIter.hasNext())
		{
			System.out.println(bIter.next());
		}
	}
}
