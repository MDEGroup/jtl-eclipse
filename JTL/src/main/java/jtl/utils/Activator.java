package jtl.utils;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		WhereAmI.insideOSGI = true;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		WhereAmI.insideOSGI = false;
	}

}
