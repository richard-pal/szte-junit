package org.junittraining;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the TelephoneNumberUtils class.
 */
public class TelephoneNumberUtilsTest {

    private TelephoneNumberUtils instance;

    @Before
    public void setup() {
        instance = new TelephoneNumberUtils();
    }

    @Test
    public void test_validPhoneNumber() {
        assertTrue(instance.isBudapestLandline("+3611234567"));
    }

    @Test
    public void test_validPhoneNumberIntervall() {
        assertTrue(instance.isBudapestLandline("+3619999999"));
    }

    @Test
    public void test_validPhoneNumberIntervall2() {
        assertTrue(instance.isBudapestLandline("+3619999999"));
    }

    @Test
    public void test_tooShortPhoneNumber() {
        assertFalse(instance.isBudapestLandline("+361000000"));
    }

    @Test
    public void test_invalidCharacterPhoneNumber() {
        assertFalse(instance.isBudapestLandline("+361000000x"));
    }

    @Test
    public void test_invalidStartChar() {
        assertFalse(instance.isBudapestLandline(" +3610000000"));
    }
    
    @Test
    public void test_invalidEndChar() {
        assertFalse(instance.isBudapestLandline("+3610000000x"));
    }

    /** Example for a failing test. */
    @Test(expected = IllegalArgumentException.class)
    public void test_null() {
        assertFalse(instance.isBudapestLandline(null));
    }

    @Test
    public void test_multiline() {
        assertThat(instance.isBudapestLandline("+3611234567\n+3611234567")).isFalse();
    }

}
