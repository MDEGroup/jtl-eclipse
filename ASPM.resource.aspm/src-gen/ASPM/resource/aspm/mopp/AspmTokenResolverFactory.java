/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

/**
 * The AspmTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class AspmTokenResolverFactory implements ASPM.resource.aspm.IAspmTokenResolverFactory {
	
	private java.util.Map<String, ASPM.resource.aspm.IAspmTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, ASPM.resource.aspm.IAspmTokenResolver> featureName2CollectInTokenResolver;
	private static ASPM.resource.aspm.IAspmTokenResolver defaultResolver = new ASPM.resource.aspm.analysis.AspmDefaultTokenResolver();
	
	public AspmTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, ASPM.resource.aspm.IAspmTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, ASPM.resource.aspm.IAspmTokenResolver>();
		registerTokenResolver("TEXT", new ASPM.resource.aspm.analysis.AspmTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34_92", new ASPM.resource.aspm.analysis.AspmQUOTED_34_34_92TokenResolver());
	}
	
	public ASPM.resource.aspm.IAspmTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public ASPM.resource.aspm.IAspmTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, ASPM.resource.aspm.IAspmTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, ASPM.resource.aspm.IAspmTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected ASPM.resource.aspm.IAspmTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private ASPM.resource.aspm.IAspmTokenResolver internalCreateResolver(java.util.Map<String, ASPM.resource.aspm.IAspmTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, ASPM.resource.aspm.IAspmTokenResolver> resolverMap, String key, ASPM.resource.aspm.IAspmTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
