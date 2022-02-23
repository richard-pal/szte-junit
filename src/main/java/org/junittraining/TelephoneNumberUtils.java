package org.junittraining;

import java.util.regex.Pattern;

public class TelephoneNumberUtils {
    
    /** Checks if a phone number is this format:
     * <pre>+361XXXXXXX</pre>, where X is an arbitrary number.
     * @param telNumber
     * @return true, if the input matches the <pre>+361XXXXXXX</pre> pattern
     */
    public boolean isBudapestLandline(String telNumber) {
        return Pattern.matches("\\+361\\d{7}", telNumber);
    }
}
    

