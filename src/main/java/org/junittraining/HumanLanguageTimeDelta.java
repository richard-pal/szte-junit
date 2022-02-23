package org.junittraining;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class helps in the interpretation of human language inputs expressing
 * time periods.
 */
public class HumanLanguageTimeDelta {

    private static final Pattern pastPattern = Pattern.compile("(?i)(\\d*) (minute|hour|day)s? ago");

    /**
     * This function parses phrase like '5 minutes ago' or '10 hours ago' or '7 days
     * ago' and returns the time offset as minutes.
     * 
     * @throws IllegalArgumentException if the phrase can not be parsed
     */
    public int interpret(final String phrase) {
        
        if (phrase == null) {
            throw new IllegalArgumentException("the phrase cannot be null");
        }

        final Matcher m = pastPattern.matcher(phrase);

        if (m.matches()) {
            int minutes = 0;

            final String number = m.group(1);
            final String unit = m.group(2).toLowerCase();

            final int value = Integer.parseInt(number);

            switch (unit) {
                case "minute":
                    minutes = value;
                    break;
                case "hour":
                    minutes = value * 60;
                    break;
                case "day":
                    minutes = value * 60 * 24;
                    break;
                default:
                    throw new UnsupportedOperationException("this unit is not yet supported");
            }

            return minutes;
        } else {
            throw new IllegalArgumentException(
                    "The provided phrase can not be interpreted. It does not follow the required syntax.");
        }
    }

}
