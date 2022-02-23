package org.junittraining;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a very simple, level-0 unit test. Assertions are "hand-coded" or
 * based on JUnit's basic assert functions
 * 
 * @see http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 */
public class CalculatorTest0_Basic {

    private Calculator calculator; // the instance of the "class-under-test"

    @Before
    public void setUp() throws Exception {
        // before executing each individual testcase, construct the object to test:
        calculator = new Calculator();
    }

    @Test
    public void testAddShouldAddNumbersWhenBothNumbersArePositive() {
        // 1) execute the operation with your planned arguments
        long result = calculator.add(1, 1);

        // 2) verify if the result matches your expectations.
        // We use here a "code-heavy" version here:
        if (result != 2) {
            throw new AssertionError("Result is not exactly what we were expecting");
        }

        // We use here org.junit.Assert.assertEquals() to do the same validation:
        assertEquals(2, result);
    }
}