package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/* 
 * This TestCase runs on Junit4 Engine
 * Execution Order - @BeforeClass -> @Before -> @Test -> @After -> @AfterClass
 * @Ignore annotation class/method will not Execute 
 */

public class Annotations {

	@AfterClass
	public static void AfterClassMethod() {
		System.out.println("AfterClass");
	}

	@BeforeClass
	public static void BeforeClassMethod() {
		System.out.println("BeforeClass");
	}

	@After
	public void AfterMethod() {
		System.out.println("After");
	}

	@Before
	public void BeforeMethod() {
		System.out.println("Before");
	}

	@Test
	public void TestMethod() {
		System.out.println("Test");
	}

	@Ignore // The method or class assigned Ignore will not get Executed
	public void IgnoreMethod() {
		System.out.println("Ignore");
	}

}