package org.junittraining.exercise;

/**
 * This is a very basic (and very incorrect) implementation. Use it for creating
 * test and find all the bugs!
 */
public class IPAddressCalculationsHorribleImpl implements IPAddressCalculations {

    @Override

    public long ipAddressToIPNumber(String ipAddress) {

        final long FIRST_IP_BYTE = 16777216;
        final long SECOND_IP_BYTE = 65536;
        final long THIRD_IP_BYTE = 256;

        String[] ipAddressParts;
        long ipNumber;

        ipAddressParts = ipAddress.trim().split("\\.");

        ipNumber = FIRST_IP_BYTE * Long.parseLong(ipAddressParts[0])
                + SECOND_IP_BYTE * Long.parseLong(ipAddressParts[1])
                + THIRD_IP_BYTE * Long.parseLong(ipAddressParts[2])
                + Long.parseLong(ipAddressParts[3]);

        return ipNumber;
    }

}
