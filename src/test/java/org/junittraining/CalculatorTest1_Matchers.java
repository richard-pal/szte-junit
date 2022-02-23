package org.junittraining;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * In this example a more fluent JUnit 4 Assertion (assertThat) is used with a Matcher.
 * 
 * @see https://github.com/junit-team/junit4/wiki/Assertions
 * @see http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
 */
public class CalculatorTest1_Matchers {

    private Calculator calculator; // the instance of the "class-under-test"

    @Before
    public void setUp() throws Exception {
        // before executing each individual testcase, construct the object to test:
        calculator = new Calculator();
    }

    @Test
    public void testAddShouldAddNumbersWhenBothNumbersAreNegative() {
        // 1) execute the operation with your planned arguments
        long result = calculator.add(-1, -1);
        // 2) verify if the result matches your expectations. We use here:
        // org.junit.Assert.assertThat() and org.hamcrest.CoreMatchers.equalTo()
        assertThat(result, equalTo(-2l));
    }
}
