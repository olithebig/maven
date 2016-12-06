
import org.junit.Test;

import olivermattes.Util;

import static org.junit.Assert.*;

import org.junit.Before;


public class UtilTest
{	
	
 
	
	
	@Test
	public void testistErstesHalbjahr()
	{
		
		assertTrue("galt als Falsch", Util.istErstesHalbjahr(6));
	}
	@Test
	public void test2istErsteshalbjahr()
	{
		assertTrue("galt als richtig", !Util.istErstesHalbjahr(8));
	}
	@Test
	public void test3istErsteshalbjar()
	{
		assertTrue("7 ist erstes", !Util.istErstesHalbjahr(7));
	}
	
	
	
}