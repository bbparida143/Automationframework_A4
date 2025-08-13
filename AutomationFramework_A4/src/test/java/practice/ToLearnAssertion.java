package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ToLearnAssertion {
	@Test
	public void toLearnAssertion() {
		System.out.println("STEP_1");
		System.out.println("STEP_2");
		//ASSERTION
		//Assert.assertEquals(false, true);
		SoftAssert sa = new SoftAssert();
	    sa.assertEquals(true, false);
		System.out.println("STEP_3");
		System.out.println("STEP_4");
		sa.assertAll();
	}

}
