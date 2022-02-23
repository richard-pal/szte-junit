package org.junittraining;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * In this example the AssertJ library is used for result validation
 * 
 * @see https://assertj.github.io/doc/
 * @see https://en.wikipedia.org/wiki/Fluent_interface
 */
public class CalculatorTest2_AssertJ {

    private Calculator calculator; // the instance of the "class-under-test"

    @Before
    public void setUp() throws Exception {
        // before executing each individual testcase, construct the object to test:
        calculator = new Calculator();
    }

    @Test
    public void testAddShouldAddNumbersWhenBothNumbersAreNegative() {
        // 1) execute the operation with your planned arguments
        long result = calculator.add(-1, -2);
        // 2) verify if the result matches your expectations. We use here:
        // org.assertj.core.api.Assertions.assertThat()
        assertThat(result).isEqualTo(-3);
    }
}
