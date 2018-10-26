package jtl.utils;

public class WhereAmI {

	public static boolean insideOSGI = false;

	/**
	 * Detect if JTL is running inside Eclipse.
	 * @return true if JTL is running inside Eclipse
	 */
	public static boolean isEclipse() {
	    return System.getProperty("java.class.path").contains("eclipse");
	}

	/**
	 * Detect if JTL is running inside OSGI.
	 * @return true if JTL is running inside OSGI
	 */
	public static boolean isOSGI() {
		return insideOSGI;
	}
}
