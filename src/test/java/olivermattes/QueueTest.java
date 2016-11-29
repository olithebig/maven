package olivermattes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import olivermattes.Queue;

public class QueueTest
{
	Queue qu = null; 
	
	@Before
	public void vorbereitung()
	{
		qu = new Queue(3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testQueueconstruktor()
	{
		qu = new Queue(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test2Queueconstruktor()
	{
		qu = new Queue(-1);
	}
	
	@Test
	public void test3Queueconstruktor()
	{
		qu = new Queue(1);
		assertNotNull("qu existiert nicht" ,qu);
	}
	
	@Test
	public void testeingabe()
	{
		int rein = 4;
		qu.enqueue(rein);
		int raus = qu.dequeue();
		assertEquals("kommt was anderes Raus", rein , raus);
	}
	
	@Test
	public void testuberschreibung()
	{
		int rein1 = 1;
		int rein2 = 2;
		int rein3 = 3; 
		int rein4 = 4; 
		
		qu.enqueue(rein1);
		qu.enqueue(rein2);
		qu.enqueue(rein3);
		qu.enqueue(rein4);
		
		qu.dequeue();
		qu.dequeue();
		 int raus = qu.dequeue();
		assertEquals("fehler bei übschreibung", rein4, raus);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testfehlerpull()
	{
		qu.dequeue();
	}
	
	
	
	
	
}