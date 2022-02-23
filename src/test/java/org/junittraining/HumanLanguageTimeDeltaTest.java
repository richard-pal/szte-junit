package org.junittraining;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the TelephoneNumberUtils class.
 */
public class HumanLanguageTimeDeltaTest {

    private HumanLanguageTimeDelta instance;

    @Before
    public void setup() {
        instance = new HumanLanguageTimeDelta();
    }

    @Test
    public void test_1MinuteAgo() {
        assertThat(instance.interpret("1 minute ago")).isEqualTo(1);
    }

    @Test
    public void test_0MinuteAgo() {
        assertThat(instance.interpret("0 minute ago")).isEqualTo(0);
    }

    @Test
    public void test_1HourAgo() {
        assertThat(instance.interpret("1 hour ago")).isEqualTo(60);
    }

    @Test
    public void test_2HoursAgo() {
        assertThat(instance.interpret("2 hours ago")).isEqualTo(120);
    }

    @Test
    public void test_uppercase_2HoursAgo() {
        assertThat(instance.interpret("2 HOURS ago")).isEqualTo(120);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_minus2HoursAgo() {
        instance.interpret("-2 hours ago");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_spacesAtStartData() {
        instance.interpret(" 2 hours ago");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_spacesAtEndData() {
        instance.interpret("2 hours ago ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_null() {
        instance.interpret(null);
    }
}
