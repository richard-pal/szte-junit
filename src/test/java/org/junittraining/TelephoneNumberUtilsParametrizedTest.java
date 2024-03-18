package org.junittraining;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TelephoneNumberUtilsParametrizedTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ "+3617654321", true }, 
			{ "+3232323232", false } 
		});
	}
	
	@Parameter(value = 0)
	public String telephoneNumber;
	@Parameter(value = 1)
	public Boolean isBudapestLandline;

	@Test
	public void testPhoneNumber() {
		TelephoneNumberUtils util = new TelephoneNumberUtils();
		System.out.println("Checking now " + telephoneNumber);
		boolean actual = util.isBudapestLandline(telephoneNumber);
		assertThat(actual, is(isBudapestLandline));
	}
}
