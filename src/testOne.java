package ABR;
import static org.junit.Assert.*;

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
		a.insert(2);
		a.insert(0);
		assertTrue(a.nbElements() == 3);
		assertTrue(a.getD().getRootValue()==2);
		assertTrue(a.getG().getRootValue()==0);
	}

}
