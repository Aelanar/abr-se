package ABR;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class testOne {

	@Test
	public void testInitGetter() {
		ABR a = new ABR();
		assertTrue(a.isEmpty());
		ABR b = new ABR(1,a,a);
		assertFalse(b.isEmpty());
		assertTrue(b.getD().isEmpty());
		assertTrue(b.getG().isEmpty());
		assertTrue(b.getRootValue()==1);
	}
	
	@Test
	public void testNbElements() {
		ABR a = new ABR();
		ABR b = new ABR(1,a,a);
		ABR c = new ABR(2,b,b);
		assertTrue(b.nbElements()==1);
		assertTrue(c.nbElements()==3);
		
	}
	@Test
	public void testInsert(){
		ABR a = new ABR();
		a.insert(1);
		a.insert(1);
		a.insert(2);
		a.insert(0);
		assertTrue(a.nbElements() == 3);
		assertTrue(a.getD().getRootValue()==2);
		assertTrue(a.getG().getRootValue()==0);
	}
	
	@Test
	public void testContains(){
		ABR a = new ABR();
		a.insert(1);
		a.insert(2);
		a.insert(0);
		assertTrue(a.contains(0));
		assertTrue(a.contains(1));
		assertTrue(a.contains(2));
		assertFalse(a.contains(42));
	}
	@Test
	public void testToList(){
		ABR a = new ABR();
		ABR c = new ABR();
		a.insert(1);
		a.insert(2);
		a.insert(0);
		for (int i=0;i<30;i++){
			c.insert(i);
		}
		ArrayList<Integer> l1=new ArrayList<Integer>();
		ArrayList<Integer> l2=new ArrayList<Integer>();
		a.toList(l1);
		c.toList(l2);
		
		assertTrue(l1.contains(0));
		assertTrue(l1.contains(1));
		assertTrue(l1.contains(2));
		assertFalse(l1.contains(42));
		
		//System.out.print(l2);
		
	}
	
	
}
