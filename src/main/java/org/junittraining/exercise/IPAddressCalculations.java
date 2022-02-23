package org.junittraining.exercise;

public interface IPAddressCalculations {
    /**
     * <p>
     * Converts an IP Address string to a numeric representation of the IP Address.
     * </p>
     * 
     * <p>
     * The IP Address is converted the following way:
     * </p>
     * <ul>
     * <li>the IP address (IPV4) is divided into 4 sub-blocks: w.x.y.z</li>
     * <li>Each sub-block has a different weight number each powered by 256.</li>
     * </ul>
     * 
     * <p>
     * If an IP address has the following format: w.x.y.z, then the
     * IP Number is calculated based on the following formula:
     * 
     * <pre>
     * IP Number = 16777216*w + 65536*x + 256*y + z
     * </pre>
     * </p>
     * 
     * @param ipAddress the IPV4 address as a String in the w.x.y.z format, such as '192.168.0.1'
     * @throws IllegalArgumentException if an invalid IP Address is provided
     * 
     * @see http://lite.ip2location.com/faqs (see: How do I convert an IPv4 address to an IP Number?)
     */
    public long ipAddressToIPNumber(String ipAddress);

}