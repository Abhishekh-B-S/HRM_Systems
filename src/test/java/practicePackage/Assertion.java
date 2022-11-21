package practicePackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	
	
	@Test
	public void create()
	{
		String a ="mysore";
		String b="bangalore";
		System.out.println("-----Line1-----");
		System.out.println("-----Line2-----");
		System.out.println("-----Line3-----");
		Assert.assertEquals("a", "b", "Invalid identifier");
		assertTrue(a.equals(b));
		System.out.println("-----Line4-----");
		System.out.println("-----Line5-----");
	}
	
	@Test
	public void update()
	
	{
		String x=null;
		System.out.println("-----Line6-----");
		System.out.println("-----Line7-----");
		SoftAssert sa = new SoftAssert();
		//sa.assertEquals("a", "n", "Invalid Identifier");
		assertNull(x);
		System.out.println("-----Line8-----");
		System.out.println("-----Line9-----");
		System.out.println("-----Line10-----");
		sa.assertAll();
	}

	
	
	

}
